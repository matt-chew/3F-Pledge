package PledgeSystem.Dashboard;

import PledgeSystem.Components.Components;
import PledgeSystem.Login.LoginController;
import PledgeSystem.Payment.PaymentController;
import PledgeSystem.Scholarship.ScholarshipController;
import PledgeSystem.Admin.AdminController;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DashboardController extends Components implements ActionListener{
			JPanel taskbarPanel;
			JPanel dashboardsPanel, dashboardPanel1,dashboardPanel2, dashboardPanel3,dashboardPanel4,dashboardPanel5,dashboardPanel6,dashboardPanel7;
			JPanel paymentSummaryPanel, paymentTitlePanel;
			JButton dashboardButton;
			JButton paymentButton;
			JButton adminButton;
			JButton exitButton;
			JButton scholarshipButton;

			
		public DashboardController() {
			
			JLabel dashBoardLabel = new JLabel("Dashboard");
			DashboardView.addLabel(dashBoardLabel, window,  230, 80, 100, 20, "Arial", 14);	
			
			JLabel paymentSummaryLabel = new JLabel("Payment Summary");
			DashboardView.addLabel(paymentSummaryLabel, window,  710, 80, 150, 20, "Arial", 14);		

			//Taskbar Button
       		dashboardButton = new JButton();
			DashboardView.addButton(window, dashboardButton, 5, 10, 40, 40, 18);

			paymentButton = new JButton();
			DashboardView.addButton(window, paymentButton, 5, 60, 40, 40, 18);
			paymentButton.addActionListener(this);

			scholarshipButton = new JButton();
			DashboardView.addButton(window, scholarshipButton, 5, 110, 40, 40, 18);
			scholarshipButton.addActionListener(this);

			adminButton = new JButton();
			DashboardView.addButton(window, adminButton, 5, 160, 40, 40, 18);
			adminButton.addActionListener(this);

			exitButton = new JButton();
			DashboardView.addButton(window, exitButton, 5, 510, 40, 40, 18);
			exitButton.addActionListener(this);


			//Panel
			taskbarPanel = new JPanel();
			DashboardView.addPanel(taskbarPanel, window, 0, 0, 50, 600);
			
			dashboardsPanel = new JPanel();
			DashboardView.addPanel(dashboardsPanel, window, 75, 75, 400, 435);	
			dashboardPanel1 = new JPanel();
			DashboardView.addPanel(dashboardPanel1, window, 0, 0, 400, 30);			
			dashboardPanel2 = new JPanel();
			DashboardView.addPanel(dashboardPanel2, window, 20, 45, 225, 377);			
			dashboardPanel3 = new JPanel();
			DashboardView.addPanel(dashboardPanel3, window, 263, 45, 120, 120);			
			dashboardPanel4 = new JPanel();
			DashboardView.addPanel(dashboardPanel4, window, 263, 180, 51, 98);			
			dashboardPanel5 = new JPanel();
			DashboardView.addPanel(dashboardPanel5, window, 332, 180, 51, 42);			
			dashboardPanel6 = new JPanel();
			DashboardView.addPanel(dashboardPanel6, window, 332, 236, 51, 42);
			dashboardPanel7 = new JPanel();
			DashboardView.addPanel(dashboardPanel7, window, 263, 300, 120, 120);
			
			paymentSummaryPanel = new JPanel();
			DashboardView.addPanel(paymentSummaryPanel, window, 500, 75, 550, 435);
			
			paymentTitlePanel = new JPanel();
			DashboardView.addPanel(paymentTitlePanel, window, 0, 0, 550, 30);
			
			
			taskbarPanel.setBackground(new Color(0x383535));	
			dashboardsPanel.setBackground(new Color(0x323232));
			dashboardPanel1.setBackground(new Color(0x212121));
			dashboardPanel2.setBackground(new Color(0x212121));
			dashboardPanel3.setBackground(new Color(0x212121));
			dashboardPanel4.setBackground(new Color(0x212121));
			dashboardPanel5.setBackground(new Color(0x212121));
			dashboardPanel6.setBackground(new Color(0x212121));
			dashboardPanel7.setBackground(new Color(0x212121));
			
			paymentSummaryPanel.setBackground(new Color(0x323232));
			paymentTitlePanel.setBackground(new Color(0x212121));
			
			dashboardsPanel.add(dashboardPanel1);
			dashboardsPanel.add(dashboardPanel2);
			dashboardsPanel.add(dashboardPanel3);
			dashboardsPanel.add(dashboardPanel4);
			dashboardsPanel.add(dashboardPanel5);
			dashboardsPanel.add(dashboardPanel6);
			dashboardsPanel.add(dashboardPanel7);
			
			paymentSummaryPanel.add(paymentTitlePanel);	
			
			dashboardsPanel.setLayout(null);
			paymentSummaryPanel.setLayout(null);

		}

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == scholarshipButton){

				DashboardView.removePanelComponents(dashboardsPanel);
				DashboardView.removePanelComponents(paymentSummaryPanel);
				DashboardView.removeComponents(window);
				System.out.println("Hello");
				new ScholarshipController();
			}

			if(e.getSource() == paymentButton){

				DashboardView.removePanelComponents(dashboardsPanel);
				DashboardView.removePanelComponents(paymentSummaryPanel);
				DashboardView.removeComponents(window);
				System.out.println("Hello");
				new PaymentController();
			}

			if(e.getSource() == adminButton){

				DashboardView.removePanelComponents(dashboardsPanel);
				DashboardView.removePanelComponents(paymentSummaryPanel);
				DashboardView.removeComponents(window);
				System.out.println("Hello");
				new AdminController();
			}

			if(e.getSource() == exitButton){

				DashboardView.removePanelComponents(dashboardsPanel);
				DashboardView.removePanelComponents(paymentSummaryPanel);
				DashboardView.removeComponents(window);
				System.out.println("Hello");
				new LoginController();
			}
		}
}