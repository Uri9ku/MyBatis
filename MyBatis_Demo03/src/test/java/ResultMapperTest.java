import com.uriku.mybatis.mapper.UserMapper;
import com.uriku.mybatis.pojo.User;
import com.uriku.mybatis.utils.SQLSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapperTest {
    /**
     * 解决字段名和属性名不一致的情况
     *  1.为字段名起别名，保持和属性名的一致
     *  2.设置全局配置，将下划线自动映射为驼峰
     *    <setting name="mapUnderscoreToCamelCase" value="true"/>
     *  3.通过 ResultMap 设置自定义的映射关系
     *    <resultMap id="userResultMap" type="User">
     *         <!-- 主键的映射关系-->
     *         <id property="uid" column="uid"></id>
     *         <!-- 普通字段的映射关系 -->
     *         <result property="userName" column="user_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="email" column="email"></result>
     *     </resultMap>
     */



    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SQLSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
        //userName 和数据库的 uid 不一样，映射不了，会显示 null
    }

    /**
     * 处理多对一的映射关系：
     * 1.
     */
}
