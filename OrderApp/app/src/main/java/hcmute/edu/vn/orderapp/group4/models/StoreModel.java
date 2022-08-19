package hcmute.edu.vn.orderapp.group4.models;

public class StoreModel {

    String store_name;
    String timing;
    String address;

    public StoreModel(String store_name, String timing, String address) {
        this.store_name = store_name;
        this.timing = timing;
        this.address = address;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
