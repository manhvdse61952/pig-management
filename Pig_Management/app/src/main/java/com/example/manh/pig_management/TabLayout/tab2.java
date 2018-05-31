package com.example.manh.pig_management.TabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import com.example.manh.pig_management.ExpendableList.ExpandableListAdapter;
import com.example.manh.pig_management.Model.HeoApiModel;
import com.example.manh.pig_management.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.R.attr.editable;
import static com.example.manh.pig_management.MainActivity.listDaychuong;
import static com.example.manh.pig_management.MainActivity.listGiongHeo;
import static com.example.manh.pig_management.MainActivity.listHeo;
import static com.example.manh.pig_management.MainActivity.listLoaiHeo;
import static com.example.manh.pig_management.MainActivity.listLoaichuong;
import static com.example.manh.pig_management.MainActivity.listOchuong;


/**
 * Created by Manh on 22/10/2017.
 */

public class tab2 extends Fragment{
    List<String> listLoai = new ArrayList<>();
    List<String> listGiong = new ArrayList<>();
    List<String> listLoaiChuongTemp = new ArrayList<>();
    List<String> listDaychuongTemp = new ArrayList<>();
    List<String> listOchuongTemp = new ArrayList<>();

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<HeoApiModel> listDataHeader;
    HashMap<HeoApiModel, HeoApiModel> listDataChild;
    EditText edtSearch;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //////// Search in edittext
        edtSearch = (EditText)view.findViewById(R.id.edtSearch);
        expListView = (ExpandableListView)view.findViewById(R.id.elView);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<HeoApiModel> listTemp = new ArrayList<HeoApiModel>();
                String value = edtSearch.getText().toString().toLowerCase();
                for(int j=0;j<listHeo.size();j++){
                    if (listHeo.get(j).getCode().toLowerCase().contains(value)){
                        listTemp.add(listHeo.get(j));
                    }
                }

                listDataHeader = new ArrayList<HeoApiModel>();
                listDataChild = new HashMap<HeoApiModel, HeoApiModel>();
                listDataHeader = listTemp;
                for (int k=0;k<listDataHeader.size();k++){
                    listDataChild.put(listDataHeader.get(k), listDataHeader.get(k));
                }

                listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);
                expListView.setAdapter(listAdapter);
                expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v,
                                                int groupPosition, long id) {
                        return false;
                    }
                });
                expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                    @Override
                    public void onGroupExpand(int groupPosition) {
                    }
                });
                expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
                    @Override
                    public void onGroupCollapse(int groupPosition) {
                    }
                });
                expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v,
                                                int groupPosition, int childPosition, long id) {
                        // TODO Auto-generated method stub
                        return false;
                    }
                });

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        ///////////////////////////// Import loai drop-down list ///////////////////////////////////
            listLoai.clear();
            listLoai.add("Tất cả");
            for (int i=0;i<listLoaiHeo.size();i++){
               listLoai.add(listLoaiHeo.get(i).getLoaiheoName());
            }

            final Spinner spn = (Spinner)view.findViewById(R.id.spnLoai);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, listLoai);
            spn.setAdapter(adapter);

        /////////////////////////////// Import giong drop-down list ////////////////////////////////
            listGiong.clear();
            listGiong.add("Tất cả");
            for (int i=0;i<listGiongHeo.size();i++){
                listGiong.add(listGiongHeo.get(i).getGiongheoName());
            }

            final Spinner spn2 = (Spinner)view.findViewById(R.id.spnGiong);
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, listGiong);
            spn2.setAdapter(adapter2);




        /////////////////////////////// Import ô chuồng ////////////////////////////////////////////
        final Spinner spn3 = (Spinner)view.findViewById(R.id.spnLoaichuong);
        final Spinner spn4 = (Spinner)view.findViewById(R.id.spnDaychuong);
        final Spinner spn5 = (Spinner)view.findViewById(R.id.spnOchuong);
        // Import loai chuong drop-down list
        listLoaiChuongTemp.clear();
        listLoaiChuongTemp.add("Tất cả");
        for (int i=0;i<listLoaichuong.size();i++){
            listLoaiChuongTemp.add(listLoaichuong.get(i).getLoaichuongName());
        }
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, listLoaiChuongTemp);
        spn3.setAdapter(adapter3);

        //...... Default dãy chuồng spinner
        listDaychuongTemp.clear();
        listDaychuongTemp.add("Tất cả");
        for (int k = 0; k < listDaychuong.size();k++) {
            if (listDaychuong.get(k).getLoaichuongName().equalsIgnoreCase(spn3.getSelectedItem().toString())){
                listDaychuongTemp.add(listDaychuong.get(k).getDaychuongName());
            }
        }




        //Import dãy chuồng dropdown list
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, listDaychuongTemp);
        spn4.setAdapter(adapter4);
        //....... Defaul ô chuồng spinner
        listOchuongTemp.clear();
        listOchuongTemp.add("Tất cả");
        for (int j = 0; j< listOchuong.size();j++){
            if (listOchuong.get(j).getLoaichuongName().equalsIgnoreCase(spn3.getSelectedItem().toString())&&listOchuong.get(j).getDaychuongName().equalsIgnoreCase(spn4.getSelectedItem().toString())){
                listOchuongTemp.add(listOchuong.get(j).getOchuongName());
            }
        }






        //Import o chuong dropdown list

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, listOchuongTemp);
        spn5.setAdapter(adapter5);


        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spn3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                listDaychuongTemp.clear();
                listDaychuongTemp.add("Tất cả");
                listOchuongTemp.clear();
                listOchuongTemp.add("Tất cả");
                for (int k = 0; k < listDaychuong.size();k++) {
                    if (listDaychuong.get(k).getLoaichuongName().equalsIgnoreCase(spn3.getSelectedItem().toString())){
                        listDaychuongTemp.add(listDaychuong.get(k).getDaychuongName());
                    }
                }
                spn4.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, listDaychuongTemp));

                for (int m = 0; m < listOchuong.size();m++){
                    if (listOchuong.get(m).getLoaichuongName().equalsIgnoreCase(spn3.getSelectedItem().toString())&&listOchuong.get(m).getDaychuongName().equalsIgnoreCase(spn3.getSelectedItem().toString())) {
                        listOchuongTemp.add(listOchuong.get(m).getOchuongName());
                    }
                }
                spn5.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, listOchuongTemp));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spn4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                listOchuongTemp.clear();
                listOchuongTemp.add("Tất cả");
                for (int m = 0; m < listOchuong.size();m++){
                    if (listOchuong.get(m).getLoaichuongName().equalsIgnoreCase(spn3.getSelectedItem().toString())&&listOchuong.get(m).getDaychuongName().equalsIgnoreCase(spn4.getSelectedItem().toString())) {
                        listOchuongTemp.add(listOchuong.get(m).getOchuongName());
                    }
                }
                spn5.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, listOchuongTemp));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        spn5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String textValue = spn5.getSelectedItem().toString();
                if (textValue.equalsIgnoreCase("Tất cả")){
                    ////////////////////////////// Set up expandable list view /////////////////////////////////

                    prepareListData();
                    listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);
                    expListView.setAdapter(listAdapter);
                    expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                        @Override
                        public boolean onGroupClick(ExpandableListView parent, View v,
                                                    int groupPosition, long id) {
                            return false;
                        }
                    });
                    expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                        @Override
                        public void onGroupExpand(int groupPosition) {
                        }
                    });
                    expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
                        @Override
                        public void onGroupCollapse(int groupPosition) {
                        }
                    });
                    expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                        @Override
                        public boolean onChildClick(ExpandableListView parent, View v,
                                                    int groupPosition, int childPosition, long id) {
                            // TODO Auto-generated method stub
                            return false;
                        }
                    });
                }
                else{
                    List<HeoApiModel> listTemp = new ArrayList<HeoApiModel>();
                    for(int j=0;j<listHeo.size();j++){
                        if (listHeo.get(j).getOchuongName().equalsIgnoreCase(textValue)){
                            listTemp.add(listHeo.get(j));
                        }
                    }

                    listDataHeader = new ArrayList<HeoApiModel>();
                    listDataChild = new HashMap<HeoApiModel, HeoApiModel>();
                    listDataHeader = listTemp;
                    for (int k=0;k<listDataHeader.size();k++){
                        listDataChild.put(listDataHeader.get(k), listDataHeader.get(k));
                    }

                    listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);
                    expListView.setAdapter(listAdapter);
                    expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                        @Override
                        public boolean onGroupClick(ExpandableListView parent, View v,
                                                    int groupPosition, long id) {
                            return false;
                        }
                    });
                    expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                        @Override
                        public void onGroupExpand(int groupPosition) {
                        }
                    });
                    expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
                        @Override
                        public void onGroupCollapse(int groupPosition) {
                        }
                    });
                    expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                        @Override
                        public boolean onChildClick(ExpandableListView parent, View v,
                                                    int groupPosition, int childPosition, long id) {
                            // TODO Auto-generated method stub
                            return false;
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////




    }

    private void prepareListData() {
        listDataHeader = new ArrayList<HeoApiModel>();
        listDataChild = new HashMap<HeoApiModel, HeoApiModel>();
        listDataHeader = listHeo;
        for (int i=0;i<listDataHeader.size();i++){
            listDataChild.put(listDataHeader.get(i), listDataHeader.get(i));
        }
    }
}
