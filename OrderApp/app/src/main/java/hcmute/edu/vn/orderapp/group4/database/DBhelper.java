package hcmute.edu.vn.orderapp.group4.database;

import static hcmute.edu.vn.orderapp.group4.MainActivity.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.style.UpdateAppearance;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.orderapp.group4.MainActivity;
import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.models.CartModel;
import hcmute.edu.vn.orderapp.group4.models.DetailHomeModel;
import hcmute.edu.vn.orderapp.group4.models.FoodModel;
import hcmute.edu.vn.orderapp.group4.models.HomeModel;
import hcmute.edu.vn.orderapp.group4.models.StoreModel;
import hcmute.edu.vn.orderapp.group4.models.UserModel;
import hcmute.edu.vn.orderapp.group4.ui.profile.ProfileFragment;

public class DBhelper extends SQLiteOpenHelper {

    public static final String DBNAME = "OrderFood.db";

    public DBhelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    //truy vấn không trả về kết quả: CREATE, INSERT, DELETE, UPDATE
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }



    //truy vấn trả về kết quả: SELECT
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table tb_user(email TEXT primary key, password TEXT, user_name TEXT, phone_number TEXT, address TEXT, status TEXT)");
        db.execSQL("create Table tb_store(store_name TEXT primary key, timing TEXT, address TEXT)");
        db.execSQL("create Table tb_food(food_name TEXT, store_name TEXT, description TEXT, rating TEXT, price TEXT)");
        db.execSQL("create Table tb_cart(email TEXT, food_name TEXT, store_name TEXT, rating TEXT, price TEXT, quantity TEXT, status TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists tb_user");
        db.execSQL("drop Table if exists tb_store");
        db.execSQL("drop Table if exists tb_food");
        db.execSQL("drop Table if exists tb_cart");
    }

    public Boolean insertDataUser(String email, String password, String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("user_name", username);
        contentValues.put("status", "0");
        long result = MyDB.insert("tb_user", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkStatus() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_user where status = '1'", null);
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public UserModel getuser(String status) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_user where status = ?",  new String[]{status});
        cursor.moveToPosition(0);
        UserModel user = new UserModel(cursor.getString(0),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getBlob(5));
        return user;
    }

    public void updateStatus(String email, String status){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("UPDATE tb_user SET status=? where email = ?",
                new String[]{status, email});
    }

    public void updateUserName(String email, String user_name){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("UPDATE tb_user SET user_name=? where email = ?",
                new String[]{user_name, email});
    }

    public void updatePassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("UPDATE tb_user SET password=? where email = ?",
                new String[]{password, email});
    }

    public void updatePhoneNumber(String email, String phone){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("UPDATE tb_user SET phone_number=? where email = ?",
                new String[]{phone, email});
    }

    public void updateAddressUser(String email, String address){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("UPDATE tb_user SET address=? where email = ?",
                new String[]{address, email});
    }

    public Boolean checkusername(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_user where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_user where email = ? and password = ?", new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public void insertDataFood(String food_name, String store_name, String description, String rating, String price){

        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from tb_food where food_name = ? and store_name = ?", new String[]{food_name, store_name});
        if (cursor.getCount() <= 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("food_name", food_name);
            contentValues.put("store_name", store_name);
            contentValues.put("rating", rating);
            contentValues.put("price", price);
            contentValues.put("description", description);
            MyDB.insert("tb_food", null, contentValues);
        }
    }

    public void insertDataStore(String store_name, String timing, String address){

        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from tb_store where store_name = ?", new String[]{store_name});
        if (cursor.getCount() <= 0) {
            ContentValues contentValues= new ContentValues();
            contentValues.put("store_name", store_name);
            contentValues.put("timing", timing);
            contentValues.put("address", address);
            MyDB.insert("tb_store", null, contentValues);
        }
    }

    public StoreModel getstore(String store_name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_store where store_name = ?",  new String[]{store_name});
        cursor.moveToPosition(0);
        StoreModel store = new StoreModel(cursor.getString(0),cursor.getString(1), cursor.getString(2));
        return store;
    }

    public Cursor getListstore() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_store",  null);
        return cursor;
    }

    public Cursor getListfood(String store) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_food where store_name =?",  new String[]{store});
        return cursor;
    }

    public FoodModel getfood(String food_name, String store_name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_food where food_name = ? and store_name = ?",  new String[]{food_name, store_name});
        cursor.moveToPosition(0);
        FoodModel food = new FoodModel(cursor.getString(0),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        return food;
    }

    public void insertDataCart(String email, String food_name, String store_name, String rating, String price, String quantity){

        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from tb_cart where email = ? and food_name = ? and store_name = ?" , new String[]{email, food_name,store_name});
        if (cursor.getCount() <= 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("email", email);
            contentValues.put("food_name", food_name);
            contentValues.put("store_name", store_name);
            contentValues.put("rating", rating);
            contentValues.put("price", price);
            contentValues.put("quantity", quantity);
            contentValues.put("status", "1");
            MyDB.insert("tb_cart", null, contentValues);
        }else{
            cursor.moveToPosition(0);
            FoodModel food = DB.getfood(food_name, store_name);
            int old_quantities = Integer.parseInt(cursor.getString(5));
            int new_quantities = Integer.parseInt(quantity);
            int quantities = old_quantities + new_quantities;
            int total = quantities * Integer.parseInt(food.getPrice());
            String soluong = quantities + "";
            String totalprice = total + "";
            MyDB.execSQL("UPDATE tb_cart SET quantity = ? WHERE email = ? and food_name = ? and store_name=?" , new String[]{soluong, email,food_name,store_name});
            MyDB.execSQL("UPDATE tb_cart SET price = ? WHERE email = ? and food_name = ? and store_name=?" , new String[]{totalprice, email,food_name,store_name});

        }
    }

    public Cursor getItemCart(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_cart where email = ? and status = '1'" , new String[]{email});

        return cursor;
    }

    public void updateDataCart(String email, String food_name, String store, String quantity){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        FoodModel food = DB.getfood(food_name, store);
        int total = Integer.parseInt(quantity) * Integer.parseInt(food.getPrice());
        String totalprice = total + "";
        MyDB.execSQL("UPDATE tb_cart SET quantity = ? WHERE email = ? and food_name = ? and store_name = ?",new String[]{quantity, email,food_name, store});
        MyDB.execSQL("UPDATE tb_cart SET price = ? WHERE email = ? and food_name = ? and store_name = ?",new String[]{totalprice, email,food_name, store});
    }

    public void deleteItemCart(String email, String food_name, String store) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("DELETE from tb_cart WHERE email = ? and food_name = ? and store_name = ? and status = '1'",new String[]{email,food_name, store});
    }

    public void updateStatusCart(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("UPDATE tb_cart SET status = '2' WHERE email = ?",new String[]{email});
    }

    public Cursor getItemHistory(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tb_cart where email = ? and status = '2'" , new String[]{email});

        return cursor;
    }

    public void deleteItemHistory(String email, String food_name, String store) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("DELETE from tb_cart WHERE email = ? and food_name = ? and store_name = ? and status = '2'",new String[]{email,food_name, store});
    }

    public void deleteStore(String store) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("DELETE from tb_store WHERE store_name = ?",new String[]{store});
    }

    public void deleteFood(String food, String store) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("DELETE from tb_food WHERE food_name = ? and store_name = ?",new String[]{food, store});
    }
}



