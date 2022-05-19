package presentation.view.Log;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LogInView extends JFrame {

    private JFrame frame = this;

    private JPanel contentPane;

    private JTextField userTextField;
    private JTextField passwordField;
    private JButton loginButton;
    private JButton signUpButton;


    public LogInView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Log In");

        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel userLabel = new JLabel("USERNAME");
        JLabel passwordLabel = new JLabel("PASSWORD");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("LOG IN");
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(65, 105, 225));
        signUpButton = new JButton("SIGN UP");
        signUpButton.setForeground(new Color(255, 255, 255));
        signUpButton.setBackground(new Color(65, 105, 225));


        userLabel.setBounds(66, 27, 100, 30);
        passwordLabel.setBounds(66, 68, 100, 30);
        userTextField.setBounds(166, 27, 150, 30);
        passwordField.setBounds(166, 68, 150, 30);
        loginButton.setBounds(66, 148, 100, 30);
        signUpButton.setBounds(216, 148, 100, 30);

        contentPane.add(userLabel);
        contentPane.add(passwordLabel);
        contentPane.add(userTextField);
        contentPane.add(passwordField);
        contentPane.add(loginButton);
        contentPane.add(signUpButton);

        this.setVisible(true);
        this.setResizable(false);
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }


    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JFrame getFrame() {
        return frame;
    }
}
