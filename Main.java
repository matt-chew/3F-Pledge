package PledgeSystem;

import PledgeSystem.Components.Components;
import PledgeSystem.Login.LoginController;

import javax.swing.*;
import java.awt.*;

public class Main extends Components{
    public static void main(String[] args){

        window.setSize(1100, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.getContentPane().setBackground(Color.decode("#0d0d0d"));

        new LoginController();

        window.setVisible(true);
    }
}
