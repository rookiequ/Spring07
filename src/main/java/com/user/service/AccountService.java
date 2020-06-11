package com.user.service;

import com.user.domain.Account;

public interface AccountService {

    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 转账操作
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName, String targetName, Float money);
}
