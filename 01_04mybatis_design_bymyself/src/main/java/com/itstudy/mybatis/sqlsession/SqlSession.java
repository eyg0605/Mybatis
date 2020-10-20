package com.itstudy.mybatis.sqlsession;

//ｄｂ
public interface SqlSession {

    //パラメータにより、プロキシオブジェクトを作る
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
