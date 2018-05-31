package com.example.manh.pig_management.TabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.manh.pig_management.R;

import static com.example.manh.pig_management.MainActivity.listThucan;

/**
 * Created by Manh on 25/10/2017.
 */

public class tab4_total extends AppCompatActivity {
    TextView txtTitleTotal;
    TextView txtDayTotal;
    ListView lvTotal;
    Button btnClose;

    tab4_total_adapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab3_4_total);

        //Gọi các component trong tab3_4_total
        txtTitleTotal = (TextView)findViewById(R.id.txtTitleTotal);
        //txtDayTotal = (TextView)findViewById(R.id.txtDayTotal);
        lvTotal = (ListView)findViewById(R.id.lvTotal);
        btnClose = (Button)findViewById(R.id.btnClose);

        //Xử lý từng component
        txtTitleTotal.setText("Tổng lượng thức ăn trong kho");
        //txtDayTotal.setText(pickDateThucAn);

        adapter = new tab4_total_adapter(this, R.layout.tab3_4_storage, listThucan);
        lvTotal.setAdapter(adapter);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
