package com.itstudy.dao;

import com.itstudy.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/*在mybatis中针对CRUD，一共有四个注解
* @Select @Insert @Update @Delete
* */

public interface UserDao {


    @Select("select *from user")
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    @Select("select *from user where id=#{id}")
    User findUserById(Integer id);

    @Select("select *from user where username like #{username}")
    List<User> findUserByName(String name);

    @Select("select count(*) from user")
    int findTotal();
}
