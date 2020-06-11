package com.user.dao;

import com.user.domain.Account;

public interface AccountDAO {

    /**
     * 根据id获取账号信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据姓名查询用户信息
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账号信息
     * @param account
     */
    void updateAccount(Account account);
}
