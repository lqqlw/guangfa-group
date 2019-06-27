package com.bbs.dao;

import com.bbs.domain.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 帖子信息dao
 * @author
 */

public interface ArticleDao {
    /**
     * 查找所有帖子
     * @return
     */
    @Select("select * from bbs_article_table")
    List<Article> findAll();

    /**
     * 屏蔽帖子
     * @param articleId
     */
    @Delete("delete from bbs_article_table where articleId = #{articleId} ")
    void deleteArticle(Integer articleId);

    /**
     * 修改置顶状态
     * @param id
     * @param isTop
     */
    @Update("update bbs_article_table set isTop=#{isTop} where articleId = #{id}")
    void changeStatus(@Param("isTop") Integer isTop, @Param("id") Integer id);

    /**
     * 模糊查询
     * 根据关键字查询
     * @return
     */
    @Select("<script>"+"select * from bbs_article_table where 1=1"
    + "<if test='title!=null'>and title like CONCAT('%',#{title},'%')</if>"
    + "<if test='senderName!=null'>and senderName like CONCAT('%',#{senderName},'%')</if>"
    +"</script>")
    List<Article> findByName(@Param("title") String title,@Param("senderName") String senderName);
}
