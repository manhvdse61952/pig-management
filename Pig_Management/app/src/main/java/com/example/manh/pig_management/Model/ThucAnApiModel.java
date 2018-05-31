package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class ThucAnApiModel {
    @SerializedName("thucan_name")
    @Expose
    private String thucanName;
    @SerializedName("soluong")
    @Expose
    private String soluong;
    @SerializedName("loaithucan_name")
    @Expose
    private String loaithucanName;

    public String getThucanName() {
        return thucanName;
    }

    public void setThucanName(String thucanName) {
        this.thucanName = thucanName;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getLoaithucanName() {
        return loaithucanName;
    }

    public void setLoaithucanName(String loaithucanName) {
        this.loaithucanName = loaithucanName;
    }
}
