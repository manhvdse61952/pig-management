package com.example.manh.pig_management.TabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.manh.pig_management.R;

import static com.example.manh.pig_management.MainActivity.listThuoc;

/**
 * Created by Manh on 25/10/2017.
 */

public class tab3_total extends AppCompatActivity {
    TextView txtTitleTotal;
    //TextView txtDayTotal;
    ListView lvTotal;
    Button btnClose;

    tab3_total_adapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab3_4_total);

        //Gọi các component trong tab3_4_total
        txtTitleTotal = (TextView)findViewById(R.id.txtTitleTotal);
        //txtDayTotal = (TextView)findViewById(txtDayTotal);
        lvTotal = (ListView)findViewById(R.id.lvTotal);
        btnClose = (Button)findViewById(R.id.btnClose);

        //Xử lý từng component
        txtTitleTotal.setText("Tổng lượng thuốc trong kho");
        //txtDayTotal.setText(pickDateThuoc);

        adapter = new tab3_total_adapter(this, R.layout.tab3_4_storage, listThuoc);
        lvTotal.setAdapter(adapter);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //////////////////////////////// Xử lý tổng thuốc trong ngày ///////////////////////////////////
//    public void executeTongthuoc() {
//        listTongthuoc = new ArrayList<AdapterModel>();
//        listTemp = new ArrayList<Chitiet_LichtiemphongModel>();
//        listTemp = listLichtiem2;
//        int tongthuoc = 0;
//
//        for (int i=0;i<listTemp.size();i++){
//            String thuoc_name = listTemp.get(i).getThuoc_name();
//            tongthuoc = Integer.parseInt(listTemp.get(i).getSoluong());
//            for (int j=i+1;j<listTemp.size();j++){
//                if (listTemp.get(j).getThuoc_name().equalsIgnoreCase(thuoc_name)){
//                    tongthuoc += Integer.parseInt(listTemp.get(j).getSoluong());
//                    listTemp.remove(j);
//                    j = j-1;
//                }
//            }
//            listTongthuoc.add(new AdapterModel(thuoc_name,Integer.toString(tongthuoc)));
//        }
//    }
}
