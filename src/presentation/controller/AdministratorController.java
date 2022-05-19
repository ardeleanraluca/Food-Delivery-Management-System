package presentation.controller;

import Start.Start;
import bll.BaseProduct;
import bll.CompositeProduct;
import bll.DeliveryService;
import bll.MenuItem;
import presentation.Table;
import presentation.view.Administrator.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class AdministratorController {

    private int selectedRow = -1;

    private BaseProduct prod1;
    private BaseProduct prod2;

    private List<MenuItem> baseProductsForComposite;

    public void Initialize(AdministratorView administratorView) {
        baseProductsForComposite = new ArrayList<>();

        administratorView.getBtnViewAllProducts().addActionListener(e -> {
            administratorView.getFrame().dispose();
            ViewAll viewAll = new ViewAll();

            viewAll.getBack().addActionListener(e12 -> {
                viewAll.getFrame().dispose();
                AdministratorController administratorController = new AdministratorController();
                AdministratorView adminView = new AdministratorView();
                administratorController.Initialize(adminView);
            });

            viewAll.getBtnSearch().addActionListener(e9 -> {

                String word = "";
                float rating = -1;
                int calories = -1;
                int protein = -1;
                int fat = -1;
                int sodium = -1;
                float price = -1;

                if (!Objects.equals(viewAll.getTextFieldSearch().getText(), ""))
                    word = viewAll.getTextFieldSearch().getText();

                DeliveryService deliveryService = Start.getDeliveryService();
                Set<MenuItem> items = deliveryService.filterProducts(word, rating, calories, protein, fat, sodium, price);

                JTable table = Table.createTable(items, 0);

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                viewAll.getTable().setModel(model);

            });

        });

        administratorView.getBtnLogOut().addActionListener(e -> {
            administratorView.getFrame().dispose();
        });


        administratorView.getBtnEditBaseProd().addActionListener(e -> {
            administratorView.getFrame().dispose();
            EditBaseProduct editBP = new EditBaseProduct();

            editBP.getTable().addMouseListener(new MouseListener() {
                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    selectedRow = editBP.getTable().getSelectedRow();
                    editBP.getTextFieldName().setText((String) editBP.getModel().getValueAt(selectedRow, 0));
                    editBP.getTextFieldRating().setText(String.valueOf(editBP.getModel().getValueAt(selectedRow, 1)));
                    editBP.getTextFieldCalories().setText(String.valueOf(editBP.getModel().getValueAt(selectedRow, 2)));
                    editBP.getTextFieldProtein().setText(String.valueOf(editBP.getModel().getValueAt(selectedRow, 3)));
                    editBP.getTextFieldFat().setText(String.valueOf(editBP.getModel().getValueAt(selectedRow, 4)));
                    editBP.getTextFieldSodium().setText(String.valueOf(editBP.getModel().getValueAt(selectedRow, 5)));
                    editBP.getTextFieldPrice().setText(String.valueOf(editBP.getModel().getValueAt(selectedRow, 6)));

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


            editBP.getBtnInsert().addActionListener(e1 -> {

                if (editBP.getTextFieldName().getText().equals("") || editBP.getTextFieldRating().getText().equals("") ||
                        editBP.getTextFieldCalories().getText().equals("") || editBP.getTextFieldProtein().getText().equals("") ||
                        editBP.getTextFieldFat().getText().equals("") || editBP.getTextFieldSodium().getText().equals("") ||
                        editBP.getTextFieldPrice().getText().equals("")) {

                    JOptionPane.showMessageDialog(editBP.getFrame(), "Some fields are empty!");
                    return;

                }


                String name = editBP.getTextFieldName().getText();
                float rating = Float.parseFloat(editBP.getTextFieldRating().getText());
                int calories = Integer.parseInt(editBP.getTextFieldCalories().getText());
                int protein = Integer.parseInt(editBP.getTextFieldProtein().getText());
                int fat = Integer.parseInt(editBP.getTextFieldFat().getText());
                int sodium = Integer.parseInt(editBP.getTextFieldSodium().getText());
                float price = Float.parseFloat(editBP.getTextFieldPrice().getText());


                if (rating < 0 || calories < 0 || protein < 0 || fat < 0 || sodium < 0 || price < 0) {
                    JOptionPane.showMessageDialog(editBP.getFrame(), "Negative inputs!");
                    return;
                }


                BaseProduct p = new BaseProduct(name, rating, calories, protein, fat, sodium, price);
                DeliveryService deliveryService = Start.getDeliveryService();
                deliveryService.addProduct(p);
                deliveryService.serializeAll();

                editBP.getModel().insertRow(0, new Object[]{name, rating, calories, protein, fat, sodium, price});

                editBP.getTextFieldName().setText("");
                editBP.getTextFieldRating().setText("");
                editBP.getTextFieldCalories().setText("");
                editBP.getTextFieldProtein().setText("");
                editBP.getTextFieldFat().setText("");
                editBP.getTextFieldSodium().setText("");
                editBP.getTextFieldPrice().setText("");
                selectedRow = -1;

            });


            editBP.getBtnUpdate().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(editBP.getFrame(), "Select a product from table to modify!");
                        return;
                    }


                    String nameO = (String) editBP.getModel().getValueAt(selectedRow, 0);
                    float ratingO = Float.parseFloat(String.valueOf(editBP.getModel().getValueAt(selectedRow, 1)));
                    int caloriesO = Integer.parseInt(String.valueOf(editBP.getModel().getValueAt(selectedRow, 2)));
                    int proteinO = Integer.parseInt(String.valueOf(editBP.getModel().getValueAt(selectedRow, 3)));
                    int fatO = Integer.parseInt(String.valueOf(editBP.getModel().getValueAt(selectedRow, 4)));
                    int sodiumO = Integer.parseInt(String.valueOf(editBP.getModel().getValueAt(selectedRow, 5)));
                    float priceO = Float.parseFloat(String.valueOf(editBP.getModel().getValueAt(selectedRow, 6)));

                    BaseProduct oldP = new BaseProduct(nameO, ratingO, caloriesO, proteinO, fatO, sodiumO, priceO);


                    if (editBP.getTextFieldName().getText().equals("") || editBP.getTextFieldRating().getText().equals("") ||
                            editBP.getTextFieldCalories().getText().equals("") || editBP.getTextFieldProtein().getText().equals("") ||
                            editBP.getTextFieldFat().getText().equals("") || editBP.getTextFieldSodium().getText().equals("") ||
                            editBP.getTextFieldPrice().getText().equals("")) {

                        JOptionPane.showMessageDialog(editBP.getFrame(), "Some fields are empty!");
                        return;

                    }

                    String name = editBP.getTextFieldName().getText();
                    float rating = Float.parseFloat(editBP.getTextFieldRating().getText());
                    int calories = Integer.parseInt(editBP.getTextFieldCalories().getText());
                    int protein = Integer.parseInt(editBP.getTextFieldProtein().getText());
                    int fat = Integer.parseInt(editBP.getTextFieldFat().getText());
                    int sodium = Integer.parseInt(editBP.getTextFieldSodium().getText());
                    float price = Float.parseFloat(editBP.getTextFieldPrice().getText());

                    if (rating < 0 || calories < 0 || protein < 0 || fat < 0 || sodium < 0 || price < 0) {
                        JOptionPane.showMessageDialog(editBP.getFrame(), "Negative inputs!");
                        return;
                    }

                    BaseProduct newP = new BaseProduct(name, rating, calories, protein, fat, sodium, price);

                    DeliveryService deliveryService = Start.getDeliveryService();
                    deliveryService.updateProduct(oldP, newP);
                    deliveryService.serializeAll();

                    editBP.getModel().setValueAt(editBP.getTextFieldName().getText(), selectedRow, 0);
                    editBP.getModel().setValueAt(editBP.getTextFieldRating().getText(), selectedRow, 1);
                    editBP.getModel().setValueAt(editBP.getTextFieldCalories().getText(), selectedRow, 2);
                    editBP.getModel().setValueAt(editBP.getTextFieldProtein().getText(), selectedRow, 3);
                    editBP.getModel().setValueAt(editBP.getTextFieldFat().getText(), selectedRow, 4);
                    editBP.getModel().setValueAt(editBP.getTextFieldSodium().getText(), selectedRow, 5);
                    editBP.getModel().setValueAt(editBP.getTextFieldPrice().getText(), selectedRow, 6);

                    editBP.getTextFieldName().setText("");
                    editBP.getTextFieldRating().setText("");
                    editBP.getTextFieldCalories().setText("");
                    editBP.getTextFieldProtein().setText("");
                    editBP.getTextFieldFat().setText("");
                    editBP.getTextFieldSodium().setText("");
                    editBP.getTextFieldPrice().setText("");
                    selectedRow = -1;


                }
            });

            editBP.getBtnDelete().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(editBP.getFrame(), "Select a product for delete");
                        return;
                    }
                    editBP.getModel().removeRow(selectedRow);

                    String name = editBP.getTextFieldName().getText();
                    float rating = Float.parseFloat(editBP.getTextFieldRating().getText());
                    int calories = Integer.parseInt(editBP.getTextFieldCalories().getText());
                    int protein = Integer.parseInt(editBP.getTextFieldProtein().getText());
                    int fat = Integer.parseInt(editBP.getTextFieldFat().getText());
                    int sodium = Integer.parseInt(editBP.getTextFieldSodium().getText());
                    float price = Float.parseFloat(editBP.getTextFieldPrice().getText());

                    BaseProduct p = new BaseProduct(name, rating, calories, protein, fat, sodium, price);

                    editBP.getTextFieldName().setText("");
                    editBP.getTextFieldRating().setText("");
                    editBP.getTextFieldCalories().setText("");
                    editBP.getTextFieldProtein().setText("");
                    editBP.getTextFieldFat().setText("");
                    editBP.getTextFieldSodium().setText("");
                    editBP.getTextFieldPrice().setText("");
                    selectedRow = -1;

                    DeliveryService deliveryService = Start.getDeliveryService();
                    deliveryService.deleteProduct(p);
                    deliveryService.serializeAll();
                }
            });


            editBP.getBtnBack().addActionListener(e12 -> {
                editBP.getFrame().dispose();
                AdministratorController administratorController = new AdministratorController();
                AdministratorView adminView = new AdministratorView();
                administratorController.Initialize(adminView);
            });


        });

        administratorView.getBtnCreateCompositeProduct().addActionListener(e -> {

            administratorView.getFrame().dispose();
            CreateCompositeProduct addComp = new CreateCompositeProduct();

            addComp.getBackBtn().addActionListener(e12 -> {
                addComp.getFrame().dispose();
                AdministratorController administratorController = new AdministratorController();
                AdministratorView adminView = new AdministratorView();
                administratorController.Initialize(adminView);
            });


            addComp.getTable1().addMouseListener(new MouseListener() {
                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    selectedRow = addComp.getTable1().getSelectedRow();

                    String name = (String) addComp.getModel1().getValueAt(selectedRow, 0);
                    float rating = Float.parseFloat(String.valueOf(addComp.getModel1().getValueAt(selectedRow, 1)));
                    int calories = Integer.parseInt(String.valueOf(addComp.getModel1().getValueAt(selectedRow, 2)));
                    int protein = Integer.parseInt(String.valueOf(addComp.getModel1().getValueAt(selectedRow, 3)));
                    int fat = Integer.parseInt(String.valueOf(addComp.getModel1().getValueAt(selectedRow, 4)));
                    int sodium = Integer.parseInt(String.valueOf(addComp.getModel1().getValueAt(selectedRow, 5)));
                    float price = Float.parseFloat(String.valueOf(addComp.getModel1().getValueAt(selectedRow, 6)));

                    prod1 = new BaseProduct(name, rating, calories, protein, fat, sodium, price);

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


            addComp.getTable2().addMouseListener(new MouseListener() {
                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    selectedRow = (addComp.getTable2().getSelectedRow());

                    String name = (String) addComp.getModel2().getValueAt(selectedRow, 0);
                    float rating = Float.parseFloat(String.valueOf(addComp.getModel2().getValueAt(selectedRow, 1)));
                    int calories = Integer.parseInt(String.valueOf(addComp.getModel2().getValueAt(selectedRow, 2)));
                    int protein = Integer.parseInt(String.valueOf(addComp.getModel2().getValueAt(selectedRow, 3)));
                    int fat = Integer.parseInt(String.valueOf(addComp.getModel2().getValueAt(selectedRow, 4)));
                    int sodium = Integer.parseInt(String.valueOf(addComp.getModel2().getValueAt(selectedRow, 5)));
                    float price = Float.parseFloat(String.valueOf(addComp.getModel2().getValueAt(selectedRow, 6)));

                    prod2 = new BaseProduct(name, rating, calories, protein, fat, sodium, price);
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

            addComp.getBtnAdd().addActionListener(e12 -> {

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(addComp.getFrame(), "Select a product from table");
                    return;
                }

                addComp.getModel2().addRow(new Object[]{prod1.getTitle(), prod1.getRating(), prod1.getCalories(),
                        prod1.getProtein(), prod1.getFat(), prod1.getSodium(), prod1.getPrice()});

                baseProductsForComposite.add(prod1);
                selectedRow = -1;

            });


            addComp.getBtnRemove().addActionListener(e12 -> {
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(addComp.getFrame(), "Select a product from table");
                    return;
                }
                baseProductsForComposite.remove(prod2);
                addComp.getModel2().removeRow(addComp.getTable2().getSelectedRow());
                selectedRow = -1;
            });

            addComp.getBtnCreate().addActionListener(e12 -> {
                if (baseProductsForComposite.isEmpty()) {

                    JOptionPane.showMessageDialog(addComp.getFrame(), "No products for composite product! Please select from table!");
                    return;
                }

                if (addComp.getNameField().getText().equals("")) {

                    JOptionPane.showMessageDialog(addComp.getFrame(), "Please give a name to your new composite product!");
                    return;
                }
                CompositeProduct compositeProduct = new CompositeProduct(addComp.getNameField().getText(), baseProductsForComposite);
                DeliveryService deliveryService = Start.getDeliveryService();
                deliveryService.addProduct(compositeProduct);
                deliveryService.serializeAll();

                int rows = addComp.getModel2().getRowCount();

                for (int i = 1; i <= rows; i++)
                    addComp.getModel2().removeRow(0);
                addComp.getNameField().setText("");
            });


        });


        administratorView.getBtnGenerateRaports().addActionListener(e -> {
            administratorView.getFrame().dispose();
            GenerateRaports generateRaports = new GenerateRaports();

            generateRaports.getBtn1().addActionListener(eB1 -> {
                int startHour = 0;
                int endHour = 0;
                String sHour = generateRaports.getComboBoxStartHour().getSelectedItem().toString();
                String eHour = generateRaports.getComboBoxEndHour().getSelectedItem().toString();
                if (!sHour.equals("Start Hour")) {
                    startHour = Integer.parseInt(sHour);
                } else {
                    JOptionPane.showMessageDialog(generateRaports.getFrame(), "Select Start Hour!");
                    return;
                }
                if (!eHour.equals("End Hour")) {
                    endHour = Integer.parseInt(sHour);
                } else {
                    JOptionPane.showMessageDialog(generateRaports.getFrame(), "Select End Hour!");
                    return;
                }

                Start.getDeliveryService().generateRaport1(startHour, endHour);
                JOptionPane.showMessageDialog(generateRaports.getFrame(),"Raport 1 was generated");

            });

            generateRaports.getBtn2().addActionListener(eB1 -> {
                if (generateRaports.getTextFieldTime1().getText().equals("")) {
                    JOptionPane.showMessageDialog(generateRaports.getFrame(), "Empty field!");
                    return;
                }
                int times = Integer.parseInt(generateRaports.getTextFieldTime1().getText());

                if (times < 0) {
                    JOptionPane.showMessageDialog(generateRaports.getFrame(), "Invalid input for raport_type_2!");
                    return;
                }

                Start.getDeliveryService().generateRaport2(times);
                JOptionPane.showMessageDialog(generateRaports.getFrame(),"Raport 2 was generated");
            });

            generateRaports.getBtn3().addActionListener(eB1 -> {
                if (generateRaports.getTextFieldTime1().getText().equals("") || generateRaports.getTextFieldAmount().getText().equals("")) {
                    JOptionPane.showMessageDialog(generateRaports.getFrame(), "Some fields are empty!");
                    return;
                }
                int times = Integer.parseInt(generateRaports.getTextFieldTime2().getText());
                float amount = Float.parseFloat(generateRaports.getTextFieldAmount().getText());

                if (times < 0 || amount < 0) {
                    JOptionPane.showMessageDialog(generateRaports.getFrame(), "Invalid inputs for raport_type_3!");
                    return;
                }
                Start.getDeliveryService().generateRaport3(times, amount);
                JOptionPane.showMessageDialog(generateRaports.getFrame(),"Raport 3 was generated");
            });


            generateRaports.getBtn4().addActionListener(eB1 -> {
                int day = 0;
                int month = 0;
                int year = 0;
                String yearS = generateRaports.getComboBoxYear().getSelectedItem().toString();
                String monthS = generateRaports.getComboBoxMonth().getSelectedItem().toString();
                String dayS = generateRaports.getComboBoxDay().getSelectedItem().toString();
                if (!yearS.equals("Year")) {
                    year = Integer.parseInt(yearS);
                } else {
                    JOptionPane.showMessageDialog(generateRaports.getFrame(), "Select year");
                    return;
                }
                if (!monthS.equals("Month")) {
                    month = Integer.parseInt(monthS);
                } else {
                    JOptionPane.showMessageDialog(generateRaports.getFrame(), "Select month");
                    return;
                }

                if (!monthS.equals("Day")) {
                    day = Integer.parseInt(dayS);
                } else {
                    JOptionPane.showMessageDialog(generateRaports.getFrame(), "Select day");
                    return;
                }

                Start.getDeliveryService().generateRaport4(day, month, year);
                JOptionPane.showMessageDialog(generateRaports.getFrame(),"Raport 4 was generated");

            });


            generateRaports.getBtnBack().addActionListener(e12 -> {
                generateRaports.getFrame().dispose();
                AdministratorController administratorController = new AdministratorController();
                AdministratorView adminView = new AdministratorView();
                administratorController.Initialize(adminView);
            });

        });

    }
}