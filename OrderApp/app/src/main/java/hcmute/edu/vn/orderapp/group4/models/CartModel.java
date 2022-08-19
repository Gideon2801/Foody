package hcmute.edu.vn.orderapp.group4.models;

public class CartModel {

    int image;
    String email;
    String name_food;
    String name_store;
    String rating;
    String pice;
    String quatity;



    public CartModel(int image, String name_food, String name_store, String rating, String pice, String quatity) {
        this.image = image;
        this.name_food = name_food;
        this.name_store = name_store;
        this.rating = rating;
        this.pice = pice;
        this.quatity = quatity;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName_food() {
        return name_food;
    }

    public void setName_food(String name_food) {
        this.name_food = name_food;
    }

    public String getName_store() {
        return name_store;
    }

    public void setName_store(String name_store) {
        this.name_store = name_store;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPice() {
        return pice;
    }

    public void setPice(String pice) {
        this.pice = pice;
    }

    public String getQuatity() {
        return quatity;
    }

    public void setQuatity(String quatity) {
        this.quatity = quatity;
    }
}
