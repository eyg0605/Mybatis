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
import java.util.ArrayList;
import java.util.List;

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
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

}
