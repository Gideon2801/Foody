package hcmute.edu.vn.orderapp.group4.models;

public class UserModel {

    String email;
    String passwrod;
    String name;
    String phone;
    String address;
    byte[] image;

    public UserModel(String email, String passwrod, String name, String phone, String address, byte[] image) {
        this.email = email;
        this.passwrod = passwrod;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
