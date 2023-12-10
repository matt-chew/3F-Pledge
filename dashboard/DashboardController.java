package dashboard;

import components.Components;
import login.LoginController;
import Database.DataController;

import javax.swing.*;
import java.util.List;

public class DashboardController extends Components {

		String filename;
		String username;

		// dashboard panel
		JPanel dashboardsPanel = new JPanel();
		JLabel dashboardLabel = new JLabel("DASHBOARD");

		// student info panel
		JPanel userInfoPanel = new JPanel();

		JPanel usernamePanel = new JPanel();
		JLabel fullName = new JLabel("TEST ERROR");

		JLabel currentPledgeAmountLb = new JLabel("Current Pledge Amount");
		JLabel showPledgeTotal = new JLabel();

		// scholarship panel
		JPanel scholarshipPanel = new JPanel();
		JLabel scholarshipLabel = new JLabel("SCHOLARSHIP");
		JLabel scholarshipStatus = new JLabel("None");

		// Payment History
		JPanel paymentHistoryPanel = new JPanel();
		JLabel historyLabel =  new JLabel("History");
		JTextArea historyTA = new JTextArea();

	public DashboardController ( String filename, String username ) {

		this.filename = filename;
		this.username = username;

		// dashboard panel
		DashboardView.addPanelToPanel(divPanel, dashboardsPanel, 20, 20, 450, 490, "#0A2647");
		DashboardView.addLabel(dashboardsPanel, dashboardLabel, 0, 450, 450, 40, 25, true, 0, "#6096B4");


		// userinfo panel
		DashboardView.addPanelToPanel(dashboardsPanel , userInfoPanel, 10, 50, 260, 370, "#161A30");

		// fullName panel
		DashboardView.addPanelToPanel(userInfoPanel , usernamePanel, 5, 20, 250, 40, "#31304D");
		DashboardView.addLabel(usernamePanel, fullName, 0, 0, 250, 40, 20, true, 0, "#2C74B3");
		getUserFullName();

		// pledge
		DashboardView.addLabel(userInfoPanel, currentPledgeAmountLb, 0, 120, 260, 40, 20, true, 0, "#2C74B3");
		DashboardView.addLabel(userInfoPanel, showPledgeTotal, 0, 160, 260, 40, 30, true, 0, "#2C74B3");
		getTotalAmount();


		// scholarship panel
		DashboardView.addPanelToPanel(dashboardsPanel ,scholarshipPanel, 280, 90, 160, 200, "#161A30");
		DashboardView.addLabel(scholarshipPanel, scholarshipLabel, 0, 15, 160, 60, 20, true, 1, "#FAF6F0");
		DashboardView.addLabel(scholarshipPanel, scholarshipStatus, 0, 90, 160, 60, 20, true, 0, "#872341");

		// history panel
		DashboardView.addPanelToPanel(divPanel, paymentHistoryPanel, 500, 20, 400, 490, "#0A2647");
		DashboardView.addLabel(paymentHistoryPanel, historyLabel, 0, 10, 400, 60, 40, true, 0, "#6096B4");
		DashboardView.addJTextArea(paymentHistoryPanel, historyTA, 20, 70, 350, 370);
		displayHistoryPayment();

	}

	void displayHistoryPayment (){

		List<List<String>> data = DataController.readDataFromFile( filename );

		historyTA.setText(" Paid Amount" + "\t" + "Date Paid" + "\n");
		for(List<String> row : data){

			if(row.size() > 3) {

				historyTA.append(" " + row.get(2) + "\t" + row.get(3) + "\n");

			}

		}

	}

	void getTotalAmount (){

		showPledgeTotal.setText(" " + DataController.getTotalAmountPledge(filename) + " ");

	}

	void getUserFullName (){

		fullName.setText( DataController.getUserFullName( username ).toUpperCase() );

	}

}