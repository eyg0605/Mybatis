package com.itstudy.dao;

import com.itstudy.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("slect *from user")
    List<User> findAll();
}
