package hcmute.edu.vn.orderapp.group4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.models.FoodModel;
import hcmute.edu.vn.orderapp.group4.models.StoreModel;
import hcmute.edu.vn.orderapp.group4.models.UserModel;

public class DetailProductActivity extends AppCompatActivity {

    ImageView image_food, plus, minus;
    TextView store_name, food_name, address, timing, description, rating, price;
    Button AddtoCart;
    EditText quantity;

    DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        DB = new DBhelper(this);
        String foodname = getIntent().getStringExtra("food_name");
        String storename= getIntent().getStringExtra("store_name");

        image_food = (ImageView) findViewById(R.id.img_food);
        plus = (ImageView) findViewById(R.id.image_plus_food);
        minus = (ImageView) findViewById(R.id.image_minus_food);

        store_name = (TextView) findViewById(R.id.detail_nameStore);
        food_name = (TextView) findViewById(R.id.foodname);
        address = (TextView) findViewById(R.id.addressStore);
        timing = (TextView) findViewById(R.id.detail_timeOpen);
        description = (TextView) findViewById(R.id.description);
        rating = (TextView) findViewById(R.id.foodrating);
        price = (TextView) findViewById(R.id.price);
        quantity = (EditText) findViewById(R.id.textView_quantity_food);

        AddtoCart = (Button) findViewById(R.id.btnAddCart_food);

        FoodModel food = DB.getfood(foodname, storename);
        StoreModel store = DB.getstore(food.getStore_name());

        store_name.setText(food.getStore_name());
        food_name.setText(food.getFood_name());
        address.setText(store.getAddress());
        timing.setText(store.getTiming());
        description.setText(food.getDescription());
        rating.setText(food.getRating());
        price.setText(food.getPrice());

        if (foodname != null && foodname.equalsIgnoreCase("M?? cay h???i s???n")){
            image_food.setImageResource(R.drawable.mi_cay_hai_san);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("M?? cay b??")){
            image_food.setImageResource(R.drawable.mi_cay_bo);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("M?? cay th???p c???m")){
            image_food.setImageResource(R.drawable.mi_cay_thap_cam);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Tokbokki")){
            image_food.setImageResource(R.drawable.tokbokki);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Kimbap")){
            image_food.setImageResource(R.drawable.kimbap);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Tr?? ????o")){
            image_food.setImageResource(R.drawable.tra_dao);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Tr?? s???a Matcha")){
            image_food.setImageResource(R.drawable.tra_sua_matcha);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Tr?? s???a truy???n th???ng")){
            image_food.setImageResource(R.drawable.tra_sua_tryen_thong);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Cappuccino")){
            image_food.setImageResource(R.drawable.capuchino);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Sinh t??? b??")){
            image_food.setImageResource(R.drawable.sinh_to_bo);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Sinh t??? d??u")){
            image_food.setImageResource(R.drawable.sinh_to_dau);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("C??m B?? Ch???")){
            image_food.setImageResource(R.drawable.com_bi_cha);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("C??m ?????u H??? Nh???i Th???t")){
            image_food.setImageResource(R.drawable.com_dau_hu_nhoi_thit);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("C??m G?? Chi??n")){
            image_food.setImageResource(R.drawable.com_ga);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("C??m G?? X???i M???")){
            image_food.setImageResource(R.drawable.com_ga_xoi_mo);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("C??m Th???t Heo Quay")){
            image_food.setImageResource(R.drawable.com_thit_heo_quay);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("C??m Th???t Kho Tr???ng")){
            image_food.setImageResource(R.drawable.com_thit_kho_trung);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Combo ????i G??")){
            image_food.setImageResource(R.drawable.dui_ga);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Combo C??nh G??")){
            image_food.setImageResource(R.drawable.canh_ga);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Khoai T??y Chi??n")){
            image_food.setImageResource(R.drawable.khoai_tay_chien);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Hamburger")){
            image_food.setImageResource(R.drawable.hamburger);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Coca Cola")){
            image_food.setImageResource(R.drawable.cocacola);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Pepsi")){
            image_food.setImageResource(R.drawable.pepsi);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Pizza H???i S???n")){
            image_food.setImageResource(R.drawable.pizza_hai_san);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Pizza Phomai")){
            image_food.setImageResource(R.drawable.pizza_phomai);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Pizza Rau C???")){
            image_food.setImageResource(R.drawable.pizza_rau_cu);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Pizza Th???p C???m")){
            image_food.setImageResource(R.drawable.pizza_thap_cam);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Pizza X??c X??ch")){
            image_food.setImageResource(R.drawable.pizza_xuc_xich);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Coca Cola")){
            image_food.setImageResource(R.drawable.cocacola);
        }else
        if (foodname != null && foodname.equalsIgnoreCase("Pepsi")){
            image_food.setImageResource(R.drawable.pepsi);
        }

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soluong = Integer.parseInt(quantity.getText().toString().trim());
                int gia = Integer.parseInt(food.getPrice());
                soluong++;
                int total = gia * soluong;
                quantity.setText(soluong+"");
                price.setText(total+"");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soluong = Integer.parseInt(quantity.getText().toString().trim());
                int gia = Integer.parseInt(food.getPrice());
                if (soluong > 1){
                    soluong--;
                    quantity.setText(soluong+"");
                    int total = gia * soluong;
                    price.setText(total+"");
                }
            }
        });

        AddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soluong = Integer.parseInt(quantity.getText().toString().trim());
                if (soluong < 1) {
                    Toast.makeText(DetailProductActivity.this, "S??? l?????ng kh??ng h???p l???", Toast.LENGTH_SHORT).show();
                return;
                }else {
                    UserModel user = DB.getuser("1");
                    String email = user.getEmail();
                    DB.insertDataCart(email, food_name.getText().toString().trim(), store_name.getText().toString().trim(), rating.getText().toString().trim(),price.getText().toString().trim(),quantity.getText().toString().trim());
                    Toast.makeText(DetailProductActivity.this, "???? th??m v??o gi??? h??ng th??nh c??ng", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}