package com.itstudy.dao;

import com.itstudy.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
}
