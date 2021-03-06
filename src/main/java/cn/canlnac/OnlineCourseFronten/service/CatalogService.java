package cn.canlnac.OnlineCourseFronten.service;

import cn.canlnac.OnlineCourseFronten.entity.Catalog;

import java.util.List;
import java.util.Map;

/**
 * 课程章节事务接口
 */
public interface CatalogService {
    /**
     * 创建章节
     * @param catalog   章节
     * @return          创建成功数目
     */
    int create(Catalog catalog);

    /**
     * 获取指定的章节
     * @param id    章节ID
     * @return
     */
    Catalog findByID(int id);

    /**
     * 更新章节
     * @param catalog   章节
     * @return          成功更新数目
     */
    int update(Catalog catalog);

    /**
     * 获取课程下的所有章节
     * @param courseId  课程ID
     * @return          章节列表
     */
    List<Catalog> getList(int courseId);

    /**
     * 获取课程下的所有章·节(二级树结构)
     * @param courseId  课程ID
     * @return          章节列表
     */
    List<Map> getChapterAndSectionList(int courseId);

    /**
     * 删除章节
     * @param id    章节ID
     * @return      成功删除数目
     */
    int delete(int id);

    /**
     * 获取课程下的所有章
     * @param courseId  课程ID
     * @return          节列表
     */
    List<Catalog> getChapterList(int courseId);

    /**
     * 获取章下的所有节
     * @param chapterId    章id
     * @return             节列表
     */
    List<Catalog> getSectionList(int chapterId);
}