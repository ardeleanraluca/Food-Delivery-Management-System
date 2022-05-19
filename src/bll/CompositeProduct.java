package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeProduct extends MenuItem {
    private List<MenuItem> menuItemList;

    private float price;

    public CompositeProduct(String title, List<MenuItem> items) {
        super(title);
        this.menuItemList = items;

    }

    public String getTitle() {
        return super.getTitle();
    }


    public void setPrice(float price) {
        this.price = price;
    }


    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    @Override
    public float getRating() {
        float rating = 0;
        for (MenuItem item : this.menuItemList) {
            rating += item.getRating();
        }
        rating /= menuItemList.size();
        return rating;
    }


    @Override
    public int getCalories() {
        int calories = 0;
        for (MenuItem item : menuItemList) {
            calories += item.getCalories();
        }
        return calories;
    }


    @Override
    public int getProtein() {
        int proteins = 0;
        for (MenuItem item : menuItemList) {
            proteins += item.getProtein();
        }
        return proteins;
    }


    @Override
    public int getFat() {
        int fat = 0;
        for (MenuItem item : menuItemList) {
            fat += item.getFat();
        }
        return fat;
    }


    @Override
    public int getSodium() {
        int sodium = 0;
        for (MenuItem item : menuItemList) {
            sodium += item.getSodium();
        }
        return sodium;
    }

    @Override
    public float getPrice() {
        float price = 0;
        for (MenuItem item : this.menuItemList) {
            price += item.getPrice();
        }
        setPrice(price);
        return price;
    }

    @Override
    public String toString() {
        return "CompositeProduct {"+getTitle() + " : " +
                ", menuItemList=" + menuItemList +
                ", price=" + price +
                '}';
    }

}
