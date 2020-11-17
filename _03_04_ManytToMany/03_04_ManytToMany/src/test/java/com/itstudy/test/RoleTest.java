package com.itstudy.test;

import com.itstudy.dao.RoleDao;
import com.itstudy.dao.UserDao;
import com.itstudy.domain.Role;
import com.itstudy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private RoleDao roleDao;

    @Before
    public void init() throws Exception {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession(true);
        roleDao=session.getMapper(RoleDao.class);
    }
    @After
    public void destory() throws Exception {
        session.close();
        in.close();
    }
    @Test
    public void testFindAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(".角色..");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
