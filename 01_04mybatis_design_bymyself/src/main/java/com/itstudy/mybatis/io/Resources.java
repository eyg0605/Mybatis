package com.itstudy.mybatis.io;

import java.io.InputStream;

public class Resources {

    public static InputStream getResourceAsStream(String filePath){

        //クラスローダーを使って、配置フイルムを読み取りする
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
