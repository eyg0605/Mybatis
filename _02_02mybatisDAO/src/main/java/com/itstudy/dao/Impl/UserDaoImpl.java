package com.itstudy.dao.Impl;

import com.itstudy.dao.UserDao;
import com.itstudy.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    public List<User> findAll() {
        //1.factoryによる、SqlSession をつくる
        SqlSession sqlSession = factory.openSession();
        //2.sqlSession　の　メソッドを使用する
        List<User> users = sqlSession.selectList("com.itstudy.dao.UserDao.findAll");//namespace+idの value
        //3.リソースを解放する
        sqlSession.close();
        return users;
    }

    public User findUserById(Integer id) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("com.itstudy.dao.UserDao.findUserById",id);
        sqlSession.close();
        return user;

    }

    public void saveUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.itstudy.dao.UserDao.saveUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("com.itstudy.dao.UserDao.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(Integer id) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.itstudy.dao.UserDao.deleteUser",id);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<User> findUserByName(String username) {
        SqlSession sqlSession = factory.openSession();
        List<User> users = sqlSession.selectList("com.itstudy.dao.UserDao.findUserByName", username);

        sqlSession.close();
        return users;
    }

    public int findTotal() {
        SqlSession sqlSession = factory.openSession();
        Integer  count = sqlSession.selectOne("com.itstudy.dao.UserDao.findTotal");

        sqlSession.close();
        return count;
    }
}
