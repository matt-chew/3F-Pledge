package pledge.dashboard;

import pledge.components.*;
import java.awt.*;
import javax.swing.*;

public class DashboardController extends Components {
			JPanel taskbarPanel;
			JPanel dashboardsPanel, dashboardPanel1,dashboardPanel2, dashboardPanel3,dashboardPanel4,dashboardPanel5,dashboardPanel6,dashboardPanel7;
			JPanel paymentSummaryPanel, paymentTitlePanel;
			JButton dateButton;
			JButton paymentButton;
			
			
		
		public DashboardController() {
			
			JLabel dashBoardLabel = new JLabel("Dashboard");
			DashboardView.addLabel(dashBoardLabel, window,  230, 80, 100, 20, "Arial", 14);	
			
			JLabel paymentSummaryLabel = new JLabel("Payment Summary");
			DashboardView.addLabel(paymentSummaryLabel, window,  710, 80, 150, 20, "Arial", 14);	
			
			dateButton = new JButton();
			DashboardView.addButton(dateButton, window, 5, 10, 40, 40);
			
			paymentButton = new JButton();
			DashboardView.addButton(paymentButton, window, 5, 60, 40, 40);

			
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
			
			DashboardView.addFrameColor(window);
			
			
			dashboardsPanel.setLayout(null);
			paymentSummaryPanel.setLayout(null);
			
		    window.setLayout(null);
			window.setVisible(true);
		}
}
