package com.example.manh.pig_management.TabLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.manh.pig_management.Model.ThuocApiModel;
import com.example.manh.pig_management.R;

import java.util.List;

/**
 * Created by Manh on 26/10/2017.
 */

public class tab3_total_adapter extends BaseAdapter {
    private tab3_total context;
    private int layout;
    private List<ThuocApiModel> listTongthuoc;

    public tab3_total_adapter(tab3_total context, int layout, List<ThuocApiModel> listTongthuoc) {
        this.context = context;
        this.layout = layout;
        this.listTongthuoc = listTongthuoc;
    }

    @Override
    public int getCount() {
        return listTongthuoc.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder{
        TextView txtTen;
        TextView txtSoluong;
        TextView txtLoai;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        final ThuocApiModel obj = listTongthuoc.get(i);
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtTen = (TextView) view.findViewById(R.id.txtTen);
            holder.txtSoluong = (TextView) view.findViewById(R.id.txtSoluong);
            holder.txtLoai = (TextView) view.findViewById(R.id.txtLoai);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtTen.setText(obj.getThuocName());
        holder.txtLoai.setText(obj.getLoaithuocName());
        holder.txtSoluong.setText(obj.getSoluong());
        return view;
    }
}
