package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class LoaiThucAnApiModel {
    @SerializedName("loaithucan_name")
    @Expose
    private String loaithucanName;

    public String getLoaithucanName() {
        return loaithucanName;
    }

    public void setLoaithucanName(String loaithucanName) {
        this.loaithucanName = loaithucanName;
    }
}
