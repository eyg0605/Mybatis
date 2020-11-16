package com.itstudy.dao;

import com.itstudy.domain.QueryVo;
import com.itstudy.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    List<User> findUserByName(String username);

    User findUserById(Integer id);


    /*
    * 根据传入参数条件
    * user 查询的条件：有可能有用户名，有可能有性别，有可能有地址，也有可能啥都有
    * */
    List<User> findUserByCondition(User user);

    /*
    * 根据queryVo提供的id集合查询用户信息
    * 例：select* from user  where id in(41,42,43)
    * */
    List<User> findUserInIds(QueryVo queryVo);
}
