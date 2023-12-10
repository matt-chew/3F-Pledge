package PledgeSystem.Admin;

import PledgeSystem.Components.Components;
import PledgeSystem.Login.LoginController;
import PledgeSystem.Payment.PaymentController;
import PledgeSystem.Scholarship.ScholarshipController;
import PledgeSystem.Dashboard.DashboardController;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AdminController extends Components implements ActionListener{
					
				JPanel taskbarPanel;
				JPanel searchPanel;
				JPanel infoPanel;
				JPanel namePanel;
				JPanel pledgePanel;
				JPanel scholarInfoPanel;
				JPanel scholarStatusPanel;
				JPanel approvePanel;
				JPanel adminMenuPanel;
				
				JButton dashboardButton;
				JButton paymentButton;
				JButton adminButton;
				JButton scholarshipButton;
				JButton exitButton;
				JButton approveButton;
				JButton declineButton;
				JButton giveButton;
				JButton revokeButton;
				JButton deleteButton;
				
				JTextField inputUserField;
	
	
	
			public AdminController() {
				
				JLabel lookupLabel = new JLabel("Lookup User Info");
				AdminView.addLabel(lookupLabel, window, 0, 10, 150,20, "Arial", 20, false);
				
				JLabel userLabel = new JLabel("User: ");
				AdminView.addLabel(userLabel, window, 0, 45, 150,20, "Arial", 20, false);
				
				JLabel approvalLabel = new JLabel("Scholarship Approval ");
				AdminView.addLabel(approvalLabel, window, 110, 0, 200,20, "Arial", 20, true);
				
				JLabel nameLabel = new JLabel("Name:");
				AdminView.addLabel(nameLabel, window, 0, 40, 200,20, "Arial", 20, false);
				
				JLabel dateLabel = new JLabel("Date of Birth: ");
				AdminView.addLabel(dateLabel, window, 0, 80, 200,20, "Arial", 20, false);

				JLabel genderLabel = new JLabel("Gender:");
				AdminView.addLabel(genderLabel, window, 0, 120, 200,20, "Arial", 20, false);
				
				JLabel addressLabel = new JLabel("Address:");
				AdminView.addLabel(addressLabel, window, 0, 160, 200,20, "Arial", 20, false);
				
				JLabel adminLabel = new JLabel("Admin Menu");
				AdminView.addLabel(adminLabel, window, 150, 0, 200,20, "Arial", 20, false);
				
				JLabel userInfoLabel = new JLabel("User Info");
				AdminView.addLabel(userInfoLabel, window, 15, 10, 150,20, "Arial", 20, false);
				
				JLabel namePanelLabel = new JLabel("Name");
				AdminView.addLabel(namePanelLabel, window, 10, 10, 150,20, "Arial", 20, false);
				
				JLabel pledgeLabel = new JLabel("Current Pledge Amount");
				AdminView.addLabel(pledgeLabel, window, 10, 10, 250,20, "Arial", 20, false);
				
				JLabel amountLabel = new JLabel("Amount:");
				AdminView.addLabel(amountLabel, window, 10, 50, 150,20, "Arial", 20, false);
				
				JLabel scholarInfoLabel = new JLabel("Scholarship Info");
				AdminView.addLabel(scholarInfoLabel, window, 10, 10, 250,20, "Arial", 20, false);
				
				JLabel scholarStatusLabel = new JLabel("Scholarship Status");
				AdminView.addLabel(scholarStatusLabel, window, 10, 10, 250,20, "Arial", 16, false);
				

				inputUserField = new JTextField();
				AdminView.addTextField(inputUserField, window, 60, 40, 250, 30, "Arial", 16);

				
				//Taskbar Button
				dashboardButton = new JButton();
				AdminView.addButton(dashboardButton, window, 5, 10, 40, 40);
				dashboardButton.addActionListener(this);
				
				paymentButton = new JButton();
				AdminView.addButton(paymentButton, window, 5, 60, 40, 40);
				paymentButton.addActionListener(this);

				scholarshipButton = new JButton();
				AdminView.addButton(scholarshipButton, window, 5, 110, 40, 40);
				scholarshipButton.addActionListener(this);
				
				adminButton = new JButton();
				AdminView.addButton(adminButton, window, 5, 160, 40, 40);
				
				exitButton = new JButton();
				AdminView.addButton(exitButton, window, 5, 510, 40, 40);
				exitButton.addActionListener(this);

				//Panel Button
				approveButton = new JButton("Approve");
				AdminView.addButton(approveButton, window, 720, 250, 100, 30);
				approveButton.setBackground(Color.BLACK);
				
				declineButton = new JButton("Decline");
				AdminView.addButton(declineButton, window, 850, 250, 100, 30);
				declineButton.setBackground(Color.BLACK);
				
				giveButton = new JButton("Give Registrar Role");
				AdminView.addButton(giveButton, window, 660, 400, 160, 40);
				giveButton.setBackground(Color.BLACK);
				
				revokeButton = new JButton("Revoke Registrar Role");
				AdminView.addButton(revokeButton, window, 850, 400, 160, 40);
				revokeButton.setBackground(Color.BLACK);
				
				deleteButton = new JButton("Delete Account");
				AdminView.addButton(deleteButton, window, 760, 475, 160, 40);
				deleteButton.setBackground(Color.BLACK);
				
				
				
				
				namePanel = new JPanel();
				AdminView.addPanel(namePanel, window, 15, 55, 300, 80);
				namePanel.setBackground(new Color(0x2c2c2c));
				namePanel.add(namePanelLabel);
				
				
				pledgePanel = new JPanel();
				AdminView.addPanel(pledgePanel, window, 15, 170, 300, 80);
				pledgePanel.setBackground(new Color(0x2c2c2c));
				pledgePanel.add(pledgeLabel);
				pledgePanel.add(amountLabel);

				scholarInfoPanel = new JPanel();
				AdminView.addPanel(scholarInfoPanel, window, 15, 270, 470, 110);
				scholarInfoPanel.setBackground(new Color(0x2c2c2c));
				scholarInfoPanel.add(scholarInfoLabel);
				
				scholarStatusPanel = new JPanel();
				AdminView.addPanel(scholarStatusPanel, window, 333, 55, 150, 195);
				scholarStatusPanel.setBackground(new Color(0x2c2c2c));
				scholarStatusPanel.add(scholarStatusLabel);
				
				
				taskbarPanel = new JPanel();
				AdminView.addPanel(taskbarPanel, window, 0, 0, 50, 600);
				taskbarPanel.setBackground(new Color(0x383535));
				
				searchPanel = new JPanel();
				AdminView.addPanel(searchPanel, window, 85, 30, 500, 80);
				searchPanel.setBackground(new Color(0x2C2C2C));
				searchPanel.add(lookupLabel);
				searchPanel.add(userLabel);
				searchPanel.add(inputUserField);
				
				infoPanel = new JPanel();
				AdminView.addPanel(infoPanel, window, 85, 145, 500, 400);
				infoPanel.setBackground(new Color(0x565656));
				infoPanel.add(userInfoLabel);
				infoPanel.add(namePanel);
				infoPanel.add(pledgePanel);
				infoPanel.add(scholarInfoPanel);
				infoPanel.add(scholarStatusPanel);
				
				approvePanel = new JPanel();
				AdminView.addPanel(approvePanel, window, 635, 30, 400, 300);
				approvePanel.setBackground(new Color(0x2C2C2C));
				approvePanel.add(approvalLabel);
				approvePanel.add(nameLabel);
				approvePanel.add(dateLabel);
				approvePanel.add(genderLabel);
				approvePanel.add(addressLabel);
				
				adminMenuPanel = new JPanel();
				AdminView.addPanel(adminMenuPanel, window, 635, 365, 400, 180);
				adminMenuPanel.setBackground(new Color(0x2C2C2C));
				adminMenuPanel.add(adminLabel);
				
			}


	public void actionPerformed(ActionEvent e){
			if(e.getSource() == dashboardButton){


				AdminView.removeComponents(window);
				System.out.println("Hello");
				new DashboardController();
			}

			if(e.getSource() == paymentButton){


				AdminView.removeComponents(window);
				System.out.println("Hello");
				new PaymentController();
			}

			if(e.getSource() == scholarshipButton){


				AdminView.removeComponents(window);
				System.out.println("Hello");
				new ScholarshipController();
			}

			if(e.getSource() == exitButton){


				AdminView.removeComponents(window);
				System.out.println("Hello");
				new LoginController();
			}
		}		

}
