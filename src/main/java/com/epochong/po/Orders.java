package com.epochong.po;

/**
 * @author epochong
 * @date 2019/8/27 20:24
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class Orders {
    private int id;

    private int userId;

    private String number;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
