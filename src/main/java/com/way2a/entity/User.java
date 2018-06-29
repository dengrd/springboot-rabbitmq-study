package com.way2a.entity;

import java.io.Serializable;

/**
 * Created by 11431 on 2018/4/15.
 */
public class User implements Serializable{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
