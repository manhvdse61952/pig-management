package com.example.manh.pig_management.TabLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.manh.pig_management.Model.ChitietLichtiemphongApiModel;
import com.example.manh.pig_management.R;

import java.util.List;

/**
 * Created by Manh on 25/10/2017.
 */

public class tab3_adapter extends BaseAdapter {
    Context context;
    private static LayoutInflater inf = null;
    private List<ChitietLichtiemphongApiModel> listLichtiemAdapter;

    public tab3_adapter(tab3 t3, List<ChitietLichtiemphongApiModel> listLichtiemAdapter, Context context) {
        this.context = context;
        this.listLichtiemAdapter = listLichtiemAdapter;
        inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return listLichtiemAdapter.size();
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
        TextView txtLichOchuong, foodname, soluongTab34, donviTab34;
        CheckBox cbxDone;
        LinearLayout ln;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        final ChitietLichtiemphongApiModel obj = listLichtiemAdapter.get(i);
        if (view == null) {
                holder = new ViewHolder();
                view = inf.inflate(R.layout.tab3_4_item, null);
                holder.txtLichOchuong = (TextView) view.findViewById(R.id.txtLichOchuong);
            holder.foodname = (TextView) view.findViewById(R.id.foodname);
            holder.soluongTab34 = (TextView) view.findViewById(R.id.soluongTab34);
            holder.donviTab34 = (TextView) view.findViewById(R.id.donviTab34);
                holder.cbxDone = (CheckBox) view.findViewById(R.id.cbxDone);
            holder.ln = (LinearLayout) view.findViewById(R.id.itemlich);
                view.setTag(holder);
        }else {
                holder = (ViewHolder) view.getTag();
            }
            holder.txtLichOchuong.setText(obj.getOchuongName());
        holder.foodname.setText(obj.getThuocName());
        holder.soluongTab34.setText(obj.getSoluong());
        holder.donviTab34.setText(obj.getDonvi());
        if (obj.getIsDone()==0){
            holder.cbxDone.setChecked(false);

        }
        else {
            holder.cbxDone.setChecked(true);

        }

        holder.ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.cbxDone.isChecked()){
                    holder.cbxDone.setChecked(false);
                }
                else{
                    holder.cbxDone.setChecked(true);
                }
            }
        });

//        holder.rl.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(view.getContext(), tab3_detail.class);
//                    intent.putExtra("Detail-lichtiem",obj);
//                    view.getContext().startActivity(intent);
//                }
//            });


            return view;
        }

}
