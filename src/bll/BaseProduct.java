package bll;

import java.io.Serializable;

public class BaseProduct extends MenuItem {

    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private float price;

    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, float price) {
        super(title);
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public BaseProduct(String title) {
        super(title);
    }

    @Override
    public float getRating() {
        return rating;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public int getProtein() {
        return protein;
    }

    @Override
    public int getFat() {
        return fat;
    }

    @Override
    public int getSodium() {
        return sodium;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public void showDetails() {
        System.out.println("Title: " + getTitle() + " rating: " + rating + " calories: " + calories + " protein: " + protein + " fat: " + fat + " sodium: " + sodium + " price: " + price);
    }


    @Override
    public String toString() {
        return "BaseProduct {" + getTitle() + " : " +
                "rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                "}";
    }


}
