package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class GiongHeoApiModel {
    @SerializedName("giongheo_name")
    @Expose
    private String giongheoName;

    public String getGiongheoName() {
        return giongheoName;
    }

    public void setGiongheoName(String giongheoName) {
        this.giongheoName = giongheoName;
    }
}
