package presentation.controller;

import Start.Start;
import bll.*;
import presentation.Table;
import presentation.view.Client.ClientView;
import presentation.view.Employee.*;
import presentation.view.Log.LogInView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class ClientController {

    private List<MenuItem> productsForOrder;
    private int selectedRow = -1;
    private MenuItem prod1;
    private MenuItem prod2;
    private User user;
    private float totalPrice;

    public void Initialize(ClientView clientView) {
        productsForOrder = new ArrayList<>();

        clientView.getTextAreaTotal().setText(totalPrice + " RON");

        clientView.getBtnLogOut().addActionListener(e -> {
            clientView.getFrame().dispose();
        });

        clientView.getTable1().addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedRow = clientView.getTable1().getSelectedRow();
                String name = (String) clientView.getModel1().getValueAt(selectedRow, 0);
                prod1 = Start.getDeliveryService().findProductByName(name);

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        clientView.getTable2().addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectedRow = clientView.getTable2().getSelectedRow();
                prod2 = productsForOrder.get(selectedRow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        clientView.getBtnAdd().addActionListener(e12 -> {

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(clientView.getFrame(), "Select a product from table");
                return;
            }

            clientView.getModel2().addRow(new Object[]{prod1.getTitle(), prod1.getPrice()});
            productsForOrder.add(prod1);

            totalPrice += prod1.getPrice();
            clientView.getTextAreaTotal().setText(totalPrice + " RON");

            selectedRow = -1;

        });


        clientView.getBtnRemove().addActionListener(e12 -> {
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(clientView.getFrame(), "Select a product from table");
                return;
            }
            productsForOrder.remove(prod2);
            clientView.getModel2().removeRow(clientView.getTable2().getSelectedRow());

            totalPrice -= prod2.getPrice();
            clientView.getTextAreaTotal().setText(totalPrice + " RON");
            selectedRow = -1;

        });

        clientView.getBtnCreate().addActionListener(e12 -> {
            if (productsForOrder.isEmpty()) {
                JOptionPane.showMessageDialog(clientView, "No products selected for order!");
                return;
            }
            int rows = clientView.getModel2().getRowCount();

            DeliveryService deliveryService = Start.getDeliveryService();
            Order or = deliveryService.newOrder(user, productsForOrder);
            deliveryService.serializeAll();

            for (int i = 1; i <= rows; i++)
                clientView.getModel2().removeRow(0);

            productsForOrder = new ArrayList<>();
            totalPrice = 0;
            clientView.getTextAreaTotal().setText(totalPrice + " RON");


        });


        clientView.getBtnViewResults().addActionListener(e -> {

            String word = "";
            float rating = -1;
            int calories = -1;
            int protein = -1;
            int fat = -1;
            int sodium = -1;
            float price = -1;

            if (!Objects.equals(clientView.getTextFieldName().getText(), ""))
                word = clientView.getTextFieldName().getText();
            if (!clientView.getTextFieldRating().getText().equals(""))
                rating = Float.parseFloat(clientView.getTextFieldRating().getText());
            if (!clientView.getTextFieldCalories().getText().equals(""))
                calories = Integer.parseInt(clientView.getTextFieldCalories().getText());
            if (!clientView.getTextFieldProtein().getText().equals(""))
                protein = Integer.parseInt(clientView.getTextFieldProtein().getText());
            if (!clientView.getTextFieldFat().getText().equals(""))
                fat = Integer.parseInt(clientView.getTextFieldFat().getText());
            if (!clientView.getTextFieldSodium().getText().equals(""))
                sodium = Integer.parseInt(clientView.getTextFieldSodium().getText());
            if (!clientView.getTextFieldPrice().getText().equals(""))
                price = Float.parseFloat(clientView.getTextFieldPrice().getText());


            DeliveryService deliveryService = Start.getDeliveryService();
            Set<MenuItem> items = deliveryService.filterProducts(word, rating, calories, protein, fat, sodium, price);

            JTable table = Table.createTable(items, 0);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            clientView.getTable1().setModel(model);
            clientView.setModel1(model);

        });

        clientView.getBtnClear().addActionListener(e -> {
            clientView.getTextFieldName().setText("");
            clientView.getTextFieldRating().setText("");
            clientView.getTextFieldCalories().setText("");
            clientView.getTextFieldProtein().setText("");
            clientView.getTextFieldFat().setText("");
            clientView.getTextFieldSodium().setText("");
            clientView.getTextFieldPrice().setText("");
        });

    }

    public void setUser(User user) {
        this.user = user;
    }
}
