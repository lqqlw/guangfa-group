package com.bbs.service;

import com.bbs.domain.Article;

import java.util.List;

/**
 * 帖子信息service层
 * @author
 */
public interface ArticleService {
    /**
     * 查看所有帖子
     * @return
     */
    List<Article> findAll(int page,int size);

    /**
     * 屏蔽帖子
     * @param articleId
     */
    void deleteArticle(Integer articleId);

    /**
     * 置顶状态
     * @param articleId
     * @param isTop
     */
    void changeStatus(Integer articleId, Integer isTop);

    /**
     * 模糊查询
     * @return
     */
    List<Article> findByName(String title,String senderName);
}
