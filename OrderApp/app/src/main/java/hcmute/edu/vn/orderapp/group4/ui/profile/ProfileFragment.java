package hcmute.edu.vn.orderapp.group4.ui.profile;

import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.CollationElementIterator;
import java.util.concurrent.TimeoutException;

import de.hdodenhof.circleimageview.CircleImageView;
import hcmute.edu.vn.orderapp.group4.MainActivity;
import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.activities.LoginActivity;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.models.UserModel;

public class ProfileFragment extends Fragment {

    DBhelper DB;
    TextView name;
    TextView email;
    TextView password;
    TextView phone;
    TextView address;
    ImageView edtName, edtPassword,edtPhone,edtAddress;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile,container,false);

        DB = new DBhelper(getActivity());

        name = root.findViewById(R.id.profile_name);
        email = root.findViewById(R.id.profile_email);
        password = root.findViewById(R.id.profile_password);
        phone = root.findViewById(R.id.profile_phone);
        address = root.findViewById(R.id.profile_address);

        edtName = root.findViewById(R.id.image_edit_name);
        edtPassword = root.findViewById(R.id.image_edit_passwrod);
        edtPhone = root.findViewById(R.id.image_edit_phone);
        edtAddress = root.findViewById(R.id.image_edit_address);

        showDataUser();

        edtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog("User Name", "name");
            }
        });

        edtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog("Password", "password");
            }
        });

        edtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog("Phone Number", "phonenumber");
            }
        });

        edtAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog("Address", "address");
            }
        });
        return root;
    }

    public void showDataUser()
    {
        UserModel userModel = DB.getuser("1");

        name.setText(userModel.getName());
        email.setText(userModel.getEmail());
        password.setText(userModel.getPasswrod());
        phone.setText(userModel.getPhone());
        address.setText(userModel.getAddress());
    }

    public void openDialog(String noidung, String change){
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog);

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

        EditText editText = dialog.findViewById(R.id.edt_Edit);
        Button btnXacNhan = dialog.findViewById(R.id.button_XacNhan);
        Button btnHuy = dialog.findViewById(R.id.button_Huy);
        TextView txtNoiDung = dialog.findViewById(R.id.textView_NoiDung);

        txtNoiDung.setText(noidung);

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (change == "name") {
                    DB.updateUserName(email.getText().toString().trim(), editText.getText().toString().trim());
                }else if (change == "password"){
                    DB.updatePassword(email.getText().toString().trim(), editText.getText().toString().trim());
                }else if (change == "phonenumber"){
                    DB.updatePhoneNumber(email.getText().toString().trim(), editText.getText().toString().trim());
                }else if (change == "address"){
                    DB.updateAddressUser(email.getText().toString().trim(), editText.getText().toString().trim());
                }
                Toast.makeText(getActivity(), "Đã cập nhât", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                showDataUser();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}