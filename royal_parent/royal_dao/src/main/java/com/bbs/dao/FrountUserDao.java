package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface FrountUserDao {
    /**
     * 注册用户
     * @param user
     */
    @Insert("insert into bbs_user_table (userName,userPass,email) values (#{userName},#{userPass},#{email})")
    void save(User user);

    /**
     * 校验用户名
     * @param userName
     * @return
     */
    @Select("select * from bbs_user_table where userName = #{userName}")
    User findByUserName(String userName);

    /**
     * 登录
     * @param userName
     * @return
     */
    @Select("select *　from bbs_user_table where userName = #{userName}")
    User login(@Param("userName") String userName, @Param("userPass") String userPass);
}
