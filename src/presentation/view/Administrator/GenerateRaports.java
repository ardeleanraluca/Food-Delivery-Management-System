package presentation.view.Administrator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GenerateRaports extends JFrame {

    private JFrame frame = this;
    private JTextField textFieldTime1;
    private JTextField textFieldTime2;
    private JTextField textFieldAmount;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btnBack;

    private  JComboBox comboBoxStartHour;
    private  JComboBox comboBoxEndHour;
    private  JComboBox comboBoxYear;
    private  JComboBox comboBoxMonth;
    private  JComboBox comboBoxDay;

    public GenerateRaports() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrator");
        setBounds(100, 100, 654, 606);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        this.setVisible(true);
        this.setResizable(false);

        btnBack = new JButton("Go Back");
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(65, 105, 225));
        btnBack.setBounds(2, 2, 100, 20);
        contentPane.add(btnBack);

        JLabel lblNewLabel = new JLabel("Generate Raports");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(221, 11, 164, 44);
        contentPane.add(lblNewLabel);

        JLabel lblTimeInterval = new JLabel("-> Time interval of the orders");
        lblTimeInterval.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTimeInterval.setBounds(10, 86, 268, 44);
        contentPane.add(lblTimeInterval);

        btn1 = new JButton("Generate");
        btn1.setForeground(new Color(255, 255, 255));
        btn1.setBackground(new Color(65, 105, 225));
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn1.setBounds(504, 122, 100, 35);
        contentPane.add(btn1);

        JLabel lblTheProductsOrdered = new JLabel("-> The products ordered more than");
        lblTheProductsOrdered.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTheProductsOrdered.setBounds(10, 174, 290, 44);
        contentPane.add(lblTheProductsOrdered);

        textFieldTime1 = new JTextField();
        textFieldTime1.setColumns(10);
        textFieldTime1.setBounds(296, 185, 67, 29);
        contentPane.add(textFieldTime1);

        JLabel lblTimes = new JLabel("times");
        lblTimes.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTimes.setBounds(371, 179, 79, 35);
        contentPane.add(lblTimes);

        JLabel lblTheClientsThat = new JLabel("-> The clients that have ordered more than ");
        lblTheClientsThat.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTheClientsThat.setBounds(10, 243, 353, 44);
        contentPane.add(lblTheClientsThat);

        textFieldTime2 = new JTextField();
        textFieldTime2.setColumns(10);
        textFieldTime2.setBounds(347, 254, 67, 29);
        contentPane.add(textFieldTime2);

        JLabel lblTimes_1 = new JLabel("times");
        lblTimes_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTimes_1.setBounds(424, 248, 79, 35);
        contentPane.add(lblTimes_1);

        JLabel lblAndThe = new JLabel("and the value of the order was higher than");
        lblAndThe.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblAndThe.setBounds(10, 298, 338, 44);
        contentPane.add(lblAndThe);

        textFieldAmount = new JTextField();
        textFieldAmount.setColumns(10);
        textFieldAmount.setBounds(347, 309, 67, 29);
        contentPane.add(textFieldAmount);

        JLabel lblTimes_1_1 = new JLabel("RON");
        lblTimes_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTimes_1_1.setBounds(424, 298, 79, 44);
        contentPane.add(lblTimes_1_1);

        JLabel lblTheProducts = new JLabel("-> The products ordered within a specified day");
        lblTheProducts.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTheProducts.setBounds(10, 357, 404, 44);
        contentPane.add(lblTheProducts);

        btn2 = new JButton("Generate");
        btn2.setForeground(new Color(255, 255, 255));
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn2.setBackground(new Color(65, 105, 225));
        btn2.setBounds(504, 188, 100, 35);
        contentPane.add(btn2);

        btn3 = new JButton("Generate");
        btn3.setForeground(new Color(255, 255, 255));
        btn3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn3.setBackground(new Color(65, 105, 225));
        btn3.setBounds(504, 303, 100, 35);
        contentPane.add(btn3);

        btn4 = new JButton("Generate");
        btn4.setForeground(new Color(255, 255, 255));
        btn4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn4.setBackground(new Color(65, 105, 225));
        btn4.setBounds(504, 402, 100, 35);
        contentPane.add(btn4);

        comboBoxStartHour = new JComboBox();
        comboBoxStartHour.setBackground(new Color(255, 255, 255));
        comboBoxStartHour.setMaximumRowCount(25);
        comboBoxStartHour.setModel(new DefaultComboBoxModel(new String[]{"Start Hour", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        comboBoxStartHour.setBounds(31, 130, 85, 22);
        contentPane.add(comboBoxStartHour);

        comboBoxEndHour = new JComboBox();
        comboBoxEndHour.setBackground(new Color(255, 255, 255));
        comboBoxEndHour.setModel(new DefaultComboBoxModel(new String[]{"End Hour", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        comboBoxEndHour.setMaximumRowCount(25);
        comboBoxEndHour.setBounds(164, 130, 85, 22);
        contentPane.add(comboBoxEndHour);

        comboBoxYear = new JComboBox();
        comboBoxYear.setBackground(new Color(255, 255, 255));
        comboBoxYear.setModel(new DefaultComboBoxModel(new String[]{"Year", "2022", "2021", "2020", "2019", "2018", "2017"}));
        comboBoxYear.setMaximumRowCount(10);
        comboBoxYear.setBounds(48, 412, 79, 22);
        contentPane.add(comboBoxYear);

        comboBoxMonth = new JComboBox();
        comboBoxMonth.setBackground(new Color(255, 255, 255));
        comboBoxMonth.setModel(new DefaultComboBoxModel(new String[]{"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
        comboBoxMonth.setMaximumRowCount(13);
        comboBoxMonth.setBounds(159, 412, 79, 22);
        contentPane.add(comboBoxMonth);

        comboBoxDay = new JComboBox();
        comboBoxDay.setBackground(new Color(255, 255, 255));
        comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        comboBoxDay.setMaximumRowCount(32);
        comboBoxDay.setBounds(269, 412, 79, 22);
        contentPane.add(comboBoxDay);


    }


    public JTextField getTextFieldTime1() {
        return textFieldTime1;
    }

    public JTextField getTextFieldTime2() {
        return textFieldTime2;
    }

    public JTextField getTextFieldAmount() {
        return textFieldAmount;
    }

    public JButton getBtn1() {
        return btn1;
    }

    public JButton getBtn2() {
        return btn2;
    }

    public JButton getBtn3() {
        return btn3;
    }

    public JButton getBtn4() {
        return btn4;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JComboBox getComboBoxStartHour() {
        return comboBoxStartHour;
    }

    public JComboBox getComboBoxEndHour() {
        return comboBoxEndHour;
    }

    public JComboBox getComboBoxYear() {
        return comboBoxYear;
    }

    public JComboBox getComboBoxMonth() {
        return comboBoxMonth;
    }

    public JComboBox getComboBoxDay() {
        return comboBoxDay;
    }
}
