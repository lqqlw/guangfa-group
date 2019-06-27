package com.bbs.controller;


import com.bbs.domain.Article;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 后台帖子信息web层
 * @author
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 查找所有帖子，分页状态
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name="page",required = true,defaultValue = "1") int page,@RequestParam(name="size",required = true,defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        List<Article> articles = articleService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(articles);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ArticlePage");
        return mv;
    }

    /**
     * 屏蔽帖子
     * @param articleId
     * @return
     */
    @RequestMapping("/deleteArticle")
    public String deleteArticle(@RequestParam(name="id",required = true) Integer articleId){
        articleService.deleteArticle(articleId);
        return "redirect:findByPage";
    }

    /**
     * 修改置顶状态
     * @param articleId
     * @param isTop
     * @return
     */
    @RequestMapping("/changeStatus")
    public String changeStatus (@RequestParam(name="id",required = true) Integer articleId,@RequestParam(name="isTop",required = true) Integer isTop){
        articleService.changeStatus(articleId,isTop);
        return "redirect:findByPage";
    }
    /**
     * 模糊查询
     */
    @RequestMapping("/findByName")
    public ModelAndView findByName(String title,String senderName){
        ModelAndView mv = new ModelAndView();
        List<Article> articles= articleService.findByName(title,senderName);
        mv.addObject("articles",articles);
        mv.setViewName("ArticlePage");
        return mv;
    }
}
