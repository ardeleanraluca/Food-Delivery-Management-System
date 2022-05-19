package presentation.view.Client;

import bll.*;
import bll.MenuItem;
import presentation.Table;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClientView extends JFrame {
    private JTextArea textAreaTotal;
    private JFrame frame = this;

    private JPanel contentPane;

    private JTable table1;
    private DefaultTableModel model1;

    private JTable table2;
    private DefaultTableModel model2;


    private JButton btnCreate;
    private JButton btnRemove;
    private JButton btnLogOut;
    private JButton btnAdd;
    private JButton btnClear;
    private JButton btnViewResults;

    private JTextField textFieldName;
    private JTextField textFieldRating;
    private JTextField textFieldCalories;
    private JTextField textFieldProtein;
    private JTextField textFieldFat;
    private JTextField textFieldSodium;
    private JTextField textFieldPrice;


    public ClientView() {
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Client");
        setBounds(100, 100, 1245, 625);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(317, 73, 586, 442);
        contentPane.add(scrollPane);

        JLabel lblNewLabel = new JLabel("Place Order");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
        lblNewLabel.setBounds(358, 2, 449, 59);
        contentPane.add(lblNewLabel);

        this.setVisible(true);
        this.setResizable(false);


        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(940, 73, 281, 379);
        contentPane.add(scrollPane_1);

        DeliveryService deliveryService = new DeliveryService();
        System.out.println(deliveryService.getMenuItems());
        table1 = Table.createTable(deliveryService.getMenuItems(), 0);
        model1 = (DefaultTableModel) table1.getModel();
        scrollPane.setViewportView(table1);


        String[] columns = {"Name", "Price"};
        model2 = new DefaultTableModel(columns, 0);
        table2 = new JTable(model2);
        scrollPane_1.setViewportView(table2);


        btnAdd = new JButton("ADD");
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(65, 105, 225));
        btnAdd.setBounds(814, 526, 89, 23);
        contentPane.add(btnAdd);

        btnCreate = new JButton("Order");
        btnCreate.setForeground(new Color(255, 255, 255));
        btnCreate.setBackground(new Color(65, 105, 225));
        btnCreate.setBounds(1132, 526, 89, 23);
        contentPane.add(btnCreate);

        JLabel lblNewLabel_1 = new JLabel("Products");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(319, 56, 112, 14);
        contentPane.add(lblNewLabel_1);

        btnRemove = new JButton("Remove");
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setBackground(new Color(65, 105, 225));
        btnRemove.setBounds(1018, 526, 89, 23);
        contentPane.add(btnRemove);

        JLabel lblNewLabel_1_1 = new JLabel("My Order");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(937, 56, 112, 14);
        contentPane.add(lblNewLabel_1_1);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setForeground(new Color(255, 255, 255));
        btnLogOut.setBackground(new Color(65, 105, 225));
        btnLogOut.setBounds(1121, 2, 100, 20);
        contentPane.add(btnLogOut);

        JLabel lblNewLabel_1_2 = new JLabel("Filter");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_2.setBounds(10, 56, 112, 33);
        contentPane.add(lblNewLabel_1_2);

        btnViewResults = new JButton("View Results");
        btnViewResults.setForeground(new Color(255, 255, 255));
        btnViewResults.setBackground(new Color(65, 105, 225));
        btnViewResults.setBounds(171, 496, 120, 20);
        contentPane.add(btnViewResults);

        textFieldName = new JTextField();
        textFieldName.setBounds(97, 103, 194, 42);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);

        textFieldRating = new JTextField();
        textFieldRating.setColumns(10);
        textFieldRating.setBounds(97, 156, 194, 42);
        contentPane.add(textFieldRating);

        textFieldCalories = new JTextField();
        textFieldCalories.setColumns(10);
        textFieldCalories.setBounds(97, 217, 194, 42);
        contentPane.add(textFieldCalories);

        textFieldProtein = new JTextField();
        textFieldProtein.setColumns(10);
        textFieldProtein.setBounds(97, 270, 194, 42);
        contentPane.add(textFieldProtein);

        textFieldFat = new JTextField();
        textFieldFat.setColumns(10);
        textFieldFat.setBounds(97, 323, 194, 42);
        contentPane.add(textFieldFat);

        textFieldSodium = new JTextField();
        textFieldSodium.setColumns(10);
        textFieldSodium.setBounds(97, 376, 194, 42);
        contentPane.add(textFieldSodium);

        textFieldPrice = new JTextField();
        textFieldPrice.setColumns(10);
        textFieldPrice.setBounds(97, 429, 194, 42);
        contentPane.add(textFieldPrice);

        JLabel lblNewLabel_1_3 = new JLabel("Name");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(12, 114, 75, 14);
        contentPane.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_3_1 = new JLabel("Rating");
        lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3_1.setBounds(12, 170, 75, 14);
        contentPane.add(lblNewLabel_1_3_1);

        JLabel lblNewLabel_1_3_2 = new JLabel("Calories");
        lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3_2.setBounds(12, 229, 75, 14);
        contentPane.add(lblNewLabel_1_3_2);

        JLabel lblNewLabel_1_3_3 = new JLabel("Protein");
        lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3_3.setBounds(12, 284, 75, 14);
        contentPane.add(lblNewLabel_1_3_3);

        JLabel lblNewLabel_1_3_4 = new JLabel("Fat");
        lblNewLabel_1_3_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3_4.setBounds(12, 337, 75, 14);
        contentPane.add(lblNewLabel_1_3_4);

        JLabel lblNewLabel_1_3_5 = new JLabel("Sodium");
        lblNewLabel_1_3_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3_5.setBounds(12, 390, 75, 14);
        contentPane.add(lblNewLabel_1_3_5);

        JLabel lblNewLabel_1_3_6 = new JLabel("Price");
        lblNewLabel_1_3_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_3_6.setBounds(12, 443, 75, 14);
        contentPane.add(lblNewLabel_1_3_6);

        btnClear = new JButton("Clear");
        btnClear.setForeground(new Color(255, 255, 255));
        btnClear.setBackground(new Color(65, 105, 225));
        btnClear.setBounds(2, 495, 100, 20);
        contentPane.add(btnClear);

        textAreaTotal = new JTextArea();
        textAreaTotal.setEditable(false);
        textAreaTotal.setBounds(1132, 482, 89, 33);
        contentPane.add(textAreaTotal);

        JLabel lblNewLabel_1_4 = new JLabel("Total:");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_4.setBounds(1068, 463, 75, 52);
        contentPane.add(lblNewLabel_1_4);


    }


    public JButton getBtnAdd() {
        return btnAdd;
    }


    public JFrame getFrame() {
        return frame;
    }


    public JTable getTable1() {
        return table1;
    }

    public DefaultTableModel getModel1() {
        return model1;
    }

    public JTable getTable2() {
        return table2;
    }

    public DefaultTableModel getModel2() {
        return model2;
    }


    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }

    public JButton getBtnLogOut() {
        return btnLogOut;
    }

    public JButton getBtnViewResults() {
        return btnViewResults;
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


    public JButton getBtnClear() {
        return btnClear;
    }

    public JTextArea getTextAreaTotal() {
        return textAreaTotal;
    }

    public void setModel1(DefaultTableModel model1) {
        this.model1 = model1;
    }
}
