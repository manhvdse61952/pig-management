package com.example.manh.pig_management.Interface;

import com.example.manh.pig_management.Model.ChitietLichtiemphongApiModel;

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

public interface ChitietLichtiemphongAPI {
    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    @GET("api/testchitietlichtiem")
    Call<List<ChitietLichtiemphongApiModel>> getChitietLichtiemphong();

    @FormUrlEncoded
    @POST("api/testaddlichtiem")
    Call<ResponseBody> addNewLichtiem(@Field("ngaytiem") String ngaytiem,
                                       @Field("ochuong_name") String ochuong_name,
                                       @Field("thuoc_name") String thuoc_name,
                                       @Field("soluong") String soluong);


}
