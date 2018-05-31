package com.example.manh.pig_management.TabLayout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.manh.pig_management.Interface.ChitietLichtiemphongAPI;
import com.example.manh.pig_management.Interface.ChoAnAPI;
import com.example.manh.pig_management.Model.ChitietLichtiemphongApiModel;
import com.example.manh.pig_management.Model.ChoAnApiModel;
import com.example.manh.pig_management.R;
import com.example.manh.pig_management.Remote.RetrofitAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.manh.pig_management.MainActivity.listChitietLichtiemphong;
import static com.example.manh.pig_management.MainActivity.listChoAn;

/**
 * Created by Manh on 22/10/2017.
 */

public class tab3 extends Fragment {
    TextView txtDay;
    Calendar mCurrentDate;
    int day,month,year;
    public static String pickDateThuoc;

    Button btnTotal, btnAddLichtiem, btnCapnhat;
    LinearLayout ln;

    ListView lvFragment;
    tab3_adapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3, container, false);
        lvFragment=(ListView)view.findViewById(R.id.lvFragment);
        adapter = new tab3_adapter(this, listChitietLichtiemphong, getActivity());
        lvFragment.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ///////////////////// Set day in textview ///////////////////////////////////////


        getCurrentday();
        txtDay = (TextView)view.findViewById(R.id.txtDay);
        txtDay.setText(day+"/"+month+"/"+year);
        pickDateThuoc = day+"/"+month+"/"+year;
        month = month - 1;
//        txtDay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
//                        monthOfYear = monthOfYear+1;
//                        txtDay.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
//                        pickDateThuoc = dayOfMonth+"/"+monthOfYear+"/"+year;
//                    }
//                },year,month,day);
//                datePickerDialog.show();
//            }
//        });



        ///////////////////// Open intent thêm thuoc //////////////////////////////////////////
        btnAddLichtiem = (Button)view.findViewById(R.id.btnAddLichtiem);
        btnAddLichtiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), tab3_add.class);
                startActivity(intent);
            }
        });
        ln = (LinearLayout) view.findViewById(R.id.lnKhothuoc);
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), tab3_total.class);
                startActivity(intent);
            }
        });


        btnCapnhat = (Button)view.findViewById(R.id.btnCapnhat);
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit test = RetrofitAdapter.getClient();
                final ChitietLichtiemphongAPI testAPI = test.create(ChitietLichtiemphongAPI.class);
                Call<List<ChitietLichtiemphongApiModel>> mapCall = testAPI.getChitietLichtiemphong();
                mapCall.enqueue(new Callback<List<ChitietLichtiemphongApiModel>>() {
                    @Override
                    public void onResponse(Call<List<ChitietLichtiemphongApiModel>> call, Response<List<ChitietLichtiemphongApiModel>> response) {
                        listChitietLichtiemphong.clear();
                        listChitietLichtiemphong = new ArrayList<ChitietLichtiemphongApiModel>();
                        listChitietLichtiemphong = response.body();

                        adapter = new tab3_adapter(tab3.this, listChitietLichtiemphong, getActivity());
                        lvFragment.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<ChitietLichtiemphongApiModel>> call, Throwable t) {

                    }
                });
            }
        });

    }

    public void getCurrentday(){
        mCurrentDate = Calendar.getInstance();
        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);
        month = month +1;
    }

}
