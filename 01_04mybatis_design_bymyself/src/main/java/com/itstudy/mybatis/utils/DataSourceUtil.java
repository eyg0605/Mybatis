package com.itstudy.mybatis.utils;

import com.itstudy.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtil {

    public static Connection getConnection(Configuration cfg){

        try {
            Class.forName(cfg.getDriver());
           return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
