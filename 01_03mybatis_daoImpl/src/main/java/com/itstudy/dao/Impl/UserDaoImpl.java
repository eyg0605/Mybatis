package com.itstudy.dao.Impl;

import com.itstudy.dao.UserDao;
import com.itstudy.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/*テストのプログラミングを分析したところ、一番重要なのはSqlSessionFactoryでsessionオブジェクトを作ってから
* session.selectList（）という方法は必要です。factoryはnullじゃないように、コンストラクターを書き換えします。
* */
public class UserDaoImpl implements UserDao {

    //2．sessionを作るために、SqlSessionFactoryが必要です
    private SqlSessionFactory factory;

    //3.factoryはnullじゃないように、コンストラクターの書き換えします。
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    public List<User> findAll() {
        //1.sessionを使って、session.selectList()を使用する
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.itstudy.dao.UserDao.findAll");

        //4.リソースを解放する
        session.close();

        //5.return結果セット
        return users;
    }
}
