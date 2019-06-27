package com.bbs.service;

import com.bbs.domain.User; /**
 * 前台用户的service
 */
public interface FrontUserService{
    /**
     * 注册用户
     * @param user
     */
    void save(User user);

    /**
     * 校验用户名
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 登录方法
     * @param userName
     * @return
     */
    User login(String userName,String userPass);
}
