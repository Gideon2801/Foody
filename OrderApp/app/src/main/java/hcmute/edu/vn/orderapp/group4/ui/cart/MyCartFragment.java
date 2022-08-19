package hcmute.edu.vn.orderapp.group4.ui.cart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.adapters.CartAdapter;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.models.CartModel;
import hcmute.edu.vn.orderapp.group4.models.UserModel;

public class MyCartFragment extends Fragment {

    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    Button order;
    DBhelper DB;
    TextView total;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mycart,container,false);

        DB = new DBhelper(getActivity());

        recyclerView = root.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        total = root.findViewById(R.id.totalprice);
        order = root.findViewById(R.id.buttonOrder);

        GetData();
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel user = DB.getuser("1");
                DialogThongTin(user.getName(), user.getPhone(), user.getAddress());
            }
        });
        return root;
    }

    public void DialogXoaCart(String email, String food, String store){
            AlertDialog.Builder dialogxoa = new AlertDialog.Builder(getContext());
            dialogxoa.setMessage("Bạn có muốn xóa món ăn này không?");
            dialogxoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    DB.deleteItemCart(email, food, store);
                    Toast.makeText(getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                GetData();
            }
        });
        dialogxoa.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogxoa.show();
    }

    public void GetData(){
        list = new ArrayList<CartModel>();
        UserModel user = DB.getuser("1");
        int totalprice = 0;
        Cursor cursor = DB.getItemCart(user.getEmail());
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String food_name = cursor.getString(1);
            String store_name = cursor.getString(2);
            String rating = cursor.getString(3);
            String price = cursor.getString(4);
            String quantity = cursor.getString(5);

            totalprice += Integer.parseInt(price);
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

        cartAdapter = new CartAdapter(list, this);
        total.setText("$"+totalprice);

        recyclerView.setAdapter(cartAdapter);
    }

    public void DialogThongTin(String ten, String SDT, String address){
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_thongtin);

        Window window =dialog.getWindow();

        if (window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtributes = window.getAttributes();
        windowAtributes.gravity = Gravity.CENTER;
        window.setAttributes(windowAtributes);

        dialog.setCancelable(true);

        EditText name = (EditText) dialog.findViewById(R.id.edt_ten);
        EditText phone = (EditText) dialog.findViewById(R.id.edt_phone);
        EditText diachi = (EditText) dialog.findViewById(R.id.edt_diachi);
        Button btnXacNhan = (Button) dialog.findViewById(R.id.btn_XacNhan);
        Button btnHuy = (Button) dialog.findViewById(R.id.btn_Huy);

        name.setText(ten);
        phone.setText(SDT);
        diachi.setText(address);

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenn = name.getText().toString().trim();
                String dienthoai = phone.getText().toString().trim();
                String diachii = diachi.getText().toString().trim();
                if (tenn.length()>0 && dienthoai.length()>0 && diachii.length()>0){
                    UserModel user = DB.getuser("1");
                    DB.updateStatusCart(user.getEmail());
                    GetData();
                    Toast.makeText(getContext(),"Order thành công",Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }else {
                    Toast.makeText(getContext(),"Bạn chưa nhập đủ thông tin",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}