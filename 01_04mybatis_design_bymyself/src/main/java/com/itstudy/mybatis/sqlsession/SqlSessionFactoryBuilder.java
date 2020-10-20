package com.itstudy.mybatis.sqlsession;

import com.itstudy.mybatis.cfg.Configuration;
import com.itstudy.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.itstudy.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in){

        Configuration cfg= XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
