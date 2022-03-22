package com.uriku.mybatis.mapper;

import com.uriku.mybatis.pojo.Actor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {
    /**
     * 查询所有员工的信息
     */
    List<Actor> getAllActor();

    /**
     * 查根据用户名查询用户信息
     */
    Actor getActorByActorName(String actorName);

    /**
     * 验证登录
     */
    Actor checkLogin(String actorName,String phone);

    /**
     * 验证登录（参数为 map）
     */
    Actor checkLogin1(Map<String,Object> map);

    /**
     * 添加用户信息
     */
    int insertActor(Actor actor);

    /**
     * 验证登录（使用 @Param 注解）
     */
    Actor checkLoginByParam(@Param("name") String name,@Param("phone") String phone);
}
