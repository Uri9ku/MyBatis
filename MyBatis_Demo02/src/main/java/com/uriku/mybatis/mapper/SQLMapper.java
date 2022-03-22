package com.uriku.mybatis.mapper;

import com.uriku.mybatis.pojo.Actor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {
    /**
     * 根据用户名模糊查询用户信息
     */
    List<Actor> getActorByLike(@Param("name") String name);

    /**
     * 批量删除
     */
    int DeleteMore(@Param("ids") String ids);

    /**
     * 查询指定表中的数据
     */
    List<Actor> getActorByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     */
    void insertActor(Actor actor);

}
