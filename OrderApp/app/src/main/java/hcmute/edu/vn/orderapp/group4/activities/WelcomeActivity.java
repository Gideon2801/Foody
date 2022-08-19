package hcmute.edu.vn.orderapp.group4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import hcmute.edu.vn.orderapp.group4.MainActivity;
import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.models.UserModel;

public class WelcomeActivity extends AppCompatActivity {

    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        DB = new DBhelper(this);
        if (DB.checkStatus()){
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        }
    }

    public void register(View view) {
        startActivity(new Intent(WelcomeActivity.this, RegisterActivity.class));
    }

    public void login(View view) {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }
}