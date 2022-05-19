package bll;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public interface IDeliveryServiceProcessing {
    /**
     * @pre true
     * @post @result.size() > 0
     */
    void importProductsFromCSV(String name);


    /**
     * @pre !Objects.equals(item.getTitle(),"") && item.getRating() >= 0 && item.getCalories() >= 0 && item.getProtein() >= 0 && item.getFat() >= 0 && item.getSodium() >= 0 && item.getPrice() >= 0
     * @post menuItems.size() = menuItems.size()@pre + 1
     */
    void addProduct(MenuItem item);


    /**
     * @pre item != null && menuItems != null
     * @post menuItems.size() = menuItems.size()@pre - 1
     * @post menuItems.remove(item) != null
     */
    void deleteProduct(MenuItem item);



    /**
     * @pre oldItem != null && newItem != null
     * @pre !Objects.equals(newItem.getTitle(),"") && newItem.getRating() >= 0 && newItem.getCalories() >= 0 && newItem.getProtein() >= 0 && newItem.getFat() >= 0 && newItem.getSodium() >= 0 && newItem.getPrice() >= 0
     * @post menuItems.contains(newItem) == true
     */
    void updateProduct(MenuItem oldItem, MenuItem newItem);


    /**
     * @pre true
     * @post @nochange
     */
    Set<MenuItem> filterProducts(String keyword, float rating, int calories, int protein, int fat, int sodium, float price);

    /**
     * @pre user != null && products.size() > 0
     * @post placeOrders.size() = placeOrders.size()@pre + 1
     */
    Order newOrder(User user, List<MenuItem> products);


}
