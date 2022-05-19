package dao;

import bll.*;
import bll.MenuItem;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FileWriter {

    public static void generateReport1(int from, int to, List<Order> orders) {
        String toWrite = "Time interval of the orders.\nOrders between " + from + " and " + to + ":\n\n";
        for (Order o : orders) {
            toWrite += "Order ID: " + o.getId() + " Client ID: " + o.getIdClient() + " Date And Time: " + o.getOrderDate() + "\n";
        }
        try {
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            java.io.FileWriter fileWriter = new java.io.FileWriter("Raport_T1_" + localDate + "-" + localTime.getHour() + "-" + localTime.getMinute() + "-" + localTime.getSecond() + ".txt");
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write(toWrite);
            buffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void generateReport2(int times, List<MenuItem> products) {
        String toWrite = "The products ordered more than " + times + "  times so far:\n\n";
        for (MenuItem p : products) {
            toWrite += p.toString() + "\n";
        }
        try {
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            java.io.FileWriter fileWriter = new java.io.FileWriter("Raport_T2_" + localDate + "-" + localTime.getHour() + "-" + localTime.getMinute() + "-" + localTime.getSecond() + ".txt");
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write(toWrite);
            buffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void generateReport3(int times, float amount, List<User> users) {
        String toWrite = "The clients that have ordered more than " + times + " times so far and the value of the order was higher than " + amount + " RON:\n\n";

        for (User u : users) {
            toWrite += u.getId() + u.getName() + u.getUsername() + "\n";
        }
        try {
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            java.io.FileWriter fileWriter = new java.io.FileWriter("Raport_T3_" + localDate + "-" + localTime.getHour() + "-" + localTime.getMinute() + "-" + localTime.getSecond() + ".txt");
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write(toWrite);
            buffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void generateReport4(int day, int month, int year, Map<MenuItem, Long> products) {

        String m = "";
        if (month < 10)
            m = "0" + month;
        else
            m = String.valueOf(month);

        String toWrite = "The products ordered within " + day + "." + m + "." + year + " with the number of times they have been ordered:\n\n";
        for (Map.Entry<MenuItem, Long> entry : products.entrySet()) {
            toWrite += entry.getKey() + " -> " + entry.getValue() + "\n";
        }
        try {
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            java.io.FileWriter fileWriter = new java.io.FileWriter("Raport_T4_" + localDate + "-" + localTime.getHour() + "-" + localTime.getMinute() + "-" + localTime.getSecond() + ".txt");
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write(toWrite);
            buffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void createBill(DeliveryService deliveryService, Order order) {
        String toWrite = "Bill order id: " + order.getId() + "\n";
        toWrite += "Client: " + deliveryService.findUserById(order.getIdClient(), deliveryService.getUsers()).getName() + "\n";
        toWrite += "Date: " + order.getOrderDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() + "\n";
        toWrite += "Hour: " + order.getOrderDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime() + "\n";
        toWrite += "Products: \n";

        for (MenuItem menuItem : deliveryService.getPlacedOrders().get(order)) {
            if (menuItem instanceof CompositeProduct) {
                toWrite += "     -> " + menuItem.getTitle() + " : ";
                for (MenuItem itm : ((CompositeProduct) menuItem).getMenuItemList())
                    toWrite += itm.getTitle() + " + ";
                toWrite = toWrite.substring(0, toWrite.length() - 1) + " : " + menuItem.getPrice() + " RON\n";
            } else {
                toWrite += "     -> " + menuItem.getTitle() + " : " + menuItem.getPrice() + " RON\n";
            }
        }
        toWrite += "Total Price: " + order.getTotalPrice() + " RON\n";


        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("Order_" + order.getId() + ".txt");
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write(toWrite);
            buffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
