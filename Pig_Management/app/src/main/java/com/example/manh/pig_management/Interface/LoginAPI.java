package com.example.manh.pig_management.Interface;

import com.example.manh.pig_management.Model.LoaiThuocApiModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Manh on 8/11/2017.
 */

public interface LoginAPI {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> checkLogin(@Field("username") String username,
                                      @Field("password") String password);


}
