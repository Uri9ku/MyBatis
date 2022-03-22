package com.uriku.mybatis.mapper;

import com.uriku.mybatis.pojo.Actor;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据 id 查询用户信息
     */
    List<Actor> getActorById(@Param("id") String id);

    /**
     * 查询所有用户信息
     */
    List<Actor> getAllActor();

    /**
     * 查询用户信息总记录数
     */
    Integer getCount();

    /**
     * 根据 id 查询用户信息为一个 map 集合
     */
    Map<String,Object> getActorByIdToMap(@Param("id") String id);

    /**
     * 查询所用用户信息为一个 map 的 List 集合
     */
    List<Map<String,Object>> getAllActorToMap();

    /**
     * 查询所用用户信息为一个 map 集合
     */
    @MapKey("id")
    Map<String,Object> getAllActorToMapKey();
}
