package presentation.view.Administrator;

import bll.DeliveryService;
import presentation.Table;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CreateCompositeProduct extends JFrame {

    private JFrame frame = this;
    private JTextField name;

    private JTable table1;
    private JTable table2;
    private JButton backBtn;
    private JButton btnCreate;
    private JButton btnAdd;
    private JButton btnRemove;

    private DefaultTableModel model1;
    private DefaultTableModel model2;


    public CreateCompositeProduct() {
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrator");
        setBounds(100, 100, 1169, 625);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 72, 586, 442);
        contentPane.add(scrollPane);


        DeliveryService deliveryService = new DeliveryService();
        table1 = Table.createTable(deliveryService.getMenuItems(),1);
        model1 = (DefaultTableModel) table1.getModel();
        scrollPane.setViewportView(table1);

        JLabel lblNewLabel = new JLabel("Create Composite Product");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
        lblNewLabel.setBounds(358, 2, 449, 59);
        contentPane.add(lblNewLabel);

        this.setVisible(true);
        this.setResizable(false);

        backBtn = new JButton("Go Back");
        backBtn.setForeground(new Color(255, 255, 255));
        backBtn.setBackground(new Color(65, 105, 225));
        backBtn.setBounds(2, 2, 100, 20);
        contentPane.add(backBtn);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(606, 135, 539, 379);
        contentPane.add(scrollPane_1);

        String[] columns = {"Name", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        model2 = new DefaultTableModel(columns, 0);
        table2 = new JTable(model2);
        scrollPane_1.setViewportView(table2);

        btnAdd = new JButton("ADD");
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(65, 105, 225));
        btnAdd.setBounds(507, 525, 89, 23);
        contentPane.add(btnAdd);

        btnCreate = new JButton("CREATE");
        btnCreate.setForeground(new Color(255, 255, 255));
        btnCreate.setBackground(new Color(65, 105, 225));
        btnCreate.setBounds(1056, 525, 89, 23);
        contentPane.add(btnCreate);

        JLabel lblNewLabel_1 = new JLabel("Base Products");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 51, 112, 14);
        contentPane.add(lblNewLabel_1);


        btnRemove = new JButton("Remove");
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setBackground(new Color(65, 105, 225));
        btnRemove.setBounds(957, 525, 89, 23);
        contentPane.add(btnRemove);

        JLabel lblNewLabel_2 = new JLabel("Name");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(606, 71, 49, 14);
        contentPane.add(lblNewLabel_2);

        name = new JTextField();
        name.setBounds(606, 92, 283, 32);
        contentPane.add(name);
        name.setColumns(10);

        setVisible(true);
        this.setResizable(false);

    }

    public JTable getTable1() {
        return table1;
    }

    public JTable getTable2() {
        return table2;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public JFrame getFrame() {
        return frame;
    }

    public DefaultTableModel getModel1() {
        return model1;
    }

    public DefaultTableModel getModel2() {
        return model2;
    }


    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }


    public JTextField getNameField() {
        return name;
    }
}


