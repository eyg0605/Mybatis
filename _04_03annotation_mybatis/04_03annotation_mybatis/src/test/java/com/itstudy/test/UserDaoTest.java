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
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession(true);
        userDao=session.getMapper(UserDao.class);
    }
    @After
    public void destory() throws Exception {
        session.close();
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
    public void testSaveUser(){
        User user=new User();
        user.setUsername("annotation");
        user.setAddress("北京市");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.saveUser(user);
    }
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(42);
    }
    @Test
    public void testUpdateUser(){
        User user = userDao.findUserById(43);
        user.setUsername("大王");
        userDao.updateUser(user);
    }
    @Test
    public void testFindByName(){
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
