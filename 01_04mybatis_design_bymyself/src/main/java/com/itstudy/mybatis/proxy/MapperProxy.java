package com.itstudy.mybatis.proxy;

import com.itstudy.mybatis.cfg.Mapper;
import com.itstudy.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers=mappers;
        this.conn=conn;
    }
    //ここでselectListメソッドを使う
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.メソッドの名前を取り出し
        String methodName=method.getName();
        //2.メソッドのクラスの名前を取り出し
        String className = method.getDeclaringClass().getName();
        //3.keyを合わせる
        String key=className+"."+methodName;
        //4.keyによる、valueをゲット
        Mapper mapper = mappers.get(key);
        //mapperはnullであるかどうか判断する
        if (mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6.nullじゃない場合、selectListを使う
        return new Executor().selectList(mapper,conn);
    }
}
