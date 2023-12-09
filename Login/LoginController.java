package PledgeSystem.Login;

import PledgeSystem.Components.Components;
import PledgeSystem.Register.RegisterController;
import PledgeSystem.Database.DataController;
import PledgeSystem.Dashboard.DashboardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginController extends Components implements ActionListener{

    private String password;

    JLabel signInLogo = new JLabel("Sign In");
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel signUpText = new JLabel("No Account?");

    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    JCheckBox showPass = new JCheckBox();


    public LoginController(){
        //Sign In Text
        LoginView.addPanel(window, infoPanel, 700, 0, 400, 600, "#202020");
        LoginView.addLabel(infoPanel, signInLogo, 150, 45, 100, 36, 30, false);

        //Username
        LoginView.addLabel(infoPanel, usernameLabel, 50, 165, 100, 18, 20, false);
        LoginView.addTextField(infoPanel, userTextField, 50, 195, 300, 40, 20);
        userTextField.addActionListener(this);
        //Password
        LoginView.addLabel(infoPanel, passwordLabel, 50, 257, 100, 18, 20, false);
        LoginView.addPasswordField(infoPanel, passwordField, 50, 282, 300, 50, 20);
        passwordField.addActionListener(this);
        //addCheckBox
        LoginView.addCheckBox(infoPanel, showPass, 50, 360);
        showPass.addActionListener(this);

        //Login Button
        LoginView.addButton(infoPanel, loginButton, 100, 415, 200, 50, 20, "#1D6EBA");
        loginButton.addActionListener(this);
        //SignUp Button
        LoginView.addLabel(infoPanel, signUpText, 111, 496, 85, 17, 14, false);
        LoginView.addButton(infoPanel, registerButton, 209, 490, 80, 30, 14, "#1D6EBA");
        registerButton.addActionListener(this);

    }

@Override
    public void actionPerformed(ActionEvent e){

        password = new String(passwordField.getPassword());

        if(e.getSource() == loginButton){
            if(!userTextField.getText().isEmpty() && !password.isEmpty()) {
                if(DataController.isExistUser(userTextField.getText(), password)){

                    LoginView.removePanelComponents(infoPanel);
                    window.remove(infoPanel);

                    System.out.println("Login Successful");
                    new DashboardController();

                }else{
                    JOptionPane.showMessageDialog(null, " Wrong Username and Password ", " Info ", JOptionPane.ERROR_MESSAGE);
                    removeText();
                }
            }
        }

        if(e.getSource() == registerButton){

            LoginView.removePanelComponents(infoPanel);
            new RegisterController();
        }

        if(showPass.isSelected()) passwordField.setEchoChar((char)0);
        else passwordField.setEchoChar('•');
    }

    void removeText(){

        userTextField.setText(null);
        passwordField.setText(null);
    }

}
