package com.example.manh.pig_management.Model;

import java.io.Serializable;

/**
 * Created by Manh on 4/11/2017.
 */

public class Tab1AdapterModel implements Serializable {
    private String txtLoaiHeoName;
    private String percent;
    private String txtSoluong;

    public Tab1AdapterModel(String txtLoaiHeoName, String percent, String txtSoluong) {
        this.txtLoaiHeoName = txtLoaiHeoName;
        this.percent = percent;
        this.txtSoluong = txtSoluong;
    }

    public String getTxtLoaiHeoName() {
        return txtLoaiHeoName;
    }

    public void setTxtLoaiHeoName(String txtLoaiHeoName) {
        this.txtLoaiHeoName = txtLoaiHeoName;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getTxtSoluong() {
        return txtSoluong;
    }

    public void setTxtSoluong(String txtSoluong) {
        this.txtSoluong = txtSoluong;
    }
}
