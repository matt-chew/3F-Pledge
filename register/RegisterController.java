package scholarship.register;

import scholarship.components.Components;
import scholarship.login.LoginController;
import scholarship.Database.DataController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RegisterController extends Components implements MouseListener {

    // Background Image
    JLabel backgroundImage = new JLabel(loginAndRegisterImage);

    // Register Panel
    JLabel registerLogo = new JLabel("Registration");
    JPanel registerPanel = new JPanel();

    // Username
    JLabel usernameLb = new JLabel("Username");
    JTextField usernameTf = new JTextField();

    // Password
    JLabel PasswordLb = new JLabel("Password");
    JTextField passwordTf = new JTextField();

    // Name
    JLabel nameLb = new JLabel("Name");
    JTextField nameTf = new JTextField();

    // Lastname
    JLabel lastNameLb = new JLabel("Lastname");
    JTextField lastnameTf = new JTextField();

    // buttons
    JButton registerBtn = new JButton("Register");
    JButton backBtn = new JButton("Back");

    public RegisterController (){

        // Main Panel
        RegisterView.addPanel(window, divPanel, 0, 0, 1090, 800, "#EEE2DE");

        /*
        *   sub Panel -> RegisterPanel
        *   Register Logo
        * */
        RegisterView.addPanelToPanel(divPanel, registerPanel, 650, 20, 400, 520, "#e8f3f4");
        RegisterView.addLabel(registerPanel, registerLogo, 0, 20, 400, 80, 55, true, 1);

        // Name && NameLabel
        RegisterView.addLabel(registerPanel, nameLb, 20, 130, 150, 20, 15, true, 0);
        RegisterView.addJTextField(registerPanel, nameTf, 20, 140, 150, 50, 20);
        nameTf.addMouseListener(this);

        // Lastname && LastnameLabel
        RegisterView.addLabel(registerPanel, lastNameLb, 210, 130, 150, 20, 15, true, 0);
        RegisterView.addJTextField(registerPanel, lastnameTf, 210, 140, 150, 50, 20);
        lastnameTf.addMouseListener(this);

        // Username && UsernameLabel
        RegisterView.addLabel(registerPanel, usernameLb, 20, 220, 350, 20, 15, true, 0);
        RegisterView.addJTextField(registerPanel, usernameTf, 20, 230, 350, 50, 20);
        usernameTf.addMouseListener(this);

        // Password && PasswordLabel
        RegisterView.addLabel(registerPanel, PasswordLb, 20, 290, 350, 20, 15, true, 0);
        RegisterView.addJTextField(registerPanel, passwordTf, 20, 300, 350, 50, 20);
        passwordTf.addMouseListener(this);

        // Buttons
        RegisterView.addButton(registerPanel, registerBtn, 80, 380, 250, 40, 20, "#83A2FF");
        registerBtn.addMouseListener(this);

        RegisterView.addButton(registerPanel, backBtn, 80, 440, 250, 40, 20, "#83A2FF");
        backBtn.addMouseListener(this);

        // Background Image
        RegisterView.addLabel(divPanel, backgroundImage, 0, -100, 1090, 790, 0, false, 0);

    }


    @Override
    public void mouseClicked(MouseEvent e) {

        /*
        *   Check username, password, name, lastname if empty Change Line Color to Red to indicate the user to write info
        *
        *   Verify the username in the database to see if there is a duplicate and then display a pop-up alert advising you to change it.
        *   Store Account Details to Database and then display pop-up that account successfully created
        *   Redirect to log-in panel
        *
        * */
        if(e.getSource() == registerBtn){

            if (usernameTf.getText().isEmpty()) usernameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            if (passwordTf.getText().isEmpty()) passwordTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            if (nameTf.getText().isEmpty()) nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            if (lastnameTf.getText().isEmpty()) lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));

            if( !usernameTf.getText().isEmpty() && !passwordTf.getText().isEmpty()
                && !nameTf.getText().isEmpty() && !lastnameTf.getText().isEmpty() ){

                if(!DataController.isExistUser(usernameTf.getText(), "student")){

                    DataController.inputDataToFile( usernameTf.getText(), passwordTf.getText(),
                                                    nameTf.getText(), lastnameTf.getText() );

                    removeText();
                    JOptionPane.showMessageDialog(null, " Successfully Created Account ", " Successful ", JOptionPane.INFORMATION_MESSAGE);
                    backToLoginPage();

                } else {
                    JOptionPane.showMessageDialog(null, " Username Already Taken ", " Info ", JOptionPane.ERROR_MESSAGE);
                    usernameTf.setText(null);
                    usernameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
                }

            }

        }

        if(e.getSource() == backBtn){

            RegisterView.removePanelComponents(divPanel);
            backToLoginPage();

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


        // change style if mouse hover the button
        if (!usernameTf.getText().isEmpty()) usernameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#30cb00")));
        else usernameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));

        if (!passwordTf.getText().isEmpty()) passwordTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#30cb00")));
        else passwordTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));

        if (!nameTf.getText().isEmpty()) nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#30cb00")));
        else nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));

        if (!lastnameTf.getText().isEmpty()) lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#30cb00")));
        else lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));



        if (e.getSource() == registerBtn) {

            registerBtn.setBounds(75, 375, 260, 50);
            registerBtn.setFont(new Font("Roboto", Font.PLAIN, 40));

        }

        if (e.getSource() == backBtn) {

            backBtn.setBounds(75, 435, 260, 50);
            backBtn.setFont(new Font("Roboto", Font.PLAIN, 40));

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        // change style if mouse hover the button
        if(e.getSource() == registerBtn){

            registerBtn.setBounds(80, 380, 250, 40);
            registerBtn.setFont(new Font("Monospace", Font.PLAIN, 20));

        }

        if(e.getSource() == backBtn){

            backBtn.setBounds(80, 440, 250, 40);
            backBtn.setFont(new Font("Monospace", Font.PLAIN, 20));

        }

    }

    void removeText (){

        usernameTf.setText(null);
        passwordTf.setText(null);
        nameTf.setText(null);
        lastnameTf.setText(null);

    }

    void backToLoginPage (){

        RegisterView.removePanelComponents(divPanel);
        new LoginController();

    }

}
