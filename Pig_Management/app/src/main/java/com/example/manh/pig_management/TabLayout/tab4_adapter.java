package com.example.manh.pig_management.TabLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.manh.pig_management.Model.ChoAnApiModel;
import com.example.manh.pig_management.R;

import java.util.List;

import static com.example.manh.pig_management.R.id.cbxDone;

/**
 * Created by Manh on 25/10/2017.
 */

public class tab4_adapter extends BaseAdapter {
    Context context;
    private static LayoutInflater inf = null;
    private List<ChoAnApiModel> listChoAnAdapter;

    public tab4_adapter(tab4 t4, List<ChoAnApiModel> listChoAnAdapter, Context context) {
        this.context = context;
        this.listChoAnAdapter = listChoAnAdapter;
        inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return listChoAnAdapter.size();
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
        final ChoAnApiModel obj = listChoAnAdapter.get(i);
        if (view == null) {
                holder = new ViewHolder();
                view = inf.inflate(R.layout.tab4_item, null);
                holder.txtLichOchuong = (TextView) view.findViewById(R.id.txtLichOchuong);
            holder.foodname = (TextView) view.findViewById(R.id.foodname);
            holder.soluongTab34 = (TextView) view.findViewById(R.id.soluongTab34);
            holder.donviTab34 = (TextView) view.findViewById(R.id.donviTab34);
            holder.cbxDone = (CheckBox) view.findViewById(cbxDone);

            holder.ln = (LinearLayout) view.findViewById(R.id.itemlich);
                view.setTag(holder);
        }else {
                holder = (ViewHolder) view.getTag();
            }
            holder.txtLichOchuong.setText(obj.getOchuongName());
        holder.foodname.setText(obj.getThucanName());
        holder.soluongTab34.setText(obj.getSoluong());
        holder.donviTab34.setText("Bao");
        if (obj.getIsDone() == 0){
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


            return view;
        }

}
