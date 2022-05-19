package presentation;

import bll.BaseProduct;
import bll.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Table {
    public static JTable createTable(Set<MenuItem> items, int ok) {
        // ok=1 => only base Products, else ALL
        String[] columns = {"Name", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        for (MenuItem item : items) {
            List<Object> row = new ArrayList<>();

            if (ok == 0) {
                row.add(item.getTitle());
                row.add(item.getRating());
                row.add(item.getCalories());
                row.add(item.getProtein());
                row.add(item.getFat());
                row.add(item.getSodium());
                row.add(item.getPrice());

                Object[] data = new Object[row.size()];
                row.toArray(data);
                model.addRow(data);
            } else {
                if (item instanceof BaseProduct) {
                    row.add(item.getTitle());
                    row.add(item.getRating());
                    row.add(item.getCalories());
                    row.add(item.getProtein());
                    row.add(item.getFat());
                    row.add(item.getSodium());
                    row.add(item.getPrice());

                    Object[] data = new Object[row.size()];
                    row.toArray(data);
                    model.addRow(data);
                }
            }
        }
        return table;
    }
}
