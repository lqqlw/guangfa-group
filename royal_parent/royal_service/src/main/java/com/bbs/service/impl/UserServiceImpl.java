package com.bbs.service.impl;


import com.bbs.dao.UserDao;
import com.bbs.domain.User;
import com.bbs.service.UserService;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户登录
 * @author
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 使用权限框架登录
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user1 =  userDao.findByUsername(username);
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(user1.getUserName(),"{noop}"+user1.getUserPass(),getAuthority());
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_admin"));
        return list;
    }

    /**
     * 查找所有用户，分页状态
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<User> findByPage(int page,int size) {
        PageHelper.startPage(page,size);
        return userDao.findByPage();
    }

    /**
     * 升级用户
     * @param id
     * @param role
     */
    @Override
    public void changeStatus(Integer id, Integer role) {
        userDao.changeStatus(id,role);
    }

    /**
     * 修改用户发言状态
     * @param id
     * @param talkStatus
     */
    @Override
    public void speakingCompetence(Integer id, Integer talkStatus) {
        userDao.speakingCompetence(id,talkStatus);
    }
}
