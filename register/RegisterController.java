package register;

import components.Components;
import login.LoginController;
import Database.DataController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RegisterController extends Components implements MouseListener {

    JLabel registerLogo = new JLabel("Registration");

    JLabel usernameLb = new JLabel("Username");
    JTextField usernameTf = new JTextField();

    JLabel PasswordLb = new JLabel("Password");
    JTextField passwordTf = new JTextField();

    JLabel nameLb = new JLabel("Name");
    JTextField nameTf = new JTextField();

    JLabel lastNameLb = new JLabel("Lastname");
    JTextField lastnameTf = new JTextField();

    JButton registerBtn = new JButton("Register");

    JButton backBtn = new JButton("Back");

    public RegisterController (){

        RegisterView.addPanel(window, loginAndRegisterPanel, 640, 20, 400, 520, "#e8f3f4");

        RegisterView.addLabel(loginAndRegisterPanel, registerLogo, 0, 20, 400, 80, 55, true, 1);


        RegisterView.addLabel(loginAndRegisterPanel, nameLb, 20, 130, 150, 20, 15, true, 0);
        RegisterView.addJTextField(loginAndRegisterPanel, nameTf, 20, 140, 150, 50, 20);
        nameTf.addMouseListener(this);

        RegisterView.addLabel(loginAndRegisterPanel, lastNameLb, 210, 130, 150, 20, 15, true, 0);
        RegisterView.addJTextField(loginAndRegisterPanel, lastnameTf, 210, 140, 150, 50, 20);
        lastnameTf.addMouseListener(this);


        RegisterView.addLabel(loginAndRegisterPanel, usernameLb, 20, 220, 350, 20, 15, true, 0);
        RegisterView.addJTextField(loginAndRegisterPanel, usernameTf, 20, 230, 350, 50, 20);
        usernameTf.addMouseListener(this);

        RegisterView.addLabel(loginAndRegisterPanel, PasswordLb, 20, 290, 350, 20, 15, true, 0);
        RegisterView.addJTextField(loginAndRegisterPanel, passwordTf, 20, 300, 350, 50, 20);
        passwordTf.addMouseListener(this);


        RegisterView.addButton(loginAndRegisterPanel, registerBtn, 80, 380, 250, 40, 20, "#83A2FF");
        registerBtn.addMouseListener(this);

        RegisterView.addButton(loginAndRegisterPanel, backBtn, 80, 440, 250, 40, 20, "#83A2FF");
        backBtn.addMouseListener(this);

    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == registerBtn){

            if (usernameTf.getText().isEmpty()) usernameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            if (passwordTf.getText().isEmpty()) passwordTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            if (nameTf.getText().isEmpty()) nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            if (lastnameTf.getText().isEmpty()) lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));

            if( !usernameTf.getText().isEmpty() && !passwordTf.getText().isEmpty()
                && !nameTf.getText().isEmpty() && !lastnameTf.getText().isEmpty() ){

                if(!DataController.isExistUser(usernameTf.getText())){

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

        RegisterView.removePanelComponents(loginAndRegisterPanel);
        new LoginController();

    }

}
