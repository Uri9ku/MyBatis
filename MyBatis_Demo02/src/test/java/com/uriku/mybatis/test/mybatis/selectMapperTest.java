package com.uriku.mybatis.test.mybatis;

import com.uriku.mybatis.mapper.SelectMapper;
import com.uriku.mybatis.pojo.Actor;
import com.uriku.mybatis.utils.SQLSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class selectMapperTest {

    /**
     * MyBatis 的各种查询功能：
     * 1.若查询出的数据只有一条
     *  - 可以通过实体类对象接收
     *  - 可以通过 List 集合接收
     *  - 可以通过 Map 集合接收
     * 2.若查询出的数据有多条
     *  - 可以通过 List 集合接收
     *  - 可以通过 Map 类型的 List 集合接收
     *  - 可以在 mapper接口的方法上添加 @MapKey 注解，此时可以将每条数据转化为 map 集合作为值，以某个字段的值作为键，放在同一个 map 集合中
     *  - 不能通过实体类对象接收，此时会抛出异常 TooManyResultsException
     *
     *  MyBatis 中设置了默认的类型别名
     *  Java.lang.Integer --> int,integer
     *  int --> _int,_integer
     *  Map --> map
     *  String --> string
     */
    @Test
    public void getActorById(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getActorById("2"));
    }

    @Test
    public void getAllActor(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Actor> allActor = mapper.getAllActor();
        allActor.forEach(actor -> System.out.println(actor));
    }

    @Test
    public void getCount(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void getActorByIdToMap(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> actorByIdToMap = mapper.getActorByIdToMap("2");
        System.out.println(actorByIdToMap);
    }

    @Test
    public void getAllActorToMap(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> getAllActorToMap = mapper.getAllActorToMap();
        System.out.println(getAllActorToMap);
    }

    @Test
    public void getAllActorToMapKey(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> getAllActorToMapKey = mapper.getAllActorToMapKey();
        System.out.println(getAllActorToMapKey);
    }

}
