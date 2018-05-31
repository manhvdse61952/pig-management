package com.example.manh.pig_management.Model;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Manh on 7/11/2017.
 */

public class MyProgressBar {
    private static ProgressDialog _instance = null;
    private MyProgressBar(){

    }
    public synchronized static void show(Context context){
        if(_instance == null){
            _instance = new ProgressDialog(context);
            _instance.setMessage("Loading...");
        }
        _instance.setIndeterminate(false);
        _instance.setCancelable(true);
        _instance.setCanceledOnTouchOutside(false);
        _instance.show();
    }

    public synchronized static void dismiss(){
        _instance.dismiss();
        _instance = null;
    }
}

