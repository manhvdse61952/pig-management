package com.example.manh.pig_management.TabLayout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manh.pig_management.Interface.ChitietLichtiemphongAPI;
import com.example.manh.pig_management.Interface.ChoAnAPI;
import com.example.manh.pig_management.Model.ChoAnApiModel;
import com.example.manh.pig_management.R;
import com.example.manh.pig_management.Remote.RetrofitAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.media.CamcorderProfile.get;
import static com.example.manh.pig_management.MainActivity.listChoAn;
import static com.example.manh.pig_management.MainActivity.listDaychuong;
import static com.example.manh.pig_management.MainActivity.listLoaichuong;
import static com.example.manh.pig_management.MainActivity.listLoaithucan;
import static com.example.manh.pig_management.MainActivity.listLoaithuoc;
import static com.example.manh.pig_management.MainActivity.listOchuong;
import static com.example.manh.pig_management.MainActivity.listThucan;
import static com.example.manh.pig_management.MainActivity.listThuoc;
import static com.example.manh.pig_management.MainActivity.mViewPager;
import static com.example.manh.pig_management.Model.MyProgressBar.dismiss;
import static com.example.manh.pig_management.R.id.lvFragment;

/**
 * Created by Manh on 31/10/2017.
 */

public class tab4_add extends AppCompatActivity {
    TextView txtTitleAdd, txtLoaiAdd, txtNameAdd, txtSoluongAdd;
    EditText edtSoluong;
    TextView txtDayAdd;
    Calendar mCurrentDate;
    int day,month,year;

