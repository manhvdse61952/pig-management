package com.example.manh.pig_management.ExpendableList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manh.pig_management.Model.HeoApiModel;
import com.example.manh.pig_management.Model.HeoApiModel;
import com.example.manh.pig_management.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Manh on 19/10/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<HeoApiModel> _listDataHeader;
    private HashMap<HeoApiModel, HeoApiModel> _listDataChild;


    public ExpandableListAdapter(Context context, List<HeoApiModel> listDataHeader,
                                 HashMap<HeoApiModel, HeoApiModel> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition));
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.tab2_detail, null);
        }


        HeoApiModel hm = (HeoApiModel) getGroup(groupPosition);
        TextView txtGiong = (TextView) convertView.findViewById(R.id.txtGiong);
        txtGiong.setText(hm.getGiongheoName());

        TextView txtBo = (TextView) convertView.findViewById(R.id.txtBo);
        txtBo.setText(hm.getHeoboCode());

        TextView txtMe = (TextView) convertView.findViewById(R.id.txtMe);
        txtMe.setText(hm.getHeomeCode());

        TextView txtNgaysinh = (TextView) convertView.findViewById(R.id.txtNgaysinh);
        txtNgaysinh.setText(hm.getNgaysinh());

        TextView txtNgaynhap = (TextView) convertView.findViewById(R.id.txtNgaynhap);
        txtNgaynhap.setText(hm.getNgaynhap());

        TextView txtLua = (TextView) convertView.findViewById(R.id.txtLua);
        txtLua.setText(hm.getLua());

        TextView txtNguongoc = (TextView) convertView.findViewById(R.id.txtNguongoc);
        txtNguongoc.setText(hm.getNguongoc());

        TextView txtGiamua = (TextView) convertView.findViewById(R.id.txtGiamua);

        List<String> giamuaConvert = new ArrayList<>();
        String reverse = new StringBuffer(hm.getGiamuavao()).reverse().toString();
        String giamua = "";
        if(reverse.length() > 3){
            for(int i=0;i <= reverse.length(); i+=3){
                giamuaConvert.add(reverse.substring(i, Math.min(reverse.length(), i+3)));
            }
            for (int j=giamuaConvert.size()-2;j>=0;j--){
                giamua += giamuaConvert.get(j).toString() + ".";
            }
            giamua += giamuaConvert.get(giamuaConvert.size()-1).toString();
            giamua = new StringBuffer(giamua).reverse().toString() + " đ";
        }
        else {
            giamua = hm.getGiamuavao() + " đ";
        }


        txtGiamua.setText(giamua);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.tab2_item, null);
        }

        HeoApiModel hm = (HeoApiModel) getGroup(groupPosition);
        TextView txtID = (TextView) convertView.findViewById(R.id.txtID);
        txtID.setText(hm.getCode());

        TextView txtLoaiheo = (TextView) convertView.findViewById(R.id.txtLoaiheo);
        txtLoaiheo.setText(hm.getLoaiheoName());

        TextView txtOchuong = (TextView) convertView.findViewById(R.id.txtOchuong);
        txtOchuong.setText(hm.getOchuongName());

        //Set arrow icon when header expanded or not
        ImageView img = (ImageView) convertView.findViewById(R.id.imgArrow);
        if(isExpanded) {
            img.setRotation(0);
        }
        else{
            img.setRotation(-90);
        }

        //Set icon male and female
        ImageView img2 = (ImageView) convertView.findViewById(R.id.imgSex);
        if (hm.getSex().equalsIgnoreCase("duc")){
            img2.setImageResource(R.drawable.icon_male);
        }
        else{
            img2.setImageResource(R.drawable.icon_female);
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
