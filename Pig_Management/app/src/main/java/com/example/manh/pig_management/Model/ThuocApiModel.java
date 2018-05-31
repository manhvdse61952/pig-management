package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class ThuocApiModel {
    @SerializedName("thuoc_name")
    @Expose
    private String thuocName;
    @SerializedName("soluong")
    @Expose
    private String soluong;
    @SerializedName("loaithuoc_name")
    @Expose
    private String loaithuocName;

    public String getThuocName() {
        return thuocName;
    }

    public void setThuocName(String thuocName) {
        this.thuocName = thuocName;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getLoaithuocName() {
        return loaithuocName;
    }

    public void setLoaithuocName(String loaithuocName) {
        this.loaithuocName = loaithuocName;
    }
}