    List<String> listLoaiChuongTemp = new ArrayList<>();
    List<String> listDaychuongTemp = new ArrayList<>();
    List<String> listOchuongTemp = new ArrayList<>();
    List<String> listLoaithucanTemp = new ArrayList<>();
    List<String> listThucanTemp = new ArrayList<>();
    List<String> listSoluongTemp = new ArrayList<>();
    Button buttonClose, btnAdd;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab3_4_add);

        //Set up day
        getCurrentday();
        txtDayAdd = (TextView)findViewById(R.id.txtDayAdd);
        txtDayAdd.setText(day+"/"+month+"/"+year);
        month = month - 1;
        txtDayAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(tab4_add.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        txtDayAdd.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        //Change title
        txtTitleAdd = (TextView)findViewById(R.id.txtTitleAdd);
        txtTitleAdd.setText("Thêm lịch cho ăn");
        txtLoaiAdd = (TextView)findViewById(R.id.txtLoaiAdd);
        txtLoaiAdd.setText("Loại thức ăn:");
        txtNameAdd = (TextView)findViewById(R.id.txtNameAdd);
        txtNameAdd.setText("Tên thức ăn:");
        txtSoluongAdd = (TextView) findViewById(R.id.textView29);
        final Spinner spn = (Spinner)findViewById(R.id.spnLoaichuongAdd);
        final Spinner spn2 = (Spinner)findViewById(R.id.spnDaychuongAdd);
        final Spinner spn3 = (Spinner)findViewById(R.id.spnOchuongAdd);
        final Spinner spn4 = (Spinner) findViewById(R.id.spnLoaiAdd);
        final Spinner spn5 = (Spinner) findViewById(R.id.spnNameAdd);

        // Import loai chuong drop-down list
        listLoaiChuongTemp.clear();
        listLoaiChuongTemp.add("Chọn loại chuồng");
        for (int i=0;i<listLoaichuong.size();i++){
            listLoaiChuongTemp.add(listLoaichuong.get(i).getLoaichuongName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(tab4_add.this, android.R.layout.simple_spinner_dropdown_item, listLoaiChuongTemp);
        spn.setAdapter(adapter);

        //...... Default dãy chuồng spinner
        listDaychuongTemp.clear();
        for (int k = 0; k < listDaychuong.size();k++) {
            if (listDaychuong.get(k).getLoaichuongName().equalsIgnoreCase(spn.getSelectedItem().toString())){
                listDaychuongTemp.add(listDaychuong.get(k).getDaychuongName());
            }
        }
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                listDaychuongTemp.clear();
                listOchuongTemp.clear();
                for (int k = 0; k < listDaychuong.size();k++) {
                    if (listDaychuong.get(k).getLoaichuongName().equalsIgnoreCase(spn.getSelectedItem().toString())){
                        listDaychuongTemp.add(listDaychuong.get(k).getDaychuongName());
                    }
                }
                spn2.setAdapter(new ArrayAdapter<String>(tab4_add.this, android.R.layout.simple_spinner_dropdown_item, listDaychuongTemp));

                for (int m = 0; m < listOchuong.size();m++){
                    if (listOchuong.get(m).getLoaichuongName().equalsIgnoreCase(spn.getSelectedItem().toString())&&listOchuong.get(m).getDaychuongName().equalsIgnoreCase(spn2.getSelectedItem().toString())) {
                        listOchuongTemp.add(listOchuong.get(m).getOchuongName());
                    }
                }
                spn3.setAdapter(new ArrayAdapter<String>(tab4_add.this, android.R.layout.simple_spinner_dropdown_item, listOchuongTemp));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Import dãy chuồng dropdown list
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(tab4_add.this, android.R.layout.simple_spinner_dropdown_item, listDaychuongTemp);
        spn2.setAdapter(adapter2);
        //....... Defaul ô chuồng spinner
        listOchuongTemp.clear();
        for (int j = 0; j< listOchuong.size();j++){
            if (listOchuong.get(j).getLoaichuongName().equalsIgnoreCase(spn.getSelectedItem().toString())&&listOchuong.get(j).getDaychuongName().equalsIgnoreCase(spn2.getSelectedItem().toString())){
                listOchuongTemp.add(listOchuong.get(j).getOchuongName());
            }
        }

        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                listOchuongTemp.clear();
                for (int m = 0; m < listOchuong.size();m++){
                    if (listOchuong.get(m).getLoaichuongName().equalsIgnoreCase(spn.getSelectedItem().toString())&&listOchuong.get(m).getDaychuongName().equalsIgnoreCase(spn2.getSelectedItem().toString())) {
                        listOchuongTemp.add(listOchuong.get(m).getOchuongName());
                    }
                }
                spn3.setAdapter(new ArrayAdapter<String>(tab4_add.this, android.R.layout.simple_spinner_dropdown_item, listOchuongTemp));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        //Import o chuong dropdown list

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(tab4_add.this, android.R.layout.simple_spinner_dropdown_item, listOchuongTemp);
        spn3.setAdapter(adapter3);
        spn3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Import loai thuoc dropdown list
        listLoaithucanTemp.clear();
        listLoaithucanTemp.add("Chọn loại thức ăn");
        for (int i=0;i<listLoaithucan.size();i++){
            listLoaithucanTemp.add(listLoaithucan.get(i).getLoaithucanName());
        }

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listLoaithucanTemp);
        spn4.setAdapter(adapter4);
        spn4.setSelection(0);

        //...... Default thuốc spinner
        listThucanTemp.clear();
        for (int k = 0; k < listThucan.size();k++) {
            if (listThucan.get(k).getLoaithucanName().equalsIgnoreCase(spn4.getSelectedItem().toString())){
                listThucanTemp.add(listThucan.get(k).getThucanName());
            }
        }
        spn4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                listThucanTemp.clear();
                for (int k = 0; k < listThucan.size();k++) {
                    if (listThucan.get(k).getLoaithucanName().equalsIgnoreCase(spn4.getSelectedItem().toString())){
                        listThucanTemp.add(listThucan.get(k).getThucanName());
                        listSoluongTemp.add(listThucan.get(k).getSoluong());
                    }
                }
                spn5.setAdapter(new ArrayAdapter<String>(tab4_add.this, android.R.layout.simple_spinner_dropdown_item, listThucanTemp));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Import ten thuoc dropdown list
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listThucanTemp);
        spn5.setAdapter(adapter5);
        spn5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tenthuoc = spn5.getSelectedItem().toString();
                for (int j=0;j<listThucan.size();j++){
                    if (tenthuoc.equalsIgnoreCase(listThucan.get(j).getThucanName())){
                        txtSoluongAdd.setText(listThucan.get(j).getSoluong());
                    }
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Close button
        buttonClose = (Button)findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Retrofit test = RetrofitAdapter.getClient();
//                final ChoAnAPI testAPI = test.create(ChoAnAPI.class);
//                Call<List<ChoAnApiModel>> mapCall = testAPI.getChoAn();
//                mapCall.enqueue(new Callback<List<ChoAnApiModel>>() {
//                    @Override
//                    public void onResponse(Call<List<ChoAnApiModel>> call, Response<List<ChoAnApiModel>> response) {
//                        listChoAn.clear();
//                        listChoAn = new ArrayList<ChoAnApiModel>();
//                        listChoAn = response.body();
//                        finish();
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<ChoAnApiModel>> call, Throwable t) {
//
//                    }
//                });
                finish();

            }
        });

        //Add button
        edtSoluong = (EditText)findViewById(R.id.edtSoluong);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spn.getSelectedItem().toString().equalsIgnoreCase("Chọn loại chuồng") || spn2.getSelectedItem().toString().equalsIgnoreCase("")||spn3.getSelectedItem().toString().equalsIgnoreCase("")||spn4.getSelectedItem().toString().equalsIgnoreCase("Chọn loại thuốc")||spn5.getSelectedItem().toString().equalsIgnoreCase("")){
                    Toast.makeText(tab4_add.this, "Hãy chọn đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (edtSoluong.getText().toString().equals("")) {
                        Toast.makeText(tab4_add.this, "Điền số lượng cần thêm", Toast.LENGTH_SHORT).show();
                    } else {
                        int soluongkho = Integer.parseInt(txtSoluongAdd.getText().toString());
                        int soluongmuon = Integer.parseInt(edtSoluong.getText().toString());

                        if (soluongmuon > soluongkho) {
                            Toast.makeText(tab4_add.this, "Số lượng không đủ", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            String ngay = ((TextView) findViewById(R.id.txtDayAdd)).getText().toString();
                            String ochuong = spn3.getSelectedItem().toString();
                            String tenthucan = spn5.getSelectedItem().toString();
                            String soluong = edtSoluong.getText().toString();

                            Retrofit test = RetrofitAdapter.getClient();
                            final ChoAnAPI testAPI = test.create(ChoAnAPI.class);
                            Call<ResponseBody> responseBodyCall = testAPI.addNewLichchoan(ngay, ochuong, tenthucan, soluong);
                            responseBodyCall.enqueue(new Callback<ResponseBody>() {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                    Toast.makeText(tab4_add.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                                    spn.setSelection(0);
                                    spn4.setSelection(0);
                                    edtSoluong.setText("");
                                    txtSoluongAdd.setText("0");
                                }

                                @Override
                                public void onFailure(Call<ResponseBody> call, Throwable t) {

                                }
                            });

                        }
                    }
                }
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
