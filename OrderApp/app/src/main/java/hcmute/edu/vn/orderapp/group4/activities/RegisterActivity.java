package hcmute.edu.vn.orderapp.group4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hcmute.edu.vn.orderapp.group4.MainActivity;
import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;

public class RegisterActivity extends AppCompatActivity {

    EditText Email, Password, Username;
    Button Signup;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Email = (EditText) findViewById(R.id.edtEmail);
        Password = (EditText) findViewById(R.id.edtPassword);
        Username = (EditText) findViewById(R.id.edtFullName);
        Signup = (Button) findViewById(R.id.buttonRegister);
        DB = new DBhelper(this);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String pass = Password.getText().toString();
                String name = Username.getText().toString();

                if(email.equals("")||pass.equals("")||name.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                        Boolean checkuser = DB.checkusername(email);
                        if(checkuser==false){
                            Boolean insert = DB.insertDataUser(email, pass, name);
                            if(insert==true){
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        });
    }

    public void login(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }
}