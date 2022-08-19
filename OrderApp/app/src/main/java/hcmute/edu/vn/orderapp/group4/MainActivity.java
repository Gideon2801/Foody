package hcmute.edu.vn.orderapp.group4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

import hcmute.edu.vn.orderapp.group4.activities.LoginActivity;
import hcmute.edu.vn.orderapp.group4.activities.RegisterActivity;
import hcmute.edu.vn.orderapp.group4.activities.WelcomeActivity;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.databinding.ActivityMainBinding;
import hcmute.edu.vn.orderapp.group4.models.UserModel;
import hcmute.edu.vn.orderapp.group4.ui.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    TextView headeremail, headername;
    public static DBhelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DB = new DBhelper(this);

        //Thêm dữ liệu vào tb_store
        DB.insertDataStore("Pizza Hut","7:00 - 23:00","24 Đ. Võ Văn Ngân, Trường Thọ, Thủ Đức, TP.HCM");
        DB.insertDataStore("KFC","24/24","251 Đ. Võ Văn Ngân, Linh Chiểu, Thủ Đức, TP.HCM");
        DB.insertDataStore("Ngô Quyền","5:00 - 22:00","523 Đ. Lương Định Của, Đông Hoà, Dĩ An, Bình Dương");
        DB.insertDataStore("KOI","6:00 - 23:00","88 Song Hành, XL Hà Nội, An Phú, Quận 2, TP.HCM");
        DB.insertDataStore("Koreno","10:00 - 23:00","105 Đ. Hoàng Diệu 2, Phường Linh Trung, Thủ Đức, TP.HCM");

        //Thêm thử cửa hàng Phúc Long
//      DB.insertDataStore("Phúc Long","24h","105 Đ. Hoàng Diệu 2, Phường Linh Trung, Thủ Đức, TP.HCM");


        //Thêm dữ liệu vào tb_food
        DB.insertDataFood("Mì cay hải sản","Koreno","Có đủ cấp độ từ 0 - 7","4.7","3");
        DB.insertDataFood("Mì cay bò","Koreno","Có đủ cấp độ từ 0 - 7","4.6","3");
        DB.insertDataFood("Mì cay thập cẩm","Koreno","Có đủ cấp độ từ 0 - 7","4.8","4");
        DB.insertDataFood("Tokbokki","Koreno","Nước sốt thơm ngon, ăn là mê","5.0","3");
        DB.insertDataFood("Kimbap","Koreno","Được làm từ những nguyên liệu tốt nhất","4.9","3");

        DB.insertDataFood("Trà đào","KOI","Được làm từ những miếng đào thơm ngon nhất","4.4","4");
        DB.insertDataFood("Trà sữa Matcha","KOI","Được làm từ bột trà xanh nguyên chất","4.5","4");
        DB.insertDataFood("Trà sữa truyền thống","KOI","Mang hương vị truyền thống","4.7","4");
        DB.insertDataFood("Cappuccino","KOI","Được làm chủ yếu từ coffee và sữa","4.9","4");
        DB.insertDataFood("Sinh tố bơ","KOI","Được làm từ những trái bơ thơm ngon nhất","4.6","4");
        DB.insertDataFood("Sinh tố dâu","KOI","Có nguồn gốc từ dâu Đà Lạt","4.8","4");

        DB.insertDataFood("Cơm Bì Chả","Ngô Quyền","Ngon mely","4.3","2");
        DB.insertDataFood("Cơm Đậu Hủ Nhồi Thịt","Ngô Quyền","Ngon mely","4.0","2");
        DB.insertDataFood("Cơm Gà Chiên","Ngô Quyền","Ngon mely","4.4","2");
        DB.insertDataFood("Cơm Gà Xối Mỡ","Ngô Quyền","Ngon mely","4.7","2");
        DB.insertDataFood("Cơm Thịt Heo Quay","Ngô Quyền","Ngon mely","4.5","2");
        DB.insertDataFood("Cơm Thịt Kho Trứng","Ngô Quyền","Ngon mely","4.6","2");

        DB.insertDataFood("Combo Đùi Gà","KFC","Ngon mely","4.8","5");
        DB.insertDataFood("Combo Cánh Gà","KFC","Ngon mely","4.8","5");
        DB.insertDataFood("Khoai Tây Chiên","KFC","Ngon mely","4.7","5");
        DB.insertDataFood("Hamburger","KFC","Ngon mely","4.9","5");
        DB.insertDataFood("Coca Cola","KFC","Chính Hãng","4.9","1");
        DB.insertDataFood("Pepsi","KFC","Chính Hãng","4.9","1");

        DB.insertDataFood("Pizza Hải Sản","Pizza Hut","Ngon mely","4.6","20");
        DB.insertDataFood("Pizza Phomai","Pizza Hut","Ngon mely","4.8","20");
        DB.insertDataFood("Pizza Rau Củ","Pizza Hut","Ngon mely","4.7","20");
        DB.insertDataFood("Pizza Thập Cẩm","Pizza Hut","Ngon mely","4.9","20");
        DB.insertDataFood("Pizza Xúc Xích","Pizza Hut","Ngon mely","4.7","20");
        DB.insertDataFood("Coca Cola","Pizza Hut","Chính Hãng","4.9","1");
        DB.insertDataFood("Pepsi","Pizza Hut","Chính Hãng","4.9","1");

        //Thêm thử menu cho Phúc Long
//        DB.insertDataFood("Trà đào","Phúc Long","Được làm từ những miếng đào thơm ngon nhất","4.4","4");
//        DB.insertDataFood("Trà sữa Matcha","Phúc Long","Được làm từ bột trà xanh nguyên chất","4.5","4");
//        DB.insertDataFood("Trà sữa truyền thống","Phúc Long","Mang hương vị truyền thống","4.7","4");
//        DB.insertDataFood("Cappuccino","Phúc Long","Được làm chủ yếu từ coffee và sữa","4.9","4");
//        DB.insertDataFood("Sinh tố bơ","Phúc Long","Được làm từ những trái bơ thơm ngon nhất","4.6","4");
//        DB.insertDataFood("Sinh tố dâu","Phúc Long","Có nguồn gốc từ dâu Đà Lạt","4.8","4");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_profile, R.id.nav_mycart, R.id.nav_history)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        View headerView = navigationView.getHeaderView(0);
        headername = headerView.findViewById(R.id.textView_name);
        headeremail = headerView.findViewById(R.id.textView_email);

        UserModel user = DB.getuser("1");

        headeremail.setText(user.getEmail());
        headername.setText(user.getName());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void LogOut(View view) {

        DB.updateStatus(headeremail.getText().toString().trim(), "0");
        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }
}