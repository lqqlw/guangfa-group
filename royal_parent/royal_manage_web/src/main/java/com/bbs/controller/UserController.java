package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.List;

/**
 * 用户的controller
 * @author
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserService userService;

    /**
     * 查找所有用户，分页状态
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(name="page",required = true,defaultValue = "1") int page,@RequestParam(name="size",required = true,defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.findByPage(page,size);
        PageInfo pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("UserPage");
        return  mv;
    }

    /**
     * 升级用户权限
     * @param id
     * @param role
     * @return
     */
    @RequestMapping("/changeStatus")
    public String changeStatus(@RequestParam(name="id",required = true) Integer id,@RequestParam(name="role",required = true) Integer role){
        userService.changeStatus(id,role);
        return "redirect:findByPage";
    }
    /**
     * 修改发言权限
     */
    @RequestMapping("/speakingCompetence")
    public String speakingCompetence(@RequestParam(name="id",required = true) Integer id,@RequestParam(name="talkStatus",required = true) Integer talkStatus){
        userService.speakingCompetence(id,talkStatus);
        return "redirect:findByPage";
    }
}
