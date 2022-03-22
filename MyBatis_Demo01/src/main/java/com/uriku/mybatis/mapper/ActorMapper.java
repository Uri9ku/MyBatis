package com.uriku.mybatis.mapper;

import com.uriku.mybatis.pojo.Actor;

import java.util.List;

public interface ActorMapper {

    /**
     * mybatis 面向接口编程的两个一致
     * 1.映射文件的 namespace 要和 mapper 接口的全类名保持一致
     * 2.映射文件中 SQL 语句的 id 要和 mapper 接口中的方法名一致
     *
     * 表 -- 实体类 - mapper 接口 -- 映射文件
     * /


    /**
     * 添加用户信息
     */
    int insertActor();

    /**
     * 修改用户信息
     */
    void updateActor();

    /**
     * 删除用户信息
     */
    void deleteActor();

    /**
     * 根据 id 查询用户信息
     */
    Actor getActorById();

    /**
     * 查询所有的用户信息
     */
    List<Actor> getAllActor();
}
