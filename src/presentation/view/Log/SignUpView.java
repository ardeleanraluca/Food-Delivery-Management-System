package presentation.view.Log;

import javax.swing.*;
import java.awt.*;

public class SignUpView extends JFrame {

    private JFrame frame = this;

    private Container container;
    private JLabel userLabel;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JTextField userTextField;
    private JTextField passwordField;
    private JButton signUpButton;
    private JTextField nameTextField;
    private JTextField confirmPasswordField;
    private JButton btnBack;


    public SignUpView() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sign Up");
        setBounds(100, 100, 400, 300);

        container = getContentPane();
        container.setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);
        nameLabel = new JLabel("NAME");
        userLabel = new JLabel("USERNAME");
        userTextField = new JTextField();
        nameTextField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        signUpButton = new JButton("SIGN UP");
        signUpButton.setForeground(new Color(255, 255, 255));
        signUpButton.setBackground(new Color(65, 105, 225));


        userLabel.setBounds(66, 68, 100, 30);
        nameLabel.setBounds(66, 27, 100, 30);
        nameTextField.setBounds(200, 27, 150, 30);
        userTextField.setBounds(200, 68, 150, 30);
        passwordField.setBounds(200, 109, 150, 30);
        confirmPasswordField.setBounds(200, 150, 150, 30);
        signUpButton.setBounds(246, 199, 100, 30);

        btnBack = new JButton("Go Back");
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(65, 105, 225));
        btnBack.setBounds(2, 2, 100, 20);
        container.add(btnBack);

        container.add(userLabel);
        container.add(nameLabel);
        container.add(confirmPasswordField);
        container.add(userTextField);
        container.add(passwordField);
        container.add(signUpButton);
        container.add(userTextField);
        container.add(nameTextField);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setBounds(66, 109, 100, 30);
        getContentPane().add(lblPassword);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(66, 150, 120, 30);
        getContentPane().add(lblConfirmPassword);

        this.setVisible(true);
        this.setResizable(false);

    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JTextField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JFrame getFrame() {
        return frame;
    }
}
