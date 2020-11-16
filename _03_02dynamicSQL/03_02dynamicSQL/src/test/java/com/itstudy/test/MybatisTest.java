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

import javax.management.Query;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
        }
    }

    @Test
    public void testFindUserByConfition(){
        User user=new User();
        user.setUsername("老王");
       /* user.setSex("女");*/
        List<User> users = userDao.findUserByCondition(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public void testFindUserInIds(){
        List<Integer> ids=new ArrayList();
        ids.add(48);
        ids.add(53);
        ids.add(54);

        QueryVo queryVo= new QueryVo();
        queryVo.setIds(ids);

        List<User> users = userDao.findUserInIds(queryVo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
