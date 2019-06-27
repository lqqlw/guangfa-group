package com.bbs.controller;


import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 举报帖子的controller
 * @author
 */
@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 查找所有举报信息，分页状态
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name="page",required = true,defaultValue = "1") int page,@RequestParam(name="size",required = true,defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        List<Report> reportList = reportService.findByPage(page,size);
        PageInfo pageInfo = new PageInfo(reportList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ReportPage");
        return mv;
    }

    /**
     * 处理举报状态
     * @param id
     * @param reportStatus
     * @return
     */
    @RequestMapping("/processing")
    public String processing(@RequestParam(name="id",required = true) Integer id,@RequestParam(name = "reportStatus",required = true) Integer reportStatus){
        reportService.processing(id,reportStatus);
        return "redirect:findByPage";
    }
}
