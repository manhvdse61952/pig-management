package com.example.manh.pig_management.Model;

import java.io.Serializable;

/**
 * Created by Manh on 26/10/2017.
 */

public class AdapterModel implements Serializable {
    private String name;
    private String soluong;
    private String donvi;

    public AdapterModel(String name, String soluong, String donvi) {
        this.name = name;
        this.soluong = soluong;
        this.donvi = donvi;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
}
