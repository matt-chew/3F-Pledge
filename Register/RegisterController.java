package PledgeSystem.Register;

import PledgeSystem.Components.Components;
import PledgeSystem.Login.LoginController;
import PledgeSystem.Database.DataController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RegisterController extends Components implements ActionListener{

    JLabel signUpText = new JLabel("Create Your Account");
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel firstNameLabel = new JLabel("Name");
    JLabel lastNameLabel = new JLabel("Lastname");

    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    JTextField firstNameTextField = new JTextField();
    JTextField lastNameTextField = new JTextField();

    JButton signUpButton = new JButton("Register");
    JButton cancelButton = new JButton("Back");

    public RegisterController (){
        //Panel
        RegisterView.addPanel(window, infoPanel, 0, 0, 450, 600, "#202020");
        RegisterView.addLabel(infoPanel, signUpText, 76, 45, 294, 36, 30, false);

        //FirstName
        RegisterView.addLabel(infoPanel, firstNameLabel, 50, 165, 72, 17, 16, false);
        RegisterView.addTextField(infoPanel, firstNameTextField, 50, 190, 150, 40, 20);
        firstNameTextField.addActionListener(this);
        //LastName
        RegisterView.addLabel(infoPanel, lastNameLabel, 250, 165, 72, 17, 16, false);
        RegisterView.addTextField(infoPanel, lastNameTextField, 250, 190, 150, 40, 20);
        lastNameTextField.addActionListener(this);
        //Username
        RegisterView.addLabel(infoPanel, usernameLabel, 50, 249, 100, 17, 16, false);
        RegisterView.addTextField(infoPanel, usernameTextField, 50, 275, 350, 40, 20);
        usernameTextField.addActionListener(this);
        //Password
        RegisterView.addLabel(infoPanel, passwordLabel, 50, 334, 100, 17, 16, false);
        RegisterView.addTextField(infoPanel, passwordTextField, 50, 360, 350, 40, 20);
        passwordTextField.addActionListener(this);

        //Register Button
        RegisterView.addButton(infoPanel, signUpButton, 80, 452, 110, 50, 16, "#1D6EBA");
        signUpButton.addActionListener(this);
        //Cancel Button
        RegisterView.addButton(infoPanel, cancelButton, 260, 452, 110, 50, 16, "#1D6EBA");
        cancelButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == signUpButton){
            if(!DataController.isExistUser(usernameTextField.getText())){

                DataController.inputDataToFile(usernameTextField.getText(), passwordTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText());
                removeText();

                JOptionPane.showMessageDialog(null, " Successfully Created Account ", " Successful ", JOptionPane.INFORMATION_MESSAGE);
                backToLoginPage();

            } else {
                    JOptionPane.showMessageDialog(null, " Username Already Taken ", " Info ", JOptionPane.ERROR_MESSAGE);
                    usernameTextField.setText(null);
                    usernameTextField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#e41c23")));
            }
        }
        if(e.getSource() == cancelButton){
            backToLoginPage();
        }
    }

    void removeText (){
        usernameTextField.setText(null);
        passwordTextField.setText(null);
        firstNameTextField.setText(null);
        lastNameTextField.setText(null);
    }

    void backToLoginPage (){
        RegisterView.removePanelComponents(infoPanel);
        new LoginController();
    }
}