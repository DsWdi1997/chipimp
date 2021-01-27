package com.example.chipimp.pojo;

/**
 * 用户实体类
 */

public class User {

    /**
     * 用户ID
     */
    private Integer user_id;

    /**
     * 用户名
     */

    private String user_name;

    /**
     * 用户密码
     */
    private String user_passwd;


    /**
     * 用户是否是管理员，1代表是，0代表否
     */
    private int user_ismanager;

    public User() {
    }

    public User(int user_id, String user_name, String user_passwd, int user_ismanager) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_passwd = user_passwd;
        this.user_ismanager = user_ismanager;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_passwd() {
        return user_passwd;
    }

    public void setUser_passwd(String user_passwd) {
        this.user_passwd = user_passwd;
    }

    public int getUser_ismanager() {
        return user_ismanager;
    }

    public void setUser_ismanager(int user_ismanager) {
        this.user_ismanager = user_ismanager;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_passwd='" + user_passwd + '\'' +
                ", user_ismanager=" + user_ismanager +
                '}';
    }

}
