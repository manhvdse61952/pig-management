package com.example.manh.pig_management;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manh.pig_management.Interface.ChitietLichtiemphongAPI;
import com.example.manh.pig_management.Interface.LoginAPI;
import com.example.manh.pig_management.Remote.RetrofitAdapter;
import com.example.manh.pig_management.TabLayout.tab3_add;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.manh.pig_management.R.id.edtSoluong;

/**
 * Created by Manh on 7/11/2017.
 */

public class login extends AppCompatActivity {
    Button btnDangNhap;
    EditText edtUs, edtPs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtUs = (EditText)findViewById(R.id.username);
        edtPs = (EditText)findViewById(R.id.password);


        btnDangNhap = (Button)findViewById(R.id.btnDangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit test = RetrofitAdapter.getClient();
                final LoginAPI testAPI = test.create(LoginAPI.class);
                Call<ResponseBody> responseBodyCall = testAPI.checkLogin(edtUs.getText().toString(), edtPs.getText().toString());
                responseBodyCall.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.body() == null){
                            Toast.makeText(login.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Intent intent = new Intent(login.this, MainActivity.class);
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(login.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}
