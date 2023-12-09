package pledge.adminDashboard;

import javax.swing.*;
import java.awt.*;
import pledge.components.*;

public class adminController extends Components{
	public adminController(){

		JPanel buttonPanel = new JPanel();
		adminView.addPanel(buttonPanel,window,0,0,50,600);

		JButton dashboardButton = new JButton();
		adminView.addButton(dashboardButton,window,5,5,40,40);

		JButton paymentButton = new JButton();
		adminView.addButton(paymentButton,window,5,55,40,40);

		JButton adminButton = new JButton();
		adminView.addButton(adminButton,window,5,105,40,40);

		JButton scholarshipButton = new JButton();
		adminView.addButton(scholarshipButton,window,5,155,40,40);

		JButton exitButton = new JButton();
		adminView.addButton(exitButton,window,5,510,40,40);

		buttonPanel.add(dashboardButton);
		buttonPanel.add(paymentButton);
		buttonPanel.add(adminButton);
		buttonPanel.add(scholarshipButton);
		buttonPanel.add(exitButton);



		adminView.addFrameColor(window);
		window.setVisible(true);
	}
}