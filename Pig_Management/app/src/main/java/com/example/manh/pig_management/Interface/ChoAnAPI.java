package com.example.manh.pig_management.Interface;

import com.example.manh.pig_management.Model.ChoAnApiModel;
import com.example.manh.pig_management.Model.GiongHeoApiModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Manh on 7/11/2017.
 */

public interface ChoAnAPI {
    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    @GET("api/testchoan")
    Call<List<ChoAnApiModel>> getChoAn();

    @FormUrlEncoded
    @POST("api/testaddlichchoan")
    Call<ResponseBody> addNewLichchoan(@Field("ngaychoan") String ngaytiem,
                                      @Field("ochuong_name") String ochuong_name,
                                      @Field("thucan_name") String thucan_name,
                                      @Field("soluong") String soluong);
}
