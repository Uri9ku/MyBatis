package com.uriku.mybatis.test;

import com.uriku.mybatis.mapper.ActorMapper;
import com.uriku.mybatis.pojo.Actor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    //添加信息
    public void testBatis() throws IOException {
        /**
         * MyBatis中可以面向接口操作数据，要保证两个一致
         * - mapper接口的全类名和映射文件的命名空间（namespace）保持一致
         * - mapper接口中方法的方法名和映射文件中编写SQL的标签的id属性保持一致
         */
        /**
         * SqlSession：代表 Java 程序和数据库之间的会话。（ HttpSession 是 Java 程序和浏览器之间的会话）
         * SqlSessionFactory：是“生产” SqlSession 的“工厂”
         * 工厂模式：如果创建某一个对象，使用的过程基本固定，那么我们就可以把创建这个对象的相关代码封装到一个“工厂类”中，以后都使用这个工厂类来“生产”我们需要的对象
         */
        //加载 mybatis 核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取 SqlSessionFactorBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取 sqlSessionFactoryBuilder
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        //获取 mybatis 绘画对象 sqlSession，设置 boolean 为 true 会自动提交事务
        SqlSession sqlSession = build.openSession(true);
        //获取 mapper 接口对象
        ActorMapper mapper = sqlSession.getMapper(ActorMapper.class);
        //测试功能
        int result = mapper.insertActor();
        //提交事务，在 openSession 方法设置
        //sqlSession.commit();
        System.out.println("result:" + result);
    }

    @Test
    //修改信息
    public void testUpdate() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ActorMapper mapper = sqlSession.getMapper(ActorMapper.class);
        mapper.updateActor();
    }

    @Test
    //删除信息
    public void testDelete() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ActorMapper mapper = sqlSession.getMapper(ActorMapper.class);
        mapper.deleteActor();
    }

    @Test
    //查询对象
    public void selectById() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ActorMapper mapper = sqlSession.getMapper(ActorMapper.class);
        Actor actorById = mapper.getActorById();
        System.out.println(actorById);
    }

    @Test
    //查询所有对象
    public void selectAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        ActorMapper mapper = sqlSession.getMapper(ActorMapper.class);
        List<Actor> allActors = mapper.getAllActor();
        /* for (Actor allActor:allActors
             ) {
            System.out.println(allActor);
        }*/
        allActors.forEach(allActor -> System.out.println(allActor));
    }

}
