package com.epochong.dao;


import com.epochong.po.Orders;
import com.epochong.po.User;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.epochong.utils.JdbcUtils.*;

/**
 * @author epochong
 * @date 2019/8/3 10:25
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class AccountDao {
    public User userLogin(String userName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = getConnection();
            String sql = "select * from user where userName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = getUserInfo(resultSet);
            }
        } catch (Exception e) {
            System.err.println("查询数据库用户信息出错");
            e.printStackTrace();
        } finally {
            close(connection, statement, resultSet);
        }
        return user;
    }

    public int selectUserIdByName(String userName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        connection = getConnection();
        String sql = "select id from user where username = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,userName);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<Orders> getUserOrders(String userName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Orders> list = new ArrayList <>();
        connection = getConnection();
        int id = selectUserIdByName(userName);
        String sql = "select * from orders where user_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(id));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Orders orders = new Orders();
                orders.setId(resultSet.getInt("id"));
                orders.setNumber(resultSet.getString("number"));
                orders.setUserId(resultSet.getInt("user_id"));
                list.add(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public User getUserInfo(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("username"));
        return user;
    }
}
