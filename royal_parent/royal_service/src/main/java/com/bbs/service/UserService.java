package com.bbs.service;

import com.bbs.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    /**
     * 查找所有用户
     * @return
     */
    List<User> findByPage(int page,int size);

    /**
     * 升级用户
     * @param id
     * @param role
     */
    void changeStatus(Integer id, Integer role);

    /**
     * 修改发言权限
     * @param id
     * @param talkStatus
     */
    void speakingCompetence(Integer id, Integer talkStatus);
}
