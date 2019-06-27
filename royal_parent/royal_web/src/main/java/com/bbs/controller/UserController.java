package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.FrontUserService;
import com.bbs.service.UserService;
import com.bbs.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户的service
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private FrontUserService frontUserService;

    @RequestMapping("/save")
    public String save(User user) {
        frontUserService.save(user);
        return "success";
    }

    @RequestMapping("/findByUserName")
    public void findByUserName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取前端传递过来的参数
        String username = request.getParameter("userName");
        //设置编码格式以及响应的数据为json
        response.setContentType("application/json;charset=utf-8");
        //调用service保存
        UserService service = new UserServiceImpl();
        //创建查询方法;
        User find = frontUserService.findByUserName(username);
        //创建一个map集合，因为map集合的结构与json类似
        Map<String, Object> map = new HashMap<>();
        //期望服务器响应回的数据{"userExsit" :true , "msg" : "此用户名太受欢迎，请重新输入"}
        //                      {"userExsit" :false , "msg" : "可以使用的用户名"}
        //判断用户名是否存在
        if (find != null) {
            //用户名存在
            map.put("userExsit", true);
            map.put("msg", "此用户名太受欢迎，请重新输入");
        } else {
            //用户名不存在
            map.put("userExsit", false);
            map.put("msg", "可以使用的用户名");
        }
        //创建一个 ObjectMapper 对象
        ObjectMapper mapper = new ObjectMapper();
        //把map集合转化为json串 并且传递给客户端
        mapper.writeValue(response.getWriter(), map);
    }
    @RequestMapping("/login")
    public String login(@RequestParam(name = "userName",required = true) String userName,@RequestParam(name = "userPass",required = true) String userPass){
        User user = frontUserService.login(userName,userPass);
        if (user !=null){
            return "success1";
        }
        return "falier1";
    }
}

