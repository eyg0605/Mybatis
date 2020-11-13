package com.itstudy.test;

import com.itstudy.dao.UserDao;
import com.itstudy.domain.QueryVo;
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

public class MyBatisTest {

    private InputStream in;
    private  SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }
    @After
    public void destory() throws Exception {
        //commit
        session.commit();

        session.close();
        in.close();


    }    @Test
    public  void findAll() throws Exception {
        List<User> users = userDao.findAll();
        for (User user :  users) {
            System.out.println(user);
        }
    }
    @Test
    public void saveUser(){
        User u=new User();
        u.setUserName("haha");
        u.setUserAddress("東京都");
        u.setUserBirthday(new Date());

        System.out.println("保存するまえに："+u);
        userDao.saveUser(u);
        System.out.println("保存した後："+u);
    }
    @Test
    public void updateUser(){
        User user=new User();
        user.setUserId(76);
        user.setUserName("tom");

        userDao.updateUser(user);
    }
    @Test
    public void deleteUser(){
        userDao.deleteUser(76);
    }

    @Test
    public void findUserById(){
        User user = userDao.findUserById(76);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName(){
        List<User> users = userDao.findUserByName("%王%");//%をつけます
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findTotal(){
        int total = userDao.findTotal();
        System.out.println(total);

    }
    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        User u=new User();
        u.setUserName("%王%");
        vo.setUser(u);

        List<User> users = userDao.findUserByVo(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
