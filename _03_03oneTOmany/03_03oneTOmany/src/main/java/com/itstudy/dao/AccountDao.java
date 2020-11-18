package com.itstudy.dao;

import com.itstudy.domain.Account;
import com.itstudy.domain.AccountUser;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    List<AccountUser> findAllAccount();
}
