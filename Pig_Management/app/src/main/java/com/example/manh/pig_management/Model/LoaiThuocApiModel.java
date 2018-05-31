package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class LoaiThuocApiModel {
    @SerializedName("loaithuoc_name")
    @Expose
    private String loaithuocName;

    public String getLoaithuocName() {
        return loaithuocName;
    }

    public void setLoaithuocName(String loaithuocName) {
        this.loaithuocName = loaithuocName;
    }
}
