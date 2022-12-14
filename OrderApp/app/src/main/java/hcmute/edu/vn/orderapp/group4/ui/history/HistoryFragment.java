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

            if (food_name != null && food_name.equalsIgnoreCase("M?? cay h???i s???n")){
                image = R.drawable.mi_cay_hai_san;
            }else if (food_name != null && food_name.equalsIgnoreCase("M?? cay b??")){
                image = R.drawable.mi_cay_bo;
            }else if (food_name != null && food_name.equalsIgnoreCase("M?? cay th???p c???m")){
                image = R.drawable.mi_cay_thap_cam;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Tokbokki")){
                image = R.drawable.tokbokki;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Kimbap")){
                image = R.drawable.kimbap;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Tr?? ????o")){
                image = R.drawable.tra_dao;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Tr?? s???a Matcha")){
                image = R.drawable.tra_sua_matcha;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Tr?? s???a truy???n th???ng")){
                image = R.drawable.tra_sua_tryen_thong;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Cappuccino")){
                image = R.drawable.capuchino;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Sinh t??? b??")){
                image = R.drawable.sinh_to_bo;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Sinh t??? d??u")){
                image = R.drawable.sinh_to_dau;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("C??m B?? Ch???")){
                image = R.drawable.com_bi_cha;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("C??m ?????u H??? Nh???i Th???t")){
                image = R.drawable.com_dau_hu_nhoi_thit;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("C??m G?? Chi??n")){
                image = R.drawable.com_ga;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("C??m G?? X???i M???")){
                image = R.drawable.com_ga_xoi_mo;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("C??m Th???t Heo Quay")){
                image = R.drawable.com_thit_heo_quay;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("C??m Th???t Kho Tr???ng")){
                image = R.drawable.com_thit_kho_trung;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Combo ????i G??")){
                image = R.drawable.dui_ga;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Combo C??nh G??")){
                image = R.drawable.canh_ga;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Khoai T??y Chi??n")){
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
            if (food_name != null && food_name.equalsIgnoreCase("Pizza H???i S???n")){
                image = R.drawable.pizza_hai_san;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pizza Phomai")){
                image = R.drawable.pizza_phomai;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pizza Rau C???")){
                image = R.drawable.pizza_rau_cu;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pizza Th???p C???m")){
                image = R.drawable.pizza_thap_cam;
            }else
            if (food_name != null && food_name.equalsIgnoreCase("Pizza X??c X??ch")){
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
        dialogxoa.setMessage("B???n ch???c ch???n mu???n x??a kh??ng?");
        dialogxoa.setPositiveButton("C??", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DB.deleteItemHistory(email, food, store);
                Toast.makeText(getContext(), "???? x??a", Toast.LENGTH_SHORT).show();
                GetData();
            }
        });
        dialogxoa.setNegativeButton("Kh??ng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogxoa.show();
    }
}