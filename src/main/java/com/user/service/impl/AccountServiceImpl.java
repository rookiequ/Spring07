package com.user.service.impl;

import com.user.dao.AccountDAO;
import com.user.domain.Account;
import com.user.service.AccountService;

/**
 * @author zzq
 */
public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account findAccountById(Integer id) {
        return accountDAO.findAccountById(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("转账开始");
        //1.根据名称查出转出账户
        Account source = accountDAO.findAccountByName(sourceName);
        //2.根据名称查出转入用户
        Account target = accountDAO.findAccountByName(targetName);
        //3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //4.转入账户加钱
        target.setMoney(target.getMoney() + money);
        //5.更新抓出账户   配置了事务之后，这里的操作提交了，但是没有提交事务，只是内存里进行更新了，如有异常事务回滚
        accountDAO.updateAccount(source);

        //模拟事务出错
//        int i = 1/0;

        //6.更新转入账户
        accountDAO.updateAccount(target);
    }
}
