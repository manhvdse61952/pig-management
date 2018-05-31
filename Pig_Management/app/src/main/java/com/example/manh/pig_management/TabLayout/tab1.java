package com.example.manh.pig_management.TabLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.manh.pig_management.R;
import com.example.manh.pig_management.login;

import static com.example.manh.pig_management.MainActivity.listChitietLichtiemphong;
import static com.example.manh.pig_management.MainActivity.listChoAn;
import static com.example.manh.pig_management.MainActivity.listHeo;
import static com.example.manh.pig_management.MainActivity.listSodoHeo;
import static com.example.manh.pig_management.MainActivity.mViewPager;

/**
 * Created by Manh on 22/10/2017.
 */

public class tab1 extends Fragment {


    ListView lvSodo;
    TextView txtTongheoTab1, soTask, txtLogout;
    Button btnTab1Choan, btnTab1Lichtiem;
    LinearLayout ln1, ln2;
    tab1_adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);

        txtTongheoTab1 = (TextView) view.findViewById(R.id.txtTongheoTab1);
        txtTongheoTab1.setText(listHeo.size()+"");
        soTask = (TextView) view.findViewById(R.id.soTask);
        soTask.setText(listChitietLichtiemphong.size() + listChoAn.size() + "");


        btnTab1Choan = (Button) view.findViewById(R.id.btnTab1ChoAn);
        btnTab1Choan.setText(listChitietLichtiemphong.size() + "");
        btnTab1Lichtiem = (Button) view.findViewById(R.id.btnTab1Lichtiem);
        btnTab1Lichtiem.setText(listChoAn.size()+"");



        lvSodo =(ListView)view.findViewById(R.id.lvSodoHeo);
        adapter = new tab1_adapter(this, listSodoHeo, getActivity());
        lvSodo.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ln1 = (LinearLayout) view.findViewById(R.id.choanpng);
        ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });

        ln2 = (LinearLayout) view.findViewById(R.id.lichtiempng);
        ln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(3);
            }
        });

        txtLogout = (TextView) view.findViewById(R.id.txtLogout);
        txtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), login.class);
                startActivity(intent);
            }
        });
    }
}
