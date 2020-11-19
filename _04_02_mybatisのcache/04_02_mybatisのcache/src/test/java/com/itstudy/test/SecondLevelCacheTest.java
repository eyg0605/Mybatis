package com.itstudy.test;

import com.itstudy.dao.UserDao;
import com.itstudy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;


    @Before
    public void init() throws Exception {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);

    }

    @After
    public void destory() throws Exception {
        //   session.commit();
        in.close();
    }
    @Test
    public void testFirstLevelCache(){
        SqlSession sqlSession1=factory.openSession();
        UserDao dao1 = sqlSession1.getMapper(UserDao.class);
        User user1 = dao1.findUserById(41);
        System.out.println(user1);
        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2=factory.openSession();
        UserDao dao2 = sqlSession2.getMapper(UserDao.class);
        User user2 = dao2.findUserById(41);
        System.out.println(user2);

        System.out.println(user1==user2);//false  因为mybatis中的二级缓存存放的是数据而不是对象，
                                        //当有人需要这个数据的时候，它会重新创建一个对象，然后把数据填充进去，所以结果是false
    }
}
