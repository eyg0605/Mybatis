package com.itstudy.dao;

import com.itstudy.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    List<User> findUserByName(String username);

    User findUserById(Integer id);

    void updateUser(User user);


}
