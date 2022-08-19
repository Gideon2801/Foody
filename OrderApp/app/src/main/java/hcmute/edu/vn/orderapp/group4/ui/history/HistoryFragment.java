package hcmute.edu.vn.orderapp.group4.ui.history;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.adapters.CartAdapter;
import hcmute.edu.vn.orderapp.group4.adapters.HistoryAdapter;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.models.CartModel;
import hcmute.edu.vn.orderapp.group4.models.UserModel;

public class HistoryFragment extends Fragment {

    List<CartModel> list;
    HistoryAdapter historyAdapter;
    RecyclerView recyclerView;
    DBhelper DB;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        DB = new DBhelper(getActivity());

        recyclerView = root.findViewById(R.id.history_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        GetData();

        return root;
    }

    public void GetData(){
        list = new ArrayList<CartModel>();
        UserModel user = DB.getuser("1");
        Cursor cursor = DB.getItemHistory(user.getEmail());
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String food_name = cursor.getString(1);
            String store_name = cursor.getString(2);
            String rating = cursor.getString(3);
            String price = cursor.getString(4);
            String quantity = cursor.getString(5);

            int image=0;

            if (food_name != null && food_name.equalsIgnoreCase("Mì cay hải sản")){
                image = R.drawable.mi_cay_hai_san;
            }else if (food_name != null && food_name.equalsIgnoreCase("Mì cay bò")){
                image = R.drawable.mi_cay_bo;
            }else if (food_name != null && food_name.equalsIgnoreCase("Mì cay thập cẩm")){
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
            }

            list.add(new CartModel(image, food_name, store_name, rating, price, quantity));
        }

        historyAdapter = new HistoryAdapter(list, this);

        recyclerView.setAdapter(historyAdapter);
    }

    public void DialogXoaHistory(String email, String food, String store){
        AlertDialog.Builder dialogxoa = new AlertDialog.Builder(getContext());
        dialogxoa.setMessage("Bạn chắc chắn muốn xóa không?");
        dialogxoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DB.deleteItemHistory(email, food, store);
                Toast.makeText(getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                GetData();
            }
        });
        dialogxoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogxoa.show();
    }
}