package com.zlp.mapper;

import com.zlp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 管理用户表 Mapper 接口
 * </p>
 *
 * @author LiPing.Zou
 * @since 2021-03-11
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from sys_user where username = #{username} and password = #{password}")
    User login(@Param("username") String username, @Param("password") String password);
}
