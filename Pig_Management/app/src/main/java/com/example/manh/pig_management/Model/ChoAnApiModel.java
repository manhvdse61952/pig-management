package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class ChoAnApiModel {
    @SerializedName("ngaychoan")
    @Expose
    private String ngaychoan;
    @SerializedName("ochuong_name")
    @Expose
    private String ochuongName;
    @SerializedName("thucan_name")
    @Expose
    private String thucanName;
    @SerializedName("soluong")
    @Expose
    private String soluong;
    @SerializedName("isDone")
    @Expose
    private Integer isDone;

    public String getNgaychoan() {
        return ngaychoan;
    }

    public void setNgaychoan(String ngaychoan) {
        this.ngaychoan = ngaychoan;
    }

    public String getOchuongName() {
        return ochuongName;
    }

    public void setOchuongName(String ochuongName) {
        this.ochuongName = ochuongName;
    }

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

    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }
}
