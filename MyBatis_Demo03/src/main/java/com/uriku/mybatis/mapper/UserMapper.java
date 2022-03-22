package com.uriku.mybatis.mapper;

import com.uriku.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有员工信息
     */
    List<User> getAllUser();

    /**
     * 查询员工及所对应的部门信息
     */

    User getUserAndDept(@Param("uid") Integer uid);
}
