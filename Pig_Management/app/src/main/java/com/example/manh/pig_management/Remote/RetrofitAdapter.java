package com.example.manh.pig_management.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Manh on 7/11/2017.
 */

public class RetrofitAdapter {
    private static Retrofit retrofit;
    //202.78.227.33:8000
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://202.78.227.33:8000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
