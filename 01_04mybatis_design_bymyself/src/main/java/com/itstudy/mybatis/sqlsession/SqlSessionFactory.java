package com.itstudy.mybatis.sqlsession;

public interface SqlSessionFactory {

    //SqlSessionオブジェクトを作るためのメソッド
    SqlSession openSession();
}
