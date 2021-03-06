package cn.canlnac.OnlineCourseFronten.controller;

import cn.canlnac.OnlineCourseFronten.entity.Document;
import cn.canlnac.OnlineCourseFronten.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by can on 2016/12/17.
 * 文件管理类
 */
@Controller
@RequestMapping("file")
public class FileController {
    @Autowired
    private DocumentService documentService;

    /**
     * 得到静态资源目录路径，目录不存在就创建
     * @param request
     * @return
     */
    public static String getSourcesDirectory(HttpServletRequest request){
        String SourcesDirectory = request.getSession(true).getServletContext().getRealPath("/")+"/../uploadFiles/";
        //String SourcesDirectory = "/usr/local/tomcat/webapps/files/";
        File file =new File(SourcesDirectory);
        if  (!file .exists()  && !file .isDirectory())
        {
            //目录不存在，创建
            file .mkdir();
        }
        return SourcesDirectory;
    }

    /**
     * 获取文件
     * @param url       文件名，不是全路径，例如：default
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("get")
    public void getFile(@RequestParam(value="url")String url,HttpServletRequest request,HttpServletResponse response) throws IOException {
        File file = new File(getSourcesDirectory(request)+url);
        if (file.isFile() && file.exists()){

            List<Document> document = documentService.findByUrl(url);
            if (document.size()>0){
                response.setHeader("Content-Disposition","attachment;filename="+ document.get(0).getName());
            }

            //文件存在
            long len = file.length();
            //将文件大小添加进返回头部中
            response.setContentLength((int) len);
            byte[] bytes = new byte[(int)len];

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            int r = bufferedInputStream.read( bytes );
            if (r != len)
                throw new IOException("读取文件不正确");
            bufferedInputStream.close();

            OutputStream os = response.getOutputStream();
            os.write(bytes);
            os.flush();
            os.close();
        }
//        File file = new File(getSourcesDirectory(request)+url);
//        if (file.isFile() && file.exists()){
//            Resource resource = new FileSystemResource(file);
//
//            return resource;
//        }
//        return null;
    }

    /**
     * 保存文件
     * @param request
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @RequestMapping("save")
    @ResponseBody
    public static List<Map> saveFlie(HttpServletRequest request) throws NoSuchAlgorithmException, IOException {
        List returnList = new ArrayList();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());

        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator<String> iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file!=null && file.getSize()>0)
                {
                    //获取原文件名
                    String fileName = file.getOriginalFilename();
                    //获取后文件缀名
                    //String suffix = file.getOriginalFilename().split("\\.")[1];

                    //创建新文件名
                    String uuid = UUID.randomUUID().toString();
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(uuid.getBytes());
                    uuid = String.format("%032X", new BigInteger(1, messageDigest.digest()));
                    String fileUrl = uuid;

                    //文件存储路径
                    String path = getSourcesDirectory(request)+fileUrl;
                    //上传
                    file.transferTo(new File(path));

                    Map map = new HashMap();
                    map.put("fileType",file.getContentType());//文件类型
                    map.put("fileSize",file.getSize());//文件大小
                    map.put("url",fileUrl);//新文件名
                    map.put("fileName",fileName);//原文件名
                    returnList.add(map);
                }
            }
        }
        return returnList;
    }

    /**
     * 保存批量文件 <input type="file" name="files"  multiple/>
     * @param request
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @RequestMapping("save/files")
    @ResponseBody
    public static List<Map> saveFlies(HttpServletRequest request) throws NoSuchAlgorithmException, IOException {
        List returnList = new ArrayList();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());

        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //取出一个list的multipartfile
            List<MultipartFile> files = multiRequest.getFiles("files");

            for (MultipartFile file : files)
            {
                //一次遍历所有文件
                //MultipartFile file = multiRequest.getFile(iter.next());
                if(file!=null && file.getSize()>0)
                {
                    //获取原文件名
                    String fileName = file.getOriginalFilename();
                    //获取后文件缀名
                    //String suffix = file.getOriginalFilename().split("\\.")[1];

                    //创建新文件名
                    String uuid = UUID.randomUUID().toString();
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(uuid.getBytes());
                    uuid = String.format("%032X", new BigInteger(1, messageDigest.digest()));
                    String fileUrl = uuid;

                    //文件存储路径
                    String path = getSourcesDirectory(request)+fileUrl;
                    //上传
                    file.transferTo(new File(path));

                    Map map = new HashMap();
                    map.put("fileType",file.getContentType());//文件类型
                    map.put("fileSize",file.getSize());//文件大小
                    map.put("url",fileUrl);//新文件名
                    map.put("fileName",fileName);//原文件名
                    returnList.add(map);
                }
            }
        }
        return returnList;
    }

    /**
     * 删除文件
     * @param fileUrl   文件名，不是全路径，例如：default.png
     * @param request
     */
    public static void deleteFile(String fileUrl,HttpServletRequest request){
        File deleteFile = new File(getSourcesDirectory(request)+fileUrl);
        if (deleteFile.isFile() && deleteFile.exists()){
            deleteFile.delete();
        }
    }
}
