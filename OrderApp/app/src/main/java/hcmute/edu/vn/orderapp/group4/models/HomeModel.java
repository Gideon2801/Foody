package hcmute.edu.vn.orderapp.group4.models;

import android.graphics.Bitmap;

public class HomeModel {

    int image;
    String store_name;
    String address;
    String timing;

    public HomeModel(int image, String store_name, String address, String timing) {
        this.image = image;
        this.store_name = store_name;
        this.address = address;
        this.timing = timing;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
