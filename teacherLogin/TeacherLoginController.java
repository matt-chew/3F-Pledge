package scholarship.teacherLogin;

import scholarship.adminMainTab.AdminMainTabController;
import scholarship.components.Components;
import scholarship.Database.DataController;
import scholarship.scolarshipApplicant.ScholarshipController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeacherLoginController extends Components implements MouseListener {

    JLabel backgroundImage = new JLabel(loginAndRegisterImage);

    private String password;

    JPanel teacherPanel = new JPanel();

    JLabel loginLogo = new JLabel("TEACHER");

    JLabel usernameLb = new JLabel("Username");
    JTextField userTextField = new JTextField();

    JLabel passwordLb = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField();

    JCheckBox showPasswordCb = new JCheckBox();

    JButton loginBtn = new JButton("Login");

    



    public TeacherLoginController (){

        // main panel
        TeacherLoginView.addPanel(window, divPanel, 0, 0, 1090, 800, "#EEE2DE");

        // sub panel
        TeacherLoginView.addPanelToPanel(divPanel, teacherPanel, 650, 20, 400, 520, "#e8f3f4");

        // Login Header
        TeacherLoginView.addLabel(teacherPanel, loginLogo, 0, 20, 400, 60, 60, true, 1);

        // Login Username Input
        TeacherLoginView.addLabel(teacherPanel, usernameLb, 0, 115, 400, 50, 20, true, 0);
        TeacherLoginView.addJTextField(teacherPanel, userTextField, 45, 140, 300, 50, 20);
        userTextField.addMouseListener(this);

        // Login Password Input
        TeacherLoginView.addLabel(teacherPanel, passwordLb, 0, 205, 400, 50, 20, true, 0);
        TeacherLoginView.addPasswordField(teacherPanel, passwordField, 45, 230, 300, 50, 20);
        passwordField.addMouseListener(this);

        // Show password
        TeacherLoginView.addCheckBox(teacherPanel, showPasswordCb, 50, 295);
        showPasswordCb.addMouseListener(this);

        // login Button
        TeacherLoginView.addButton(teacherPanel, loginBtn, 70, 360, 250, 40, 20, "#83A2FF");
        loginBtn.addMouseListener(this);

        // Background Image
        TeacherLoginView.addLabel(divPanel, backgroundImage, 0, -100, 1090, 790, 0, false, 0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        // get password
        password = new String(passwordField.getPassword());

        // convert password -> String
        if(showPasswordCb.isSelected()) passwordField.setEchoChar((char)0);
        else passwordField.setEchoChar('•'); // hide password


        if(e.getSource() == loginBtn){

            // Check username & password if is Empty and Change Color to red Line
            if (userTextField.getText().isEmpty()) userTextField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            if (password.isEmpty()) passwordField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));

            // check username && password if not empty
            if( !userTextField.getText().isEmpty() && !password.isEmpty() ) {

                // Admin Window static -> username && Password
                if (userTextField.getText().equals("@Admin") && password.equals("admin123")){

                    TeacherLoginView.removeComponents(window);
                    TeacherLoginView.removePanelComponents(divPanel);
                    TeacherLoginView.removePanelComponents(sideBarPanel);
                    new AdminMainTabController();

                    /*
                    *   Check username And password if exist in Database
                    *
                    *   Teacher Build-in Account Username -> @AdminT  Password -> adminT123
                    *
                    * */
                } else if (DataController.isExistUser(userTextField.getText(), password, "teacher") || userTextField.getText().equals("@AdminT") && password.equals("adminT123") ){

                    TeacherLoginView.removeComponents(window);
                    TeacherLoginView.removePanelComponents(divPanel);
                    TeacherLoginView.removePanelComponents(sideBarPanel);

                    new ScholarshipController();

                } else {

                    // Pop-up Warning Message
                    JOptionPane.showMessageDialog(null, " Wrong Username and Password ", " Info ", JOptionPane.ERROR_MESSAGE);
                    removeText();
                }

            }

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

    }

    void removeText (){

        userTextField.setText(null);
        passwordField.setText(null);

    }

}
