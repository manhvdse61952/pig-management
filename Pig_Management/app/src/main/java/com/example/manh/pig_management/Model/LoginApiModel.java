package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 8/11/2017.
 */

public class LoginApiModel {
    @SerializedName("username")
    @Expose
    private Integer id;
    @SerializedName("password")
    @Expose
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
