package com.itstudy.test;

import com.itstudy.dao.Impl.UserDaoImpl;
import com.itstudy.dao.UserDao;
import com.itstudy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSessionFactory factory;

    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
         userDao = new UserDaoImpl(factory);
    }

    @After
    public void destory() throws Exception {

        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserById(){
        User user = userDao.findUserById(82);
        System.out.println(user);
    }

    @Test
    public void testSaveUser(){
        User user=new User();
        user.setUsername("heihei");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("東京都北区田端");

        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser(){
        User user = userDao.findUserById(82);

        user.setUsername("father");

        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(79);
    }

    @Test
    public void testFindUserByName(){
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }
}
