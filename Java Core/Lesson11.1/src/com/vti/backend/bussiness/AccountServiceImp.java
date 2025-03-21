package com.vti.backend.bussiness;

import com.vti.backend.data.AccountRepository;
import com.vti.entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountService {
    public boolean login(String username, String password) throws SQLException {
        AccountRepository accSv = new AccountRepository();
        //　ve sau se co 1 so dieu kien check o day
        return accSv.login(username, password);
    }
    public List<Account> getListAccounts() throws SQLException {
        AccountRepository accountRepository = new AccountRepository();
        return accountRepository.getListAccounts();
    }
}
