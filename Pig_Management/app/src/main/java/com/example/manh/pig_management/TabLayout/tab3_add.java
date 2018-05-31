package com.example.manh.pig_management.TabLayout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manh.pig_management.Interface.ChitietLichtiemphongAPI;
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

import static com.example.manh.pig_management.MainActivity.listDaychuong;
import static com.example.manh.pig_management.MainActivity.listLoaichuong;
import static com.example.manh.pig_management.MainActivity.listLoaithuoc;
import static com.example.manh.pig_management.MainActivity.listOchuong;
import static com.example.manh.pig_management.MainActivity.listThuoc;

/**
 * Created by Manh on 31/10/2017.
 */

public class tab3_add extends AppCompatActivity {
    TextView txtTitleAdd, txtLoaiAdd, txtNameAdd, txtSoluongAdd;
    EditText edtSoluong;
    TextView txtDayAdd;
    Calendar mCurrentDate;
    int day,month,year;

    List<String> listLoaiChuongTemp = new ArrayList<>();
    List<String> listDaychuongTemp = new ArrayList<>();
    List<String> listOchuongTemp = new ArrayList<>();
    List<String> listLoaithuocTemp = new ArrayList<>();
    List<String> listThuocTemp = new ArrayList<>();
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
                DatePickerDialog datePickerDialog = new DatePickerDialog(tab3_add.this, new DatePickerDialog.OnDateSetListener() {
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
        txtTitleAdd.setText("Thêm lịch tiêm");
        txtLoaiAdd = (TextView)findViewById(R.id.txtLoaiAdd);
        txtLoaiAdd.setText("Loại thuốc:");
        txtNameAdd = (TextView)findViewById(R.id.txtNameAdd);
        txtNameAdd.setText("Tên thuốc:");
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(tab3_add.this, android.R.layout.simple_spinner_dropdown_item, listLoaiChuongTemp);
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
                spn2.setAdapter(new ArrayAdapter<String>(tab3_add.this, android.R.layout.simple_spinner_dropdown_item, listDaychuongTemp));

                for (int m = 0; m < listOchuong.size();m++){
                    if (listOchuong.get(m).getLoaichuongName().equalsIgnoreCase(spn.getSelectedItem().toString())&&listOchuong.get(m).getDaychuongName().equalsIgnoreCase(spn2.getSelectedItem().toString())) {
                        listOchuongTemp.add(listOchuong.get(m).getOchuongName());
                    }
                }
                spn3.setAdapter(new ArrayAdapter<String>(tab3_add.this, android.R.layout.simple_spinner_dropdown_item, listOchuongTemp));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Import dãy chuồng dropdown list
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(tab3_add.this, android.R.layout.simple_spinner_dropdown_item, listDaychuongTemp);
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
                spn3.setAdapter(new ArrayAdapter<String>(tab3_add.this, android.R.layout.simple_spinner_dropdown_item, listOchuongTemp));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        //Import o chuong dropdown list

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(tab3_add.this, android.R.layout.simple_spinner_dropdown_item, listOchuongTemp);
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
        listLoaithuocTemp.clear();
        listLoaithuocTemp.add("Chọn loại thuốc");
        for (int i=0;i<listLoaithuoc.size();i++){
            listLoaithuocTemp.add(listLoaithuoc.get(i).getLoaithuocName());
        }

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listLoaithuocTemp);
        spn4.setAdapter(adapter4);
        spn4.setSelection(0);

        //...... Default thuốc spinner
        listThuocTemp.clear();
        for (int k = 0; k < listThuoc.size();k++) {
            if (listThuoc.get(k).getLoaithuocName().equalsIgnoreCase(spn4.getSelectedItem().toString())){
                listThuocTemp.add(listThuoc.get(k).getThuocName());
            }
        }
        spn4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                listThuocTemp.clear();
                for (int k = 0; k < listThuoc.size();k++) {
                    if (listThuoc.get(k).getLoaithuocName().equalsIgnoreCase(spn4.getSelectedItem().toString())){
                        listThuocTemp.add(listThuoc.get(k).getThuocName());
                        listSoluongTemp.add(listThuoc.get(k).getSoluong());
                    }
                }
                spn5.setAdapter(new ArrayAdapter<String>(tab3_add.this, android.R.layout.simple_spinner_dropdown_item, listThuocTemp));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Import ten thuoc dropdown list
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listThuocTemp);
        spn5.setAdapter(adapter5);
        spn5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tenthuoc = spn5.getSelectedItem().toString();
                for (int j=0;j<listThuoc.size();j++){
                    if (tenthuoc.equalsIgnoreCase(listThuoc.get(j).getThuocName())){
                        txtSoluongAdd.setText(listThuoc.get(j).getSoluong());
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
                    Toast.makeText(tab3_add.this, "Hãy chọn đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (edtSoluong.getText().toString().equals("")) {
                        Toast.makeText(tab3_add.this, "Điền số lượng cần thêm", Toast.LENGTH_SHORT).show();
                    } else {
                        int soluongkho = Integer.parseInt(txtSoluongAdd.getText().toString());
                        int soluongmuon = Integer.parseInt(edtSoluong.getText().toString());

                        if (soluongmuon > soluongkho) {
                            Toast.makeText(tab3_add.this, "Số lượng không đủ", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            String ngay = ((TextView) findViewById(R.id.txtDayAdd)).getText().toString();
                            String ochuong = spn3.getSelectedItem().toString();
                            String tenthuoc = spn5.getSelectedItem().toString();
                            String soluong = edtSoluong.getText().toString();

                            Retrofit test = RetrofitAdapter.getClient();
                            final ChitietLichtiemphongAPI testAPI = test.create(ChitietLichtiemphongAPI.class);
                            Call<ResponseBody> responseBodyCall = testAPI.addNewLichtiem(ngay, ochuong, tenthuoc, soluong);
                            responseBodyCall.enqueue(new Callback<ResponseBody>() {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                    Toast.makeText(tab3_add.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
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
