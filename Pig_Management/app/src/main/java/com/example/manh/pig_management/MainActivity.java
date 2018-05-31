package com.example.manh.pig_management;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.widget.TextView;

import com.example.manh.pig_management.Interface.ChitietLichtiemphongAPI;
import com.example.manh.pig_management.Interface.ChoAnAPI;
import com.example.manh.pig_management.Interface.DayChuongAPI;
import com.example.manh.pig_management.Interface.GiongHeoAPI;
import com.example.manh.pig_management.Interface.HeoAPI;
import com.example.manh.pig_management.Interface.LoaiChuongAPI;
import com.example.manh.pig_management.Interface.LoaiHeoAPI;
import com.example.manh.pig_management.Interface.LoaiThucAnAPI;
import com.example.manh.pig_management.Interface.LoaiThuocAPI;
import com.example.manh.pig_management.Interface.OchuongAPI;
import com.example.manh.pig_management.Interface.ThucAnAPI;
import com.example.manh.pig_management.Interface.ThuocAPI;
import com.example.manh.pig_management.Model.AdapterModel;
import com.example.manh.pig_management.Model.ChitietLichtiemphongApiModel;
import com.example.manh.pig_management.Model.ChoAnApiModel;
import com.example.manh.pig_management.Model.DayChuongApiModel;
import com.example.manh.pig_management.Model.GiongHeoApiModel;
import com.example.manh.pig_management.Model.HeoApiModel;
import com.example.manh.pig_management.Model.LoaiChuongApiModel;
import com.example.manh.pig_management.Model.LoaiHeoApiModel;
import com.example.manh.pig_management.Model.LoaiThucAnApiModel;
import com.example.manh.pig_management.Model.LoaiThuocApiModel;
import com.example.manh.pig_management.Model.OchuongApiModel;
import com.example.manh.pig_management.Model.Tab1AdapterModel;
import com.example.manh.pig_management.Model.ThucAnApiModel;
import com.example.manh.pig_management.Model.ThuocApiModel;
import com.example.manh.pig_management.Remote.RetrofitAdapter;
import com.example.manh.pig_management.TabLayout.sectionPageAdapter;
import com.example.manh.pig_management.TabLayout.tab1;
import com.example.manh.pig_management.TabLayout.tab2;
import com.example.manh.pig_management.TabLayout.tab3;
import com.example.manh.pig_management.TabLayout.tab4;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.media.CamcorderProfile.get;
import static com.example.manh.pig_management.Model.MyProgressBar.dismiss;
import static com.example.manh.pig_management.Model.MyProgressBar.show;

public class MainActivity extends AppCompatActivity {
    //Use for tab1
    public static List<Tab1AdapterModel> listSodoHeo;

    //Use for tab2
    public static List<HeoApiModel> listHeo;
    public static List<GiongHeoApiModel> listGiongHeo;
    public static List<LoaiHeoApiModel> listLoaiHeo;

    public static List<OchuongApiModel> listOchuong;
    public static List<DayChuongApiModel> listDaychuong;
    public static List<LoaiChuongApiModel> listLoaichuong;

    //Use for tab3
    public static List<ChitietLichtiemphongApiModel> listChitietLichtiemphong;
    //public static List<Chitiet_LichtiemphongModel> listChitietTheoOchuong;
    public static List<LoaiThuocApiModel> listLoaithuoc;
    public static List<ThuocApiModel> listThuoc;

    //Use for tab4
    public static List<ChoAnApiModel> listChoAn;
    //public static List<ChoAnModel> listChoAnTheoOchuong;
    public static List<LoaiThucAnApiModel> listLoaithucan;
    public static List<ThucAnApiModel> listThucan;

    //Use for tab3_4_total
    //public static List<Chitiet_LichtiemphongModel> listChitietLichtiemphong2;
    public static List<AdapterModel> listTongthuoc;

    //public static List<ChoAnModel> listChoAn2;
    public static List<AdapterModel> listTongThucAn;

