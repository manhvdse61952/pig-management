package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class DayChuongApiModel {
    @SerializedName("daychuong_name")
    @Expose
    private String daychuongName;
    @SerializedName("loaichuong_name")
    @Expose
    private String loaichuongName;

    public String getDaychuongName() {
        return daychuongName;
    }

    public void setDaychuongName(String daychuongName) {
        this.daychuongName = daychuongName;
    }

    public String getLoaichuongName() {
        return loaichuongName;
    }

    public void setLoaichuongName(String loaichuongName) {
        this.loaichuongName = loaichuongName;
    }
}
