package com.itstudy.test;

import com.itstudy.dao.Impl.UserDaoImpl;
import com.itstudy.dao.UserDao;
import com.itstudy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception {

        //配置フイルムの読み取り
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //ファクトリオブジェクトを作る
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //UserDaoImplオブジェクトでメソッドを呼び出す
        UserDao userDao=new UserDaoImpl(factory);
        List<User> users = userDao.findAll();
        //結果セットを遍歴する
        for (User user : users) {
            System.out.println(user);
        }
    }
}
