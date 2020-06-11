package com.user.dao.impl;

import com.user.dao.AccountDAO;
import com.user.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author zzq
 */
public class AccountDAOImpl extends JdbcDaoSupport implements AccountDAO {

    //使用了JdbcDaoSupport之后，使用的spring的JDBCTemplate,和dbutils差不多，但是有一些区别
    //这里不需要指定datasource，因为父类已经帮我们获取了datasource，并且放到了jdbcTemplate变量当中了，我们使用getJdbcTemplate获取

    public Account findAccountById(Integer id) {
        List<Account> accountList = super.getJdbcTemplate().query(
                "select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                id);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> accountList = super.getJdbcTemplate().query(
                "select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                name);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update(
                "update account set name=?, money=? where id=?",
                account.getName(),
                account.getMoney(),
                account.getId());
    }
}
