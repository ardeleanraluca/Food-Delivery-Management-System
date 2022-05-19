package presentation.view.Administrator;

import Start.Start;
import bll.DeliveryService;
import presentation.Table;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewAll extends JFrame {
    private JButton btnSearch;
    private JTextField textFieldSearch;
    private JFrame frame = this;
    private JTable table;
    private JButton back;

    public ViewAll() {
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrator");
        setBounds(100, 100, 983, 652);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        back = new JButton("Go Back");
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(65, 105, 225));
        back.setBounds(2, 2, 100, 20);
        contentPane.add(back);


        JLabel lblNewLabel = new JLabel("All Products");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(399, 0, 201, 57);
        contentPane.add(lblNewLabel);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(47, 104, 875, 489);
        contentPane.add(scrollPane);

        textFieldSearch = new JTextField();
        textFieldSearch.setBounds(47, 66, 222, 27);
        contentPane.add(textFieldSearch);
        textFieldSearch.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setBounds(47, 45, 67, 14);
        contentPane.add(lblNewLabel_1);

        btnSearch = new JButton("Search");
        btnSearch.setForeground(new Color(255, 255, 255));
        btnSearch.setBackground(new Color(65, 105, 225));
        btnSearch.setBounds(287, 66, 89, 27);
        contentPane.add(btnSearch);


        table = Table.createTable(Start.getDeliveryService().getMenuItems(), 0);
        scrollPane.setViewportView(table);

        this.setVisible(true);
        this.setResizable(false);
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getBack() {
        return back;
    }

    public JTextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }
}
