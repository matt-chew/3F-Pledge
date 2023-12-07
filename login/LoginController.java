package login;

import components.Components;

import javax.swing.*;


public class LoginController extends Components {

    JLabel loginLogo = new JLabel("LOGIN");

    JLabel usernameLb = new JLabel("Username");
    JTextField loginTextField = new JTextField();

    JLabel passwordLb = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField();

    JCheckBox showPasswordCb = new JCheckBox();

    JButton loginBtn = new JButton("Login");

    JButton registerBtn = new JButton("Register");

    public LoginController (){

        LoginView.addPanel(window, loginAndRegisterPanel, 640, 20, 400, 520, "#346eeb");

        LoginView.addLabel(loginAndRegisterPanel, loginLogo, 0, 20, 400, 60, 60, true, 1);

        LoginView.addLabel(loginAndRegisterPanel, usernameLb, 0, 115, 400, 50, 20, true, 0);
        LoginView.addJTextField(loginAndRegisterPanel, loginTextField, 45, 140, 300, 50, 20);

        LoginView.addLabel(loginAndRegisterPanel, passwordLb, 0, 205, 400, 50, 20, true, 0);
        LoginView.addPasswordField(loginAndRegisterPanel, passwordField, 45, 230, 300, 50, 20);

        LoginView.addCheckBox(loginAndRegisterPanel, showPasswordCb, 50, 295);

        // LoginView.addButton(loginAndRegisterPanel);

    }
}
