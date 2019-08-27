package com.epochong.po;

/**
 * @author epochong
 * @date 2019/8/27 16:35
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class User {
    Integer id;

    String userName;

    String password;

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
