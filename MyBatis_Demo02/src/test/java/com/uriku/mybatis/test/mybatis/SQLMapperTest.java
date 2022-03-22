package com.uriku.mybatis.test.mybatis;

import com.uriku.mybatis.mapper.SQLMapper;
import com.uriku.mybatis.pojo.Actor;
import com.uriku.mybatis.utils.SQLSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class SQLMapperTest {
    @Test
    public void testGetActorByName(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<Actor> o = mapper.getActorByLike("o");
        System.out.println(o);
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int i = mapper.DeleteMore("15,16");
        System.out.println(i);
    }

    @Test
    public void testgetActorByTableName(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<Actor> actor = mapper.getActorByTableName("Actor");
        System.out.println(actor);
    }

    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        PreparedStatement insert = connection.prepareStatement("insert",Statement.RETURN_GENERATED_KEYS);
        int i = insert.executeUpdate();
        ResultSet generatedKeys = insert.getGeneratedKeys();

    }

    @Test
    public void insertActor(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        Actor actor = new Actor(null,"Origami","女","2001-05-13","12323");
        mapper.insertActor(actor);
        System.out.println(actor);
    }
}
