package com.itstudy.mybatis.sqlsession.defaults;

import com.itstudy.mybatis.cfg.Configuration;
import com.itstudy.mybatis.proxy.MapperProxy;
import com.itstudy.mybatis.sqlsession.SqlSession;
import com.itstudy.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;


    public DefaultSqlSession(Configuration cfg){
        this.cfg=cfg;
        conn= DataSourceUtil.getConnection(cfg);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
       return(T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),conn));

    }

    public void close() {

        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
