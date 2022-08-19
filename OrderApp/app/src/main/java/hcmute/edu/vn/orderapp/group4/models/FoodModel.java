package hcmute.edu.vn.orderapp.group4.models;

public class FoodModel {

    String food_name;
    String store_name;
    String description;
    String rating;
    String price;


    public FoodModel(String food_name, String store_name, String description, String rating, String price) {
        this.food_name = food_name;
        this.store_name = store_name;
        this.description = description;
        this.rating = rating;
        this.price = price;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
