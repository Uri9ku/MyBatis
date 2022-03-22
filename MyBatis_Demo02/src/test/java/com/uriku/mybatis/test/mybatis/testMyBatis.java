package com.uriku.mybatis.test.mybatis;

import com.uriku.mybatis.mapper.ParameterMapper;
import com.uriku.mybatis.pojo.Actor;
import com.uriku.mybatis.utils.SQLSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testMyBatis {
    @Test
    public void testGetAllActor(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<Actor> allActor = mapper.getAllActor();
        allActor.forEach(actor -> {
            System.out.println(actor);
        });
    }

    @Test
    /**
     * JDBC 的参数传值（占位符）
     */
    public void JDBC() throws ClassNotFoundException, SQLException {
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        PreparedStatement preparedStatement = connection.prepareStatement("select id,? from actor");
        preparedStatement.setInt(1,1);

    }

    /**
     * MyBatis 获取参数值的两种方式：${} 和 #{}
     * ${} 本质是字符串拼接，要写单引号，可能出现 SQL 注入
     * #{} 本质是占位符赋值，不用写单引号
     *
     * MyBatis 获取参数值的各种情况：
     *
     * 1.mapper 接口方法的参数为单个字面量类型
     *   可以通过 ${} 和 #{} 以任意的字符串获取参数值，但是需要注意 ${} 的单引号问题
     *
     * 2.mapper 接口方法的参数为多个时
     *   此时 MyBatis 会将这些参数放在一个 map 集合中，以两种方式存储
     *   - 以 arg0，arg1...为键，以参数为值
     *   - 以 param1，param2...为键，以参数为值
     *   因此只需通过 ${} 和 #{} 以键的方式访问值即可，但是需要注意 ${} 的单引号问题
     *
     * 3.若 mapper 接口方法的参数有多个时，可以手动将这些参数放在一个 map 中存储
     *   因此只需通过 ${} 和 #{} 以键的方式访问值即可，但是需要注意 ${} 的单引号问题
     *
     * 4.mapper 接口方法的参数是一个实体类类型的参数
     *   因此只需通过 ${} 和 #{} 以属性的方式访问值即可，但是需要注意 ${} 的单引号问题
     *
     * 5.使用 @Param 命名参数
     *   此时 MyBatis 会将这些参数放在一个 map 集合中，以两种方式存储
     *   - 以 @Param 注解的值为键，以参数为值
     *   - 以 param1，param2...为键，以参数为值
     *   因此只需通过 ${} 和 #{} 以键的方式访问值即可，但是需要注意 ${} 的单引号问题
     */

    @Test
    public void testGetActorByActorName(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Actor eugeo = mapper.getActorByActorName("Krito");
        System.out.println(eugeo);
    }

    @Test
    public void checkLogin(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Actor actor = mapper.checkLogin("Eugeo","4869");
        System.out.println(actor);
    }

    @Test
    public void checkLogin1(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("name","Alice");
        map.put("phone","1233");
        Actor actor = mapper.checkLogin1(map);
        System.out.println(actor);
    }

    @Test
    public void insetActor(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int actor = mapper.insertActor(new Actor(16,"Query","男","1876-11-23","AQS"));
        System.out.println(actor);
    }

    @Test
    public void checkLoginByParam(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Actor actor = mapper.checkLoginByParam("Eugeo","4869");
        System.out.println(actor);
    }
}