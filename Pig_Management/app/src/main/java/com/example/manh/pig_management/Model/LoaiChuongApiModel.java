package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class LoaiChuongApiModel {
    @SerializedName("loaichuong_name")
    @Expose
    private String loaichuongName;

    public String getLoaichuongName() {
        return loaichuongName;
    }

    public void setLoaichuongName(String loaichuongName) {
        this.loaichuongName = loaichuongName;
    }
}
