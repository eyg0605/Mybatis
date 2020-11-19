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

public class MybatisTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession(true); //opsenSessionのメソッド
         userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws Exception {
     //   session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFirstLevelCache(){
        User user1=userDao.findUserById(41);
        System.out.println(user1);

        /*1.session.close();
        //再次获取SqlSession对象
        session = factory.openSession(true);
        userDao=session.getMapper(UserDao.class);*/
        //2.session.clearCache();

        User user2 = userDao.findUserById(41);
        System.out.println(user2);

        System.out.println(user1==user2);
    }
    @Test
    public void testClealCache(){
        //1.查询用户并存进一级缓存中
        User user1 = userDao.findUserById(41);
        System.out.println(user1);
        //2.更新用户信息,当SqlSession执行update，insert，delete，commit()，close()等方法时，一级缓存会被清空
        user1.setUsername("update user clear cache");
        user1.setAddress("北京市海淀区");
        userDao.updateUser(user1);

        //3.再次查询id为41的用户
        User user2=userDao.findUserById(41);
        System.out.println(user2);

        System.out.println(user1==user2);//false
    }

}
