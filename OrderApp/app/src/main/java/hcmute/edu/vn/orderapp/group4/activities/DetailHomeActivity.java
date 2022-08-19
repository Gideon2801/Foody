package hcmute.edu.vn.orderapp.group4.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.adapters.DetailHomeAdapter;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.models.DetailHomeModel;

public class DetailHomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailHomeModel> detailHomeModelList;
    DetailHomeAdapter detailHomeAdapter;
    ImageView imageView, imagefood;

    TextView foodname, rating, price, description;

    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);

        DB = new DBhelper(this);
        String type = getIntent().getStringExtra("name");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);
        imagefood = (ImageView) findViewById(R.id.detail_home_image);
        foodname = (TextView) findViewById(R.id.detail_home_name_product);
        rating = (TextView) findViewById(R.id.detail_home_rating);
        price = (TextView) findViewById(R.id.detail_home_price);
        description = (TextView) findViewById(R.id.detail_home_des);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailHomeModelList = new ArrayList<>();
        detailHomeAdapter = new DetailHomeAdapter(detailHomeModelList, getApplicationContext());
        recyclerView.setAdapter(detailHomeAdapter);

        if (type != null && type.equalsIgnoreCase("Koreno")) {
            imageView.setImageResource(R.drawable.koreno);
        }else if (type != null && type.equalsIgnoreCase("KOI")) {
            imageView.setImageResource(R.drawable.koi);
        }else if (type != null && type.equalsIgnoreCase("Ngô Quyền")) {
            imageView.setImageResource(R.drawable.ngoquyen);
        }else if (type != null && type.equalsIgnoreCase("KFC")) {
            imageView.setImageResource(R.drawable.kfc);
        }else if (type != null && type.equalsIgnoreCase("Pizza Hut")) {
            imageView.setImageResource(R.drawable.pizzahut);
        }else {
            imageView.setImageResource(R.drawable.tra_sua);
        }

        Cursor cursor = DB.getListfood(type);
        detailHomeModelList.clear();
        for(int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String food_name = cursor.getString(0);
            String store_name = cursor.getString(1);
            String descripton = cursor.getString(2);
            String rating = cursor.getString(3);
            String price = cursor.getString(4);

            int image = 0;

            if (food_name != null && food_name.equalsIgnoreCase("Mì cay hải sản")){
                image = R.drawable.mi_cay_hai_san;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Mì cay bò")){
                image = R.drawable.mi_cay_bo;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Mì cay thập cẩm")){
                image = R.drawable.mi_cay_thap_cam;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Tokbokki")){
                image = R.drawable.tokbokki;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Kimbap")){
                image = R.drawable.kimbap;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Trà đào")){
                image = R.drawable.tra_dao;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Trà sữa Matcha")){
                image = R.drawable.tra_sua_matcha;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Trà sữa truyền thống")){
                image = R.drawable.tra_sua_tryen_thong;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Cappuccino")){
                image = R.drawable.capuchino;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Sinh tố bơ")){
                image = R.drawable.sinh_to_bo;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Sinh tố dâu")){
                image = R.drawable.sinh_to_dau;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Cơm Bì Chả")){
                image = R.drawable.com_bi_cha;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Cơm Đậu Hủ Nhồi Thịt")){
                image = R.drawable.com_dau_hu_nhoi_thit;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Cơm Gà Chiên")){
                image = R.drawable.com_ga;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Cơm Gà Xối Mỡ")){
                image = R.drawable.com_ga_xoi_mo;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Cơm Thịt Heo Quay")){
                image = R.drawable.com_thit_heo_quay;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Cơm Thịt Kho Trứng")){
                image = R.drawable.com_thit_kho_trung;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Combo Đùi Gà")){
                image = R.drawable.dui_ga;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Combo Cánh Gà")){
                image = R.drawable.canh_ga;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Khoai Tây Chiên")){
                image = R.drawable.khoai_tay_chien;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Hamburger")){
                image = R.drawable.hamburger;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Coca Cola")){
                image = R.drawable.cocacola;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pepsi")){
                image = R.drawable.pepsi;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pizza Hải Sản")){
                image = R.drawable.pizza_hai_san;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pizza Phomai")){
                image = R.drawable.pizza_phomai;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pizza Rau Củ")){
                image = R.drawable.pizza_rau_cu;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pizza Thập Cẩm")){
                image = R.drawable.pizza_thap_cam;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pizza Xúc Xích")){
                image = R.drawable.pizza_xuc_xich;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Coca Cola")){
                image = R.drawable.cocacola;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pepsi")){
                image = R.drawable.pepsi;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Trà đào")){
                image = R.drawable.tra_dao;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Trà sữa Matcha")){
                image = R.drawable.tra_sua_matcha;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Trà sữa truyền thống")){
                image = R.drawable.tra_sua_tryen_thong;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Cappuccino")){
                image = R.drawable.capuchino;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Sinh tố bơ")){
                image = R.drawable.sinh_to_bo;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Sinh tố dâu")){
                image = R.drawable.sinh_to_dau;
            }else {
                image = R.drawable.pepsi;
            }
            detailHomeModelList.add(new DetailHomeModel(image,food_name,store_name,descripton,rating,price));

        }

        detailHomeAdapter.notifyDataSetChanged();
    }
}