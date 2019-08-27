package com.epochong.service;

import com.epochong.dao.AccountDao;
import com.epochong.po.Orders;
import com.epochong.po.User;

import java.util.List;

/**
 * @author epochong
 * @date 2019/8/3 10:38
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class AccountService {
    private AccountDao accountDao = new AccountDao();

    //用户登录
    public boolean userLogin(String userName) {
        User user = accountDao.userLogin(userName);
        if (user == null) {
            return false;
        }
        return true;
    }

    public List<Orders> getUserOrders(String userName) {
        List<Orders> list = accountDao.getUserOrders(userName);
        return list;
    }
}
