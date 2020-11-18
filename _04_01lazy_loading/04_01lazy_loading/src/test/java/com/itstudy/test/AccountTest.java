package com.itstudy.test;

import com.itstudy.dao.AccountDao;
import com.itstudy.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession(true);
        accountDao=session.getMapper(AccountDao.class);
    }
    @After
    public void destory() throws Exception {
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        /*for (Account account : accounts) {
            System.out.println("每个账户信息");
            System.out.println(account);
            System.out.println(account.getUser());
        }*/
    }
}
