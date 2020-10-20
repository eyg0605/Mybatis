package com.itstudy.mybatis.sqlsession.defaults;

import com.itstudy.mybatis.cfg.Configuration;
import com.itstudy.mybatis.sqlsession.SqlSession;
import com.itstudy.mybatis.sqlsession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }

    //创建一个操作数据库对象
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
