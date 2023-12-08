package register;

import components.Components;
import login.LoginController;

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

        RegisterView.addPanel(window, loginAndRegisterPanel, 100, 20, 900, 520, "#e8f3f4");

        RegisterView.addLabel(loginAndRegisterPanel, registerLogo, 0, 20, 900, 80, 55, true, 1);


        RegisterView.addLabel(loginAndRegisterPanel, usernameLb, 80, 115, 300, 50, 20, true, 0);
        RegisterView.addJTextField(loginAndRegisterPanel, usernameTf, 80, 140, 300, 50, 20);
        usernameTf.addMouseListener(this);

        RegisterView.addLabel(loginAndRegisterPanel, PasswordLb, 80, 235, 300, 50, 20, true, 0);
        RegisterView.addJTextField(loginAndRegisterPanel, passwordTf, 80, 260, 300, 50, 20);
        passwordTf.addMouseListener(this);


        RegisterView.addLabel(loginAndRegisterPanel, nameLb, 510, 115, 300, 50, 20, true, 0);
        RegisterView.addJTextField(loginAndRegisterPanel, nameTf, 510, 140, 300, 50, 20);
        nameTf.addMouseListener(this);

        RegisterView.addLabel(loginAndRegisterPanel, lastNameLb, 510, 235, 300, 50, 20, true, 0);
        RegisterView.addJTextField(loginAndRegisterPanel, lastnameTf, 510, 260, 300, 50, 20);
        lastnameTf.addMouseListener(this);


        RegisterView.addButton(loginAndRegisterPanel, registerBtn, 325, 360, 250, 40, 20, "#83A2FF");
        registerBtn.addMouseListener(this);

        RegisterView.addButton(loginAndRegisterPanel, backBtn, 325, 415, 250, 40, 20, "#83A2FF");
        backBtn.addMouseListener(this);

    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == registerBtn){


        }

        if(e.getSource() == backBtn){

            RegisterView.removePanelComponents(loginAndRegisterPanel);
            new LoginController();

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
            registerBtn.setBounds(300, 360, 300, 50);
            registerBtn.setFont(new Font("Roboto", Font.PLAIN, 40));
        }

        if (e.getSource() == backBtn) {
            backBtn.setBounds(300, 415, 300, 50);
            backBtn.setFont(new Font("Roboto", Font.PLAIN, 40));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if(e.getSource() == registerBtn){
            registerBtn.setBounds(325, 360, 250, 40);
            registerBtn.setFont(new Font("Monospace", Font.PLAIN, 20));
        }

        if(e.getSource() == backBtn){
            backBtn.setBounds(325, 415, 250, 40);
            backBtn.setFont(new Font("Monospace", Font.PLAIN, 20));
        }

    }

}
