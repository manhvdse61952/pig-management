package com.example.manh.pig_management.TabLayout;

import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
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
import android.widget.Toast;

import com.example.manh.pig_management.Interface.ChoAnAPI;
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

import static com.example.manh.pig_management.MainActivity.listChoAn;
import static com.example.manh.pig_management.MainActivity.mViewPager;

/**
 * Created by Manh on 22/10/2017.
 */

public class tab4 extends Fragment {
    TextView txtDay;
    Calendar mCurrentDate;
    int day,month,year;
    public static String pickDateThucAn;

    Button btnTotal, btnAddLichAn, btnCapnhat;
    LinearLayout ln;

    ListView lvFragment;
    tab4_adapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvFragment=(ListView)view.findViewById(R.id.lvFragment);
        adapter = new tab4_adapter(tab4.this, listChoAn, getActivity());
        lvFragment.setAdapter(adapter);




        ///////////////////// Set day in textview ///////////////////////////////////////
        getCurrentday();
        txtDay = (TextView)view.findViewById(R.id.txtDay);

        txtDay.setText(day+"/"+month+"/"+year);
        pickDateThucAn = day+"/"+month+"/"+year;
        month = month - 1;
//        txtDay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
//                        monthOfYear = monthOfYear+1;
//                        txtDay.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
//                        //pickDateThucAn = dayOfMonth+"/"+monthOfYear+"/"+year;
//                    }
//                },year,month,day);
//                datePickerDialog.show();
//            }
//        });


        /////////////////////// Open intent thêm thức ăn ////////////////////////////////////
        btnAddLichAn = (Button)view.findViewById(R.id.btnAddLichAn);
        btnAddLichAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), tab4_add.class);
                startActivity(intent);
            }
        });

        ln = (LinearLayout) view.findViewById(R.id.lnKhothucan);
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), tab4_total.class);
                startActivity(intent);
            }
        });

        btnCapnhat = (Button)view.findViewById(R.id.btnCapnhat);
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit test = RetrofitAdapter.getClient();
                final ChoAnAPI testAPI = test.create(ChoAnAPI.class);
                Call<List<ChoAnApiModel>> mapCall = testAPI.getChoAn();
                mapCall.enqueue(new Callback<List<ChoAnApiModel>>() {
                    @Override
                    public void onResponse(Call<List<ChoAnApiModel>> call, Response<List<ChoAnApiModel>> response) {
                        listChoAn.clear();
                        listChoAn = new ArrayList<ChoAnApiModel>();
                        listChoAn = response.body();

                        adapter = new tab4_adapter(tab4.this, listChoAn, getActivity());
                        lvFragment.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<ChoAnApiModel>> call, Throwable t) {

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
