package presentation.controller;

import Start.Start;
import bll.DeliveryService;
import bll.User;
import bll.UserType;
import presentation.view.Administrator.AdministratorView;
import presentation.view.Client.ClientView;
import presentation.view.Employee.EmployeeView;
import presentation.view.Log.LogInView;
import presentation.view.Log.SignUpView;

import javax.swing.*;

public class LogInController {

    public void Initialize(LogInView logInView) {

        logInView.getLoginButton().addActionListener(e12 -> {
            DeliveryService deliveryService = Start.getDeliveryService();

            String username = logInView.getUserTextField().getText();
            String password = logInView.getPasswordField().getText();

            if (username.equals("")) {
                JOptionPane.showMessageDialog(logInView.getFrame(), "Username field is empty");

                return;
            }

            if (password.equals("")) {
                JOptionPane.showMessageDialog(logInView.getFrame(), "Password field is empty");
                return;
            }

            if (deliveryService.findUsername(username) != null) {
                if (deliveryService.logInUser(username, password) == null) {
                    JOptionPane.showMessageDialog(logInView.getFrame(), "Password incorrect!");
                    logInView.getPasswordField().setText("");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(logInView.getFrame(), "Username doesn't exist. Please sign up!");
                logInView.getPasswordField().setText("");
                logInView.getUserTextField().setText("");
                return;
            }

            User user = deliveryService.logInUser(username, password);

            if (user.getUserType().equals(UserType.CLIENT)) {
                logInView.getPasswordField().setText("");
                logInView.getUserTextField().setText("");
                ClientController clientController = new ClientController();
                ClientView clientView = new ClientView();
                clientController.setUser(user);
                clientController.Initialize(clientView);


            } else if (user.getUserType().equals(UserType.ADMINISTRATOR)) {
                logInView.getPasswordField().setText("");
                logInView.getUserTextField().setText("");
                AdministratorController administratorController = new AdministratorController();
                AdministratorView administratorView = new AdministratorView();
                administratorController.Initialize(administratorView);
            } else if (user.getUserType().equals(UserType.EMPLOYEE)) {
                logInView.getPasswordField().setText("");
                logInView.getUserTextField().setText("");
                EmployeeView employeeView = new EmployeeView();
                Start.getDeliveryService().addObserver(employeeView);

            }


        });

        logInView.getSignUpButton().addActionListener(e12 -> {
            logInView.getFrame().dispose();
            SignUpView signUpView = new SignUpView();

            signUpView.getSignUpButton().addActionListener(e -> {
                logInView.getFrame().show();
                String name = signUpView.getNameTextField().getText();
                String username = signUpView.getUserTextField().getText();
                String password = signUpView.getPasswordField().getText();
                String passwordConfirm = signUpView.getConfirmPasswordField().getText();

                if (name.equals("")) {
                    JOptionPane.showMessageDialog(signUpView.getFrame(), "Please insert a name");
                    return;
                }

                if (new DeliveryService().findUsername(username) != null) {
                    JOptionPane.showMessageDialog(signUpView.getFrame(), "Username already exist. Choose another!");
                    return;
                }

                if (password.equals("") || passwordConfirm.equals("")) {
                    JOptionPane.showMessageDialog(signUpView.getFrame(), "Please insert and confirm password");
                    return;
                }

                if (!password.equals(passwordConfirm)) {
                    JOptionPane.showMessageDialog(signUpView.getFrame(), "Passwords didn’t match. Try again.");
                    signUpView.getPasswordField().setText("");
                    signUpView.getConfirmPasswordField().setText("");
                    return;
                }

                signUpView.getFrame().dispose();

                DeliveryService deliveryService = Start.getDeliveryService();
                User newUser = new User(name, username, password, UserType.CLIENT);
                deliveryService.signUpClient(newUser);
                deliveryService.serializeAll();

                ClientController clientController = new ClientController();
                ClientView clientView = new ClientView();
                clientController.setUser(newUser);
                clientController.Initialize(clientView);
            });

            signUpView.getBtnBack().addActionListener(e -> {
                signUpView.getFrame().dispose();
                LogInController logInController = new LogInController();
                LogInView log = new LogInView();
                logInController.Initialize(log);

            });

        });

    }
}
