package com.bbs.controller;


import com.bbs.domain.Word;
import com.bbs.service.WordsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 敏感词汇的controller
 * @author
 */
@Controller
@RequestMapping("/word")
public class WordsController {
    @Autowired
    private WordsService wordsService;

    /**
     * 查找所有敏感词，分页状态
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name="page",required = true,defaultValue = "1") int page,@RequestParam(name="size",required = true,defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        List<Word> wordList= wordsService.findByPage(page,size);
        PageInfo pageInfo = new PageInfo(wordList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("WordsPage");
        return mv;
    }

    /**
     * 操作敏感词状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/processing")
    public String processing(@RequestParam(name = "id",required = true) Integer id,@RequestParam(name = "status",required = true) Integer status){
        wordsService.processing(id,status);
        return "redirect:findByPage";
    }

    /**
     * 增加敏感词
     * @param words
     * @return
     */
    @RequestMapping("/save")
    public String save(Word words){
        wordsService.save(words);
        return "redirect:findByPage";
    }
}
