package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class ChitietLichtiemphongApiModel {
    @SerializedName("ngaytiem")
    @Expose
    private String ngaytiem;
    @SerializedName("ochuong_name")
    @Expose
    private String ochuongName;
    @SerializedName("thuoc_name")
    @Expose
    private String thuocName;
    @SerializedName("soluong")
    @Expose
    private String soluong;
    @SerializedName("isDone")
    @Expose
    private Integer isDone;
    @SerializedName("donvi")
    @Expose
    private String donvi;

    public String getNgaytiem() {
        return ngaytiem;
    }

    public void setNgaytiem(String ngaytiem) {
        this.ngaytiem = ngaytiem;
    }

    public String getOchuongName() {
        return ochuongName;
    }

    public void setOchuongName(String ochuongName) {
        this.ochuongName = ochuongName;
    }

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

    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
}
