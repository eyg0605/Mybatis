package com.itstudy.dao;

import com.itstudy.domain.User;
import sun.java2d.pipe.OutlineTextRenderer;

import java.net.Inet4Address;
import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findUserById(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    List<User> findUserByName(String  username);

    int findTotal();
}
