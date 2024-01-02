package scholarship.login;

import scholarship.components.Components;
import scholarship.maintab.MainTabController;
import scholarship.register.RegisterController;
import scholarship.Database.DataController;
import scholarship.studentForm.StudentFormController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginController extends Components implements MouseListener {

    JLabel backgroundImage = new JLabel(loginAndRegisterImage);

    private String password;

    JPanel loginPanel = new JPanel();

    JLabel loginLogo = new JLabel("STUDENT");

    JLabel usernameLb = new JLabel("Username");
    JTextField userTextField = new JTextField();

    JLabel passwordLb = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField();

    JCheckBox showPasswordCb = new JCheckBox();

    JButton loginBtn = new JButton("Login");

    JButton registerBtn = new JButton("Register");



    public LoginController (){

        new MainTabController(); // Display side panel

        // Main panel
        LoginView.addPanel(window, divPanel, 0, 0, 1090, 800, "#EEE2DE");

        /*
        *   sub panel -> login panel
        *   login Logo
        * */
        LoginView.addLabel(loginPanel, loginLogo, 0, 20, 400, 60, 60, true, 1);
        LoginView.addPanelToPanel(divPanel, loginPanel, 650, 20, 400, 520, "#e8f3f4");

        // username
        LoginView.addLabel(loginPanel, usernameLb, 0, 115, 400, 50, 20, true, 0);
        LoginView.addJTextField(loginPanel, userTextField, 45, 140, 300, 50, 20);
        userTextField.addMouseListener(this);

        // password
        LoginView.addLabel(loginPanel, passwordLb, 0, 205, 400, 50, 20, true, 0);
        LoginView.addPasswordField(loginPanel, passwordField, 45, 230, 300, 50, 20);
        passwordField.addMouseListener(this);

        // CheckBox -> Show password
        LoginView.addCheckBox(loginPanel, showPasswordCb, 50, 295);
        showPasswordCb.addMouseListener(this);

        // buttons
        LoginView.addButton(loginPanel, loginBtn, 70, 360, 250, 40, 20, "#83A2FF");
        loginBtn.addMouseListener(this);

        LoginView.addButton(loginPanel, registerBtn, 70, 420, 250, 40, 20, "#83A2FF");
        registerBtn.addMouseListener(this);

        // Background Image
        LoginView.addLabel(divPanel, backgroundImage, 0, -100, 1090, 790, 0, false, 0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        password = new String(passwordField.getPassword());

        if(showPasswordCb.isSelected()) passwordField.setEchoChar((char)0); // Convert to string
        else passwordField.setEchoChar('•'); // Encrypt Password

        /*
        *   Check username, password if empty change Line Color to red to indicate that user need to input username or password
        *
        *   Check username && password if exist in Database
        *
        * */
        if(e.getSource() == loginBtn){

            if (userTextField.getText().isEmpty()) userTextField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            if (password.isEmpty()) passwordField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));

            if( !userTextField.getText().isEmpty() && !password.isEmpty() ) {

                if (DataController.isExistUser(userTextField.getText(), password, "student")){

                    LoginView.removeComponents(window);
                    LoginView.removePanelComponents(divPanel);
                    LoginView.removePanelComponents(sideBarPanel);
                    new StudentFormController( userTextField.getText() );

                } else {
                    JOptionPane.showMessageDialog(null, " Wrong Username and Password ", " Info ", JOptionPane.ERROR_MESSAGE);
                    removeText();
                }

            }

        }


        if(e.getSource() == registerBtn){

            LoginView.removePanelComponents(divPanel);
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
