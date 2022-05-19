package presentation.view.Administrator;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdministratorView extends JFrame {

    private JFrame frame = this;

    private JButton btnLogOut;
    private JButton btnGenerateRaports;
    private JButton btnCreateCompositeProduct;
    private JButton btnViewAllProducts;
    private JButton btnEditBaseProd;
    private JPanel contentPane;

    public AdministratorView() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrator");
        setBounds(100, 100, 492, 450);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnEditBaseProd = new JButton("Edit products");
        btnEditBaseProd.setForeground(new Color(255, 255, 255));
        btnEditBaseProd.setBackground(new Color(65, 105, 225));
        btnEditBaseProd.setBounds(144, 164, 190, 38);
        contentPane.add(btnEditBaseProd);

        btnViewAllProducts = new JButton("View all products");
        btnViewAllProducts.setForeground(new Color(255, 255, 255));
        btnViewAllProducts.setBackground(new Color(65, 105, 225));
        btnViewAllProducts.setBounds(144, 115, 190, 38);
        contentPane.add(btnViewAllProducts);

        btnCreateCompositeProduct = new JButton("Create composite product");
        btnCreateCompositeProduct.setForeground(new Color(255, 255, 255));
        btnCreateCompositeProduct.setBackground(new Color(65, 105, 225));
        btnCreateCompositeProduct.setBounds(144, 213, 190, 38);
        contentPane.add(btnCreateCompositeProduct);

        btnGenerateRaports = new JButton("Generate raports");
        btnGenerateRaports.setForeground(new Color(255, 255, 255));
        btnGenerateRaports.setBackground(new Color(65, 105, 225));
        btnGenerateRaports.setBounds(144, 262, 190, 38);
        contentPane.add(btnGenerateRaports);

        JLabel lblNewLabel = new JLabel("Administrator's account");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(104, 27, 307, 77);
        contentPane.add(lblNewLabel);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setForeground(new Color(255, 255, 255));
        btnLogOut.setBackground(new Color(65, 105, 225));
        btnLogOut.setBounds(191, 311, 89, 38);
        contentPane.add(btnLogOut);

        this.setVisible(true);
        this.setResizable(false);
    }

    public JButton getBtnLogOut() {
        return btnLogOut;
    }

    public JButton getBtnGenerateRaports() {
        return btnGenerateRaports;
    }

    public JButton getBtnCreateCompositeProduct() {
        return btnCreateCompositeProduct;
    }

    public JButton getBtnViewAllProducts() {
        return btnViewAllProducts;
    }

    public JButton getBtnEditBaseProd() {
        return btnEditBaseProd;
    }

    public JFrame getFrame() {
        return frame;
    }
}
