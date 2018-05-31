package com.example.manh.pig_management.Interface;

import com.example.manh.pig_management.Model.LoaiThucAnApiModel;
import com.example.manh.pig_management.Model.LoaiThuocApiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Manh on 7/11/2017.
 */

public interface LoaiThucAnAPI {
    @Headers({"Content-Type: application/json", "Cache-Control: max-age=640000"})
    @GET("api/testloaithucan")
    Call<List<LoaiThucAnApiModel>> getLoaiThucAn();
}
