package com.itstudy.dao;

import com.itstudy.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    //根据用户id查询账户信息
    List<Account> findAccountByUid(Integer uid);
}
