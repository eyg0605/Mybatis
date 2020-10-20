package com.itstudy.test;

import com.itstudy.dao.UserDao;
import com.itstudy.domain.User;
import com.itstudy.mybatis.io.Resources;
import com.itstudy.mybatis.sqlsession.SqlSession;
import com.itstudy.mybatis.sqlsession.SqlSessionFactory;
import com.itstudy.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception {

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
