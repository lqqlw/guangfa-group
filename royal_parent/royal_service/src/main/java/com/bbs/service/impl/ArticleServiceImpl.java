package com.bbs.service.impl;

import com.bbs.dao.ArticleDao;
import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 帖子信息实现类
 * @author
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    /**
     * 查找所有帖子，分页状态
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Article> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return articleDao.findAll();
    }

    /**
     * 删除帖子
     * @param articleId
     */
    @Override
    public void deleteArticle(Integer articleId) {
        articleDao.deleteArticle(articleId);
    }

    /**
     * 修改置顶状态
     * @param articleId
     * @param isTop
     */
    @Override
    public void changeStatus(Integer articleId, Integer isTop) {
        articleDao.changeStatus(isTop,articleId);
    }

    /**
     * 根据标题和创帖人模糊查询
     * @param title
     * @param senderName
     * @return
     */
    @Override
    public List<Article> findByName(String title,String senderName) {
        return articleDao.findByName(title,senderName);
    }
}