    //Use for TAB LAYOUT
    public static ViewPager mViewPager;
    private TabLayout tabLayout;
    public static sectionPageAdapter secAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoaiChuongAPI();
        show(MainActivity.this);


        //Set up the viewPager with the section adapter - TAB LAYOUT
        //mSectionPageAdapter = new sectionPageAdapter(getSupportFragmentManager());


    }

    /////////////////////////////////////// TAB LAYOUT /////////////////////////////////////////////
    private void createTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Trang chủ");
        tabOne.setTextSize(14);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dashboard, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Heo");
        tabTwo.setTextSize(14);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.heo2, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Lịch tiêm");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.lichtiem, 0, 0);
        tabThree.setTextSize(14);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText("Lịch ăn");
        tabFour.setTextSize(14);
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.lichan, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);
    }

    private void setupViewPager(ViewPager viewPager){
        secAdapter = new sectionPageAdapter(getSupportFragmentManager());
        secAdapter.addFragment(new tab1(), "Trang chủ");
        secAdapter.addFragment(new tab2(), "Heo");
        secAdapter.addFragment(new tab3(), "Lịch tiêm");
        secAdapter.addFragment(new tab4(), "Lịch ăn");
        viewPager.setAdapter(secAdapter);
    }

    public void ReadSodoHeo() {
        InputStream inputStream = getResources().openRawResource(R.raw.data);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        listSodoHeo = new ArrayList<Tab1AdapterModel>();
        List<Tab1AdapterModel> listTemp = new ArrayList<>();

        //Xử lý thêm loại heo và số lượng vào list
        for (int i=0;i<listLoaiHeo.size();i++){
            int soluong = 0;
            for (int j=0;j<listHeo.size();j++){
                if (listHeo.get(j).getLoaiheoName().equalsIgnoreCase(listLoaiHeo.get(i).getLoaiheoName())){
                    soluong++;
                }
            }
            listTemp.add(new Tab1AdapterModel(listLoaiHeo.get(i).getLoaiheoName(), "0", soluong + ""));
        }

        //Xử lý sơ đồ
        for (int k = 0; k < listTemp.size();k++){
            int soluongTemp = Integer.parseInt(listTemp.get(k).getTxtSoluong());
            int total = listHeo.size();
            double percent = (soluongTemp/(double)total)*700;
            int finalValue = (int)Math.round(percent);
            listSodoHeo.add(new Tab1AdapterModel(listTemp.get(k).getTxtLoaiHeoName(), String.valueOf(finalValue), listTemp.get(k).getTxtSoluong()));
        }
    }

    ////////////////////////////// GET API /////////////////////////////////////////////////////////
    public void getHeoAPI(){
        Retrofit test = RetrofitAdapter.getClient();
        final HeoAPI testAPI = test.create(HeoAPI.class);
        Call<List<HeoApiModel>> mapCall = testAPI.getHeo();
        mapCall.enqueue(new Callback<List<HeoApiModel>>() {
            @Override
            public void onResponse(Call<List<HeoApiModel>> call, Response<List<HeoApiModel>> response) {
                listHeo = new ArrayList<HeoApiModel>();
                listHeo = response.body();
                ReadSodoHeo();
                getChitietLichtiemphongAPI();
            }

            @Override
            public void onFailure(Call<List<HeoApiModel>> call, Throwable t) {

            }
        });
    }

   public void getLoaiHeoAPI(){
        Retrofit test = RetrofitAdapter.getClient();
        final LoaiHeoAPI testAPI = test.create(LoaiHeoAPI.class);
        Call<List<LoaiHeoApiModel>> mapCall = testAPI.getLoaiHeo();
        mapCall.enqueue(new Callback<List<LoaiHeoApiModel>>() {
            @Override
            public void onResponse(Call<List<LoaiHeoApiModel>> call, Response<List<LoaiHeoApiModel>> response) {
                listLoaiHeo = new ArrayList<LoaiHeoApiModel>();
                listLoaiHeo = response.body();
                getGiongHeoAPI();

            }

            @Override
            public void onFailure(Call<List<LoaiHeoApiModel>> call, Throwable t) {

            }
        });
    }

    public void getGiongHeoAPI() {
        Retrofit test = RetrofitAdapter.getClient();
        final GiongHeoAPI testAPI = test.create(GiongHeoAPI.class);
        Call<List<GiongHeoApiModel>> mapCall = testAPI.getGiongHeo();
        mapCall.enqueue(new Callback<List<GiongHeoApiModel>>() {
            @Override
            public void onResponse(Call<List<GiongHeoApiModel>> call, Response<List<GiongHeoApiModel>> response) {
                listGiongHeo = new ArrayList<GiongHeoApiModel>();
                listGiongHeo = response.body();
                getHeoAPI();
            }

            @Override
            public void onFailure(Call<List<GiongHeoApiModel>> call, Throwable t) {

            }
        });
    }

    public void getChitietLichtiemphongAPI(){
        Retrofit test = RetrofitAdapter.getClient();
        final ChitietLichtiemphongAPI testAPI = test.create(ChitietLichtiemphongAPI.class);
        Call<List<ChitietLichtiemphongApiModel>> mapCall = testAPI.getChitietLichtiemphong();
        mapCall.enqueue(new Callback<List<ChitietLichtiemphongApiModel>>() {
            @Override
            public void onResponse(Call<List<ChitietLichtiemphongApiModel>> call, Response<List<ChitietLichtiemphongApiModel>> response) {
                listChitietLichtiemphong = new ArrayList<ChitietLichtiemphongApiModel>();
                listChitietLichtiemphong = response.body();
                getChoAnAPI();
            }

            @Override
            public void onFailure(Call<List<ChitietLichtiemphongApiModel>> call, Throwable t) {

            }
        });
    }

    public void getChoAnAPI() {
        Retrofit test = RetrofitAdapter.getClient();
        final ChoAnAPI testAPI = test.create(ChoAnAPI.class);
        Call<List<ChoAnApiModel>> mapCall = testAPI.getChoAn();
        mapCall.enqueue(new Callback<List<ChoAnApiModel>>() {
            @Override
            public void onResponse(Call<List<ChoAnApiModel>> call, Response<List<ChoAnApiModel>> response) {
                listChoAn = new ArrayList<ChoAnApiModel>();
                listChoAn = response.body();
                dismiss();
                mViewPager = (ViewPager) findViewById(R.id.container);
                setupViewPager(mViewPager);
                tabLayout = (TabLayout) findViewById(R.id.tabs);
                tabLayout.setupWithViewPager(mViewPager);
                createTabIcons();

            }

            @Override
            public void onFailure(Call<List<ChoAnApiModel>> call, Throwable t) {

            }
        });
    }

    public void getLoaiChuongAPI(){
        Retrofit test = RetrofitAdapter.getClient();
        final LoaiChuongAPI testAPI = test.create(LoaiChuongAPI.class);
        Call<List<LoaiChuongApiModel>> mapCall = testAPI.getLoaiChuong();
        mapCall.enqueue(new Callback<List<LoaiChuongApiModel>>() {
            @Override
            public void onResponse(Call<List<LoaiChuongApiModel>> call, Response<List<LoaiChuongApiModel>> response) {
                listLoaichuong = new ArrayList<LoaiChuongApiModel>();
                listLoaichuong = response.body();
                getDayChuongAPI();
            }

            @Override
            public void onFailure(Call<List<LoaiChuongApiModel>> call, Throwable t) {

            }
        });
    }

    public void getDayChuongAPI() {
        Retrofit test = RetrofitAdapter.getClient();
        final DayChuongAPI testAPI = test.create(DayChuongAPI.class);
        Call<List<DayChuongApiModel>> mapCall = testAPI.getDayChuong();
        mapCall.enqueue(new Callback<List<DayChuongApiModel>>() {
            @Override
            public void onResponse(Call<List<DayChuongApiModel>> call, Response<List<DayChuongApiModel>> response) {
                listDaychuong = new ArrayList<DayChuongApiModel>();
                listDaychuong = response.body();
                getOchuongAPI();
            }

            @Override
            public void onFailure(Call<List<DayChuongApiModel>> call, Throwable t) {

            }
        });
    }

    public void getOchuongAPI() {
        Retrofit test = RetrofitAdapter.getClient();
        final OchuongAPI testAPI = test.create(OchuongAPI.class);
        Call<List<OchuongApiModel>> mapCall = testAPI.getOchuong();
        mapCall.enqueue(new Callback<List<OchuongApiModel>>() {
            @Override
            public void onResponse(Call<List<OchuongApiModel>> call, Response<List<OchuongApiModel>> response) {
                listOchuong = new ArrayList<OchuongApiModel>();
                listOchuong = response.body();
                getLoaiThuocAPI();
            }

            @Override
            public void onFailure(Call<List<OchuongApiModel>> call, Throwable t) {

            }
        });
    }

    public void getThuocAPI() {
        Retrofit test = RetrofitAdapter.getClient();
        final ThuocAPI testAPI = test.create(ThuocAPI.class);
        Call<List<ThuocApiModel>> mapCall = testAPI.getThuoc();
        mapCall.enqueue(new Callback<List<ThuocApiModel>>() {
            @Override
            public void onResponse(Call<List<ThuocApiModel>> call, Response<List<ThuocApiModel>> response) {
                listThuoc = new ArrayList<ThuocApiModel>();
                listThuoc = response.body();
                getLoaiThucAnAPI();
            }

            @Override
            public void onFailure(Call<List<ThuocApiModel>> call, Throwable t) {

            }
        });
    }

    public void getLoaiThuocAPI() {
        Retrofit test = RetrofitAdapter.getClient();
        final LoaiThuocAPI testAPI = test.create(LoaiThuocAPI.class);
        Call<List<LoaiThuocApiModel>> mapCall = testAPI.getLoaiThuoc();
        mapCall.enqueue(new Callback<List<LoaiThuocApiModel>>() {
            @Override
            public void onResponse(Call<List<LoaiThuocApiModel>> call, Response<List<LoaiThuocApiModel>> response) {
                listLoaithuoc = new ArrayList<LoaiThuocApiModel>();
                listLoaithuoc = response.body();
                getThuocAPI();
            }

            @Override
            public void onFailure(Call<List<LoaiThuocApiModel>> call, Throwable t) {

            }
        });
    }

    public void getThucAnAPI() {
        Retrofit test = RetrofitAdapter.getClient();
        final ThucAnAPI testAPI = test.create(ThucAnAPI.class);
        Call<List<ThucAnApiModel>> mapCall = testAPI.getThucAn();
        mapCall.enqueue(new Callback<List<ThucAnApiModel>>() {
            @Override
            public void onResponse(Call<List<ThucAnApiModel>> call, Response<List<ThucAnApiModel>> response) {
                listThucan = new ArrayList<ThucAnApiModel>();
                listThucan = response.body();
                getLoaiHeoAPI();
            }

            @Override
            public void onFailure(Call<List<ThucAnApiModel>> call, Throwable t) {

            }
        });
    }

    public void getLoaiThucAnAPI() {
        Retrofit test = RetrofitAdapter.getClient();
        final LoaiThucAnAPI testAPI = test.create(LoaiThucAnAPI.class);
        Call<List<LoaiThucAnApiModel>> mapCall = testAPI.getLoaiThucAn();
        mapCall.enqueue(new Callback<List<LoaiThucAnApiModel>>() {
            @Override
            public void onResponse(Call<List<LoaiThucAnApiModel>> call, Response<List<LoaiThucAnApiModel>> response) {
                listLoaithucan = new ArrayList<LoaiThucAnApiModel>();
                listLoaithucan = response.body();
                getThucAnAPI();
            }

            @Override
            public void onFailure(Call<List<LoaiThucAnApiModel>> call, Throwable t) {

            }
        });
    }


}
