package com.example.manh.pig_management.TabLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.manh.pig_management.Model.Tab1AdapterModel;
import com.example.manh.pig_management.R;

import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by Manh on 4/11/2017.
 */

public class tab1_adapter extends BaseAdapter {
    Context context;
    private static LayoutInflater inf = null;
    private List<Tab1AdapterModel> listSodo;

    public tab1_adapter(tab1 t1, List<Tab1AdapterModel> listSodo, Context context) {
        this.context = context;
        this.listSodo = listSodo;
        inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listSodo.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtLoaiheoTab1;
        View viewSodo;
        TextView txtSoluongTab1;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        final Tab1AdapterModel obj = listSodo.get(i);
        if (view == null) {
            holder = new ViewHolder();
            view = inf.inflate(R.layout.tab1_item, null);
            holder.txtLoaiheoTab1 = (TextView) view.findViewById(R.id.txtLoaiheoTab1);
            holder.viewSodo = (View) view.findViewById(R.id.viewSodo);
            holder.txtSoluongTab1 = (TextView) view.findViewById(R.id.txtSoluongTab1);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtLoaiheoTab1.setText(obj.getTxtLoaiHeoName());
        holder.txtSoluongTab1.setText(obj.getTxtSoluong());
        holder.viewSodo.getLayoutParams().width = Integer.parseInt(obj.getPercent());
        return view;
    }
}
