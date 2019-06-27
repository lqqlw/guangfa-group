package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    /**
     * 登录
     * @param username
     * @return
     */
    @Select("select * from bbs_user_table where username = #{username}")
    User findByUsername(String username);

    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from bbs_user_table")
    List<User> findByPage();

    /**
     * 升级用户
     * @param id
     * @param role
     */
    @Update("update bbs_user_table set role=#{role} where userId = #{id}")
    void changeStatus(@Param("id") Integer id,@Param("role") Integer role);

    /**
     * 修改发言权限
     * @param id
     * @param talkStatus
     */
    @Update("update bbs_user_table set talkStatus=#{talkStatus} where userId = #{id}")
    void speakingCompetence(@Param("id") Integer id, @Param("talkStatus") Integer talkStatus);
}
