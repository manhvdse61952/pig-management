package com.example.manh.pig_management.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manh on 7/11/2017.
 */

public class HeoApiModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("ngaysinh")
    @Expose
    private String ngaysinh;
    @SerializedName("giongheo_name")
    @Expose
    private String giongheoName;
    @SerializedName("nguongoc")
    @Expose
    private String nguongoc;
    @SerializedName("lua")
    @Expose
    private String lua;
    @SerializedName("ngaynhap")
    @Expose
    private String ngaynhap;
    @SerializedName("giamuavao")
    @Expose
    private String giamuavao;
    @SerializedName("heome_code")
    @Expose
    private String heomeCode;
    @SerializedName("ochuong_name")
    @Expose
    private String ochuongName;
    @SerializedName("daychuong_name")
    @Expose
    private String daychuongName;
    @SerializedName("loaichuong_name")
    @Expose
    private String loaichuongName;
    @SerializedName("heobo_code")
    @Expose
    private String heoboCode;
    @SerializedName("loaiheo_name")
    @Expose
    private String loaiheoName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGiongheoName() {
        return giongheoName;
    }

    public void setGiongheoName(String giongheoName) {
        this.giongheoName = giongheoName;
    }

    public String getNguongoc() {
        return nguongoc;
    }

    public void setNguongoc(String nguongoc) {
        this.nguongoc = nguongoc;
    }

    public String getLua() {
        return lua;
    }

    public void setLua(String lua) {
        this.lua = lua;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getGiamuavao() {
        return giamuavao;
    }

    public void setGiamuavao(String giamuavao) {
        this.giamuavao = giamuavao;
    }

    public String getHeomeCode() {
        return heomeCode;
    }

    public void setHeomeCode(String heomeCode) {
        this.heomeCode = heomeCode;
    }

    public String getOchuongName() {
        return ochuongName;
    }

    public void setOchuongName(String ochuongName) {
        this.ochuongName = ochuongName;
    }

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

    public String getHeoboCode() {
        return heoboCode;
    }

    public void setHeoboCode(String heoboCode) {
        this.heoboCode = heoboCode;
    }

    public String getLoaiheoName() {
        return loaiheoName;
    }

    public void setLoaiheoName(String loaiheoName) {
        this.loaiheoName = loaiheoName;
    }

}
