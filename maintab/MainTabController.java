package maintab;

import components.Components;
import login.LoginController;
import payment.PaymentController;
import dashboard.DashboardController;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MainTabController extends Components implements MouseListener {

    String filename;
    String username;

    JButton dashBoardBtn = new JButton("Dashboard");

    JButton paymentBtn = new JButton("Payment");

    JButton scholarshipBtn = new JButton("Scholarship");

    JButton logoutBtn = new JButton("logout");

    public MainTabController (String filename, String username){

        this.filename = filename;
        this.username = username;

        MainTabView.addPanel(window, divPanel, 157, 10, 925, 546, "#161A30");


        MainTabView.addPanel(window, buttonPanel, 5, 10, 150, 546, "#31304D");

        MainTabView.addButton(buttonPanel, dashBoardBtn, 10, 20, 130, 40, 15, "#67729D");
        dashBoardBtn.addMouseListener(this);

        MainTabView.addButton(buttonPanel, paymentBtn, 10, 70, 130, 40, 15, "#67729D");
        paymentBtn.addMouseListener(this);

        MainTabView.addButton(buttonPanel, logoutBtn, 10, 470, 130, 40, 20, "#67729D");
        logoutBtn.addMouseListener(this);

        MainTabView.addButton(buttonPanel, scholarshipBtn, 10, 120, 130, 40, 15, "#67729D");

        MainTabView.removePanelComponents(divPanel);
        new DashboardController(filename, username);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == paymentBtn){

            MainTabView.removePanelComponents(divPanel);
            new PaymentController(filename);

        }

        if(e.getSource() == dashBoardBtn){

            MainTabView.removePanelComponents(divPanel);
            new DashboardController(filename, username);

        }

        if(e.getSource() == logoutBtn){

            MainTabView.removeComponents(window);
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
