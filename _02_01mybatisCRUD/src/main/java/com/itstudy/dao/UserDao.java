package com.itstudy.dao;

import com.itstudy.domain.QueryVo;
import com.itstudy.domain.User;

import java.util.List;

public interface UserDao {

    List<User>  findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findUserById(Integer id);

    //名前により、ユーザーを探す
    List<User> findUserByName(String username);

    int findTotal();


    //OGNL表达式を理解するために
    List<User> findUserByVo(QueryVo vo);
}
