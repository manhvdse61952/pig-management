package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class LoaiHeoApiModel {
    @SerializedName("loaiheo_name")
    @Expose
    private String loaiheoName;

    public String getLoaiheoName() {
        return loaiheoName;
    }

    public void setLoaiheoName(String loaiheoName) {
        this.loaiheoName = loaiheoName;
    }
}
