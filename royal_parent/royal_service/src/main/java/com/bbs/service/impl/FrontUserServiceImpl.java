package com.bbs.service.impl;

import com.bbs.dao.FrountUserDao;
import com.bbs.domain.User;
import com.bbs.service.FrontUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台用户service实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FrontUserServiceImpl implements FrontUserService{
    @Autowired
    private FrountUserDao  frountUserDao;
    @Override
    public void save(User user) {
        frountUserDao.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return frountUserDao.findByUserName(userName);
    }

    @Override
    public User login(String userName,String userPass) {
        return frountUserDao.login(userName,userPass);
    }
}
