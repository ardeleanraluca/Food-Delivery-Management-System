package presentation.view.Administrator;

import bll.DeliveryService;
import presentation.Table;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EditBaseProduct extends JFrame {
    private JFrame frame = this;

    private JPanel contentPane;

    private JTable table;
    private DefaultTableModel model;

    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;

    private JButton back;

    private JTextField textFieldName;
    private JTextField textFieldRating;
    private JTextField textFieldCalories;
    private JTextField textFieldProtein;
    private JTextField textFieldFat;
    private JTextField textFieldSodium;
    private JTextField textFieldPrice;


    public EditBaseProduct() {

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrator");
        setBounds(100, 100, 1169, 625);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 84, 798, 453);
        contentPane.add(scrollPane);


        DeliveryService deliveryService = new DeliveryService();
        table = Table.createTable(deliveryService.getMenuItems(), 0);
        model = (DefaultTableModel) table.getModel();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("Edit Product");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
        lblNewLabel.setBounds(458, 2, 192, 59);
        contentPane.add(lblNewLabel);

        textFieldName = new JTextField();
        textFieldName.setBounds(836, 84, 237, 40);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setBounds(1096, 97, 49, 14);
        contentPane.add(lblNewLabel_1);

        btnInsert = new JButton("Insert");
        btnInsert.setForeground(new Color(255, 255, 255));
        btnInsert.setBackground(new Color(65, 105, 225));
        btnInsert.setBounds(836, 490, 81, 47);
        contentPane.add(btnInsert);

        btnUpdate = new JButton("Update");
        btnUpdate.setForeground(new Color(255, 255, 255));
        btnUpdate.setBackground(new Color(65, 105, 225));
        btnUpdate.setBounds(950, 490, 81, 47);
        contentPane.add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.setBackground(new Color(65, 105, 225));
        btnDelete.setBounds(1064, 490, 81, 47);
        contentPane.add(btnDelete);

        this.setVisible(true);
        this.setResizable(false);

        back = new JButton("Go Back");
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(65, 105, 225));
        back.setBounds(2, 2, 100, 20);
        contentPane.add(back);

        textFieldCalories = new JTextField();
        textFieldCalories.setColumns(10);
        textFieldCalories.setBounds(836, 189, 237, 40);
        contentPane.add(textFieldCalories);

        JLabel lblNewLabel_1_1 = new JLabel("Calories");
        lblNewLabel_1_1.setBounds(1096, 202, 49, 14);
        contentPane.add(lblNewLabel_1_1);

        textFieldProtein = new JTextField();
        textFieldProtein.setColumns(10);
        textFieldProtein.setBounds(836, 240, 237, 40);
        contentPane.add(textFieldProtein);

        JLabel lblNewLabel_1_2 = new JLabel("Protein");
        lblNewLabel_1_2.setBounds(1096, 253, 49, 14);
        contentPane.add(lblNewLabel_1_2);

        textFieldFat = new JTextField();
        textFieldFat.setColumns(10);
        textFieldFat.setBounds(836, 291, 237, 40);
        contentPane.add(textFieldFat);

        JLabel lblNewLabel_1_3 = new JLabel("Fat");
        lblNewLabel_1_3.setBounds(1096, 304, 49, 14);
        contentPane.add(lblNewLabel_1_3);

        textFieldSodium = new JTextField();
        textFieldSodium.setColumns(10);
        textFieldSodium.setBounds(836, 342, 237, 40);
        contentPane.add(textFieldSodium);

        JLabel lblNewLabel_1_4 = new JLabel("Sodium");
        lblNewLabel_1_4.setBounds(1096, 355, 49, 14);
        contentPane.add(lblNewLabel_1_4);

        textFieldPrice = new JTextField();
        textFieldPrice.setColumns(10);
        textFieldPrice.setBounds(836, 393, 237, 40);
        contentPane.add(textFieldPrice);

        JLabel lblNewLabel_1_6 = new JLabel("Price");
        lblNewLabel_1_6.setBounds(1096, 406, 49, 14);
        contentPane.add(lblNewLabel_1_6);

        textFieldRating = new JTextField();
        textFieldRating.setColumns(10);
        textFieldRating.setBounds(836, 138, 237, 40);
        contentPane.add(textFieldRating);

        JLabel lblNewLabel_1_5 = new JLabel("Rating");
        lblNewLabel_1_5.setBounds(1096, 151, 49, 14);
        contentPane.add(lblNewLabel_1_5);

    }


    public JFrame getFrame() {
        return frame;
    }

    public JButton getBtnInsert() {
        return btnInsert;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnBack() {
        return back;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldRating() {
        return textFieldRating;
    }

    public JTextField getTextFieldCalories() {
        return textFieldCalories;
    }

    public JTextField getTextFieldProtein() {
        return textFieldProtein;
    }

    public JTextField getTextFieldFat() {
        return textFieldFat;
    }

    public JTextField getTextFieldSodium() {
        return textFieldSodium;
    }

    public JTextField getTextFieldPrice() {
        return textFieldPrice;
    }
}
