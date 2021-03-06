package cn.canlnac.OnlineCourseFronten.dao;

import cn.canlnac.OnlineCourseFronten.entity.Document;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文档数据接口
 */
@Component
public interface DocumentDao {
    /**
     * 创建文档
     * @param document  文档
     * @return          创建成功数目
     */
    int create(Document document);

    /**
     * 根据ID获取文档
     * @param id    文档ID
     * @return      文档
     */
    Document findByID(int id);

    /**
     * 根据文件url获取文档
     * @param url       文件url
     * @return
     */
    List<Document> findByUrl(@Param("url") String url);

    /**
     * 统计文档数目
     * @param targetType    目标类型，课程：course；章节：catalog
     * @param targetId      目标ID
     * @param type          文件类型,全部：null;视频：video；图片：img；其他：other
     * @return              文档数目
     */
    int count(
            @Param("targetType") String targetType,
            @Param("targetId") int targetId,
            @Param("type") String type
    );

    /**
     * 获取指定类型和目标下的文档
     * @param start         分页开始位置
     * @param count         分页返回数目
     * @param sort          排序：按日期排序：date，按名称：name，按大小：size
     * @param targetType    目标类型，课程：course；章节：catalog
     * @param targetId      目标ID
     * @param type          文件类型,全部：null;视频：video；图片：img；其他：other
     * @return              文档列表
     */
    List<Document> getDocuments(
            @Param("start") int start,
            @Param("count") int count,
            @Param("sort") String sort,
            @Param("targetType") String targetType,
            @Param("targetId") int targetId,
            @Param("type") String type
    );

    /**
     * 删除文档
     * @param id    文档ID
     * @return      删除成功数目
     */
    int delete(int id);
}