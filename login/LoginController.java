package login;

import components.Components;
import register.RegisterController;
import Database.DataController;
import maintab.MainTabController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginController extends Components implements MouseListener {

    private String password;

    JLabel loginLogo = new JLabel("LOGIN");

    JLabel usernameLb = new JLabel("Username");
    JTextField userTextField = new JTextField();

    JLabel passwordLb = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField();

    JCheckBox showPasswordCb = new JCheckBox();

    JButton loginBtn = new JButton("Login");

    JButton registerBtn = new JButton("Register");



    public LoginController (){

        LoginView.addPanel(window, loginAndRegisterPanel, 640, 20, 400, 520, "#e8f3f4");

        LoginView.addLabel(loginAndRegisterPanel, loginLogo, 0, 20, 400, 60, 60, true, 1);

        LoginView.addLabel(loginAndRegisterPanel, usernameLb, 0, 115, 400, 50, 20, true, 0);
        LoginView.addJTextField(loginAndRegisterPanel, userTextField, 45, 140, 300, 50, 20);
        userTextField.addMouseListener(this);

        LoginView.addLabel(loginAndRegisterPanel, passwordLb, 0, 205, 400, 50, 20, true, 0);
        LoginView.addPasswordField(loginAndRegisterPanel, passwordField, 45, 230, 300, 50, 20);
        passwordField.addMouseListener(this);

        LoginView.addCheckBox(loginAndRegisterPanel, showPasswordCb, 50, 295);
        showPasswordCb.addMouseListener(this);

        LoginView.addButton(loginAndRegisterPanel, loginBtn, 70, 360, 250, 40, 20, "#83A2FF");
        loginBtn.addMouseListener(this);

        LoginView.addButton(loginAndRegisterPanel, registerBtn, 70, 420, 250, 40, 20, "#83A2FF");
        registerBtn.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        password = new String(passwordField.getPassword());

        if(showPasswordCb.isSelected()) passwordField.setEchoChar((char)0);
        else passwordField.setEchoChar('•');


        if(e.getSource() == loginBtn){

            if (userTextField.getText().isEmpty()) userTextField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            if (password.isEmpty()) passwordField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));

            if( !userTextField.getText().isEmpty() && !password.isEmpty() ) {

                if (DataController.isExistUser(userTextField.getText(), password)){

                    LoginView.removeComponents(window);
                    new MainTabController();

                } else {
                    JOptionPane.showMessageDialog(null, " Wrong Username and Password ", " Info ", JOptionPane.ERROR_MESSAGE);
                    removeText();
                }

            }

        }


        if(e.getSource() == registerBtn){

            LoginView.removePanelComponents(loginAndRegisterPanel);
            new RegisterController();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        password = new String(passwordField.getPassword());

        if(e.getSource() == loginBtn){
            loginBtn.setBounds(45, 355, 300, 50);
            loginBtn.setFont(new Font("Roboto", Font.PLAIN, 40));
        }

        if(e.getSource() == registerBtn){
            registerBtn.setBounds(45, 415, 300, 50);
            registerBtn.setFont(new Font("Roboto", Font.PLAIN, 40));
        }

        if(!password.isEmpty()) passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#30cb00")));
        else passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

        if(!userTextField.getText().isEmpty()) userTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#30cb00")));
        else userTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if(e.getSource() == loginBtn){
            loginBtn.setBounds(70, 360, 250, 40);
            loginBtn.setFont(new Font("Monospace", Font.PLAIN, 20));
        }

        if(e.getSource() == registerBtn){
            registerBtn.setBounds(70, 420, 250, 40);
            registerBtn.setFont(new Font("Monospace", Font.PLAIN, 20));
        }

    }

    void removeText (){

        userTextField.setText(null);
        passwordField.setText(null);

    }

}
