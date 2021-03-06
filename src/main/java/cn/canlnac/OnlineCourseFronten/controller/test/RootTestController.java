package cn.canlnac.OnlineCourseFronten.controller.test;

import cn.canlnac.OnlineCourseFronten.controller.FileController;
import cn.canlnac.OnlineCourseFronten.entity.*;
import cn.canlnac.OnlineCourseFronten.service.*;
import cn.canlnac.OnlineCourseFronten.util.ExcelReader;
import cn.canlnac.OnlineCourseFronten.vo.TestUnit;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 小测
 */
@Controller
@RequestMapping("root/test")
public class RootTestController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;


    /**
     * 进入小测页面
     * @param request
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("show")
    public String showIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {

        return "/backend/testpreview";
    }

    /**
     * 进入小测管理页面
     * @return
     */
    @RequestMapping("manage/show")
    public ModelAndView manage() {
        ModelAndView modelAndView = new ModelAndView();

        //获取作者ID
        Session session = SecurityUtils.getSubject().getSession();
        int userId = Integer.parseInt(session.getAttribute("id").toString());
        List<Course> courses = new ArrayList<Course>();
        for (Course course:courseService.findByUserId(userId)) {
            if (!course.getStatus().equals("delete"))
                courses.add(course);
        }
        modelAndView.addObject("courses",courses);

        modelAndView.setViewName("/backend/testmanage");
        return modelAndView;
    }

    /**
     * 获取小测
     * @param catalogId  章id
     * @return
     */
    @RequestMapping("get")
    @ResponseBody
    public Map getTest(@RequestParam("catalog_id") int catalogId){
        List<Question> questions = questionService.findByCatalogId(catalogId);

        Map map = new HashMap();
        map.put("questions",questions);
        return map;
    }

    /**
     * 删除小测（删除小测后，学生的小测记录任然保存）
     * @param id  小测id
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam("id") int id){
        int i = questionService.delete(id);
        return i>0?"success":null;
    }

    /**
     * 小测试题预览
     * @param request
     * @return
     */
    @RequestMapping("preview")
    @ResponseBody
    public List<Map> preview(HttpServletRequest request){
        return resolve(request);
    }

    /**
     * 解析小测试题
     */
    public List<Map> resolve(HttpServletRequest request){
        String path = "";
        try {
            List<Map> lm = FileController.saveFlie(request);
            path = (String) lm.get(0).get("url");
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (IOException e) {
            return null;
        }

        //解析excel表，由于一个excel中只设一个sheet表，所以只取解析后的第一个
        ArrayList<ArrayList<String>> sheet = ExcelReader.parseExcel(FileController.getSourcesDirectory(request)+path).get(0);

        //试卷
        List<Map> test = new ArrayList<Map>();
        //试卷单元模块
        Map testUnit = null;

        //题目类型
        String type = null;
        //每大题总分
        double score = 0 ;
        //题目集合
        List<Map> questions = new ArrayList<Map>();

        //题目单元
        Map questionUnit = null;

        //选项集合
        Map item = null;

        for (int i=0;i<sheet.size();i++){
            //创建试卷单元模块
            //题目类型、每大题总分放进试卷单元模块
            //创建一个新的题目集合
            //进入新题目类型时，做旧题目块结尾处理
            if (sheet.get(i).get(0).equals("单选题")){
                if (questions.size()>0){
                    testUnit.put("questions",questions);
                    test.add(testUnit);
                }
                testUnit = new HashMap();
                type = "单选题";
                score = Double.parseDouble(sheet.get(i).get(2));
                testUnit.put("type",type);
                testUnit.put("score",score);
                questions = new ArrayList<Map>();
            } else if (sheet.get(i).get(0).equals("多选题")){
                if (questions.size()>0){
                    testUnit.put("questions",questions);
                    test.add(testUnit);
                }
                testUnit = new HashMap();
                type = "多选题";
                score = Double.parseDouble(sheet.get(i).get(2));
                testUnit.put("type",type);
                testUnit.put("score",score);
                questions = new ArrayList<Map>();
            } else if (sheet.get(i).get(0).equals("判断题")){
                if (questions.size()>0){
                    testUnit.put("questions",questions);
                    test.add(testUnit);
                }
                testUnit = new HashMap();
                type = "判断题";
                score = Double.parseDouble(sheet.get(i).get(2));
                testUnit.put("type",type);
                testUnit.put("score",score);
                questions = new ArrayList<Map>();
            }

            //创建一个新的题目单元
            //往题目单元中添加题目类型
            //往题目单元中添加题目
            //清空选项集合
            if (sheet.get(i).get(0).equals("题目")){
                questionUnit = new HashMap();
                questionUnit.put("type",type);
                questionUnit.put("question",sheet.get(i).get(1));
                item = new HashMap();
            }
            //设置选项集合
            if (Pattern.compile("[a-zA-Z]").matcher(sheet.get(i).get(0)).matches()){
                item.put(sheet.get(i).get(0),sheet.get(i).get(1));
            }
            //往题目单元中添加选项集合
            //往题目单元中添加答案
            if (sheet.get(i).get(0).equals("答案")){
                questionUnit.put("item",item);
                List answer = new ArrayList();
                if (sheet.get(i).get(1).length()>1){
                    answer = Arrays.asList(sheet.get(i).get(1).split("-\\|-"));
                } else {
                    answer.add(sheet.get(i).get(1)==null?"":sheet.get(i).get(1));
                }
                System.out.println(answer);
                questionUnit.put("answer",answer);
            }
            //往题目单元中添加解析
            //将题目单元加入题目集合
            if (sheet.get(i).get(0).equals("解析")){
                questionUnit.put("explains",sheet.get(i).get(1)==null?"":sheet.get(i).get(1));
                questions.add(questionUnit);
            }
            //为最后一个单元格，做题目块结尾处理
            if (i+1==sheet.size()){
                testUnit.put("questions",questions);
                test.add(testUnit);
            }
        }

        //对于excel文件不做保留，在此进行删除
        FileController.deleteFile(path,request);
        return test;
    }

    /**
     * 因为与移动端逻辑同步，注释测方法，改用B
     * 创建小测
     * @param request
     * @param courseId      课程id
     * @param parentId      章id
     * @param name          小测名称
     * @return
     */
    @RequestMapping("create")
    @ResponseBody
    public String create(HttpServletRequest request,
                         @RequestParam("course_id") int courseId,
                         @RequestParam("parent_id") int parentId,
                         @RequestParam("name") String name){
        List<Map> test = resolve(request);
        double total = 0;
        for (Map map:test) {
            total += Double.parseDouble(map.get("score").toString());
        }
        String json = null;
        try {
            ObjectMapper mapper = new ObjectMapper(); //json转换器
            json = mapper.writeValueAsString(test); //将上传图片转换成json
        } catch (IOException e) {
            return null;
        }
        Question question = new Question();
        question.setCatalogId(parentId);
        question.setName(name);
        question.setQuestions(json);
        question.setTotal((float) total);
        if (questionService.create(question)>0){
            return "success";
        } else {
            return null;
        }
    }

    /**
     * 进入测试记录展示页面
     * @return
     */
    @RequestMapping("score/show")
    public ModelAndView scoreShow(){
        ModelAndView modelAndView = new ModelAndView();

        Session session = SecurityUtils.getSubject().getSession();
        int userId = Integer.parseInt(session.getAttribute("id").toString());
        List<Course> courses = new ArrayList<Course>();
        for (Course course:courseService.findByUserId(userId)) {
            if (!course.getStatus().equals("delete")){
                courses.add(course);
            }
        }
        modelAndView.addObject("courses",courses);

        modelAndView.setViewName("/backend/scoreShow");
        return modelAndView;
    }

    /**
     * 测试记录列表获取
     * @param nowPage
     * @param testId
     * @return
     */
    @RequestMapping("score/list/get")
    @ResponseBody
    public Map scoreListGet(@RequestParam("nowPage") int nowPage,
                            @RequestParam("test_id") int testId){
        //每页显示10条
        int count = 10;
        //分页开始位置
        int start = (nowPage-1)*count;

        List<Map> returnData = new ArrayList<Map>();
        for (Answer answer: answerService.getAnswersByTestId(start,count,testId)){
            Map unit = new HashMap();
            unit.put("username",userService.findByID(answer.getUserId()).getUsername());
            unit.put("total",answer.getTotal());
            unit.put("date",answer.getDate());
            Profile profile = profileService.findByUserID(answer.getUserId());
            unit.put("universityId",profile.getUniversityId());
            unit.put("realname",profile.getRealname());
            unit.put("department",profile.getDepartment());
            unit.put("major",profile.getMajor());
            returnData.add(unit);
        }

        //获取总条数
        int totalNum = answerService.getCountByTestId(testId);
        //计算总页数
        int totalPage = totalNum%count==0?totalNum/count:totalNum/count+1;

        Map map = new HashMap();
        map.put("returnData",returnData);
        map.put("totalPage",totalPage>0?totalPage:1);

        return map;
    }
}
