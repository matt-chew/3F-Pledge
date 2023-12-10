package pledge.registrar;

import javax.swing.*;
import java.awt.*;
import pledge.components.*;

public class RegistrarController extends Components{

	JPanel buttonPanel;
	JPanel userSearchPanel;
	JPanel userInfoPanel;
	JPanel scholarApprovePanel;


	JButton dashboardButton;
	JButton paymentButton;
	JButton adminButton;
	JButton scholarshipButton;
	JButton exitButton;
	JButton approveButton;
	JButton declineButton;

	JTextField userSearchTextField;
	JTextField nameTextField;
	JTextField amountTextField;
	JTextField nameScholarTextField;
	JTextField birthScholarTextField;
	JTextField genderScholarTextField;
	JTextField addressScholarTextField;

	public RegistrarController(){

		buttonPanel = new JPanel();
		RegistrarView.addPanel(buttonPanel,window,0,0,50,600,new Color(72,77,81));

		dashboardButton = new JButton("Dashboard");
		RegistrarView.addButton(dashboardButton,window,5,5,40,40,15);

		paymentButton = new JButton("Payment");
		RegistrarView.addButton(paymentButton,window,5,55,40,40,15);

		adminButton = new JButton("Admin");
		RegistrarView.addButton(adminButton,window,5,105,40,40,15);

		scholarshipButton = new JButton("Scholarship");
		RegistrarView.addButton(scholarshipButton,window,5,155,40,40,15);

		exitButton = new JButton("Exit");
		RegistrarView.addButton(exitButton,window,5,510,40,40,15);

		buttonPanel.add(dashboardButton);
		buttonPanel.add(paymentButton);
		buttonPanel.add(adminButton);
		buttonPanel.add(scholarshipButton);
		buttonPanel.add(exitButton);

		

		userSearchPanel = new JPanel();
		RegistrarView.addPanel(userSearchPanel,window,81,36,600,80,new Color(44,44,44));

		JLabel userSearchLabel = new JLabel();
		RegistrarView.addLabel(userSearchLabel,window,"Lookup User Info",0,0,600,40,20,false);
		userSearchLabel.setBackground(new Color(21,21,21));
		userSearchLabel.setOpaque(true);

		JLabel userSearchLabel2 = new JLabel();
		RegistrarView.addLabel(userSearchLabel2,window,"User:",0,40,50,40,20,false);

		userSearchTextField = new JTextField();
		RegistrarView.addTextField(userSearchTextField,window,70,40,430,40,20);

		userSearchPanel.add(userSearchLabel);
		userSearchPanel.add(userSearchLabel2);
		userSearchPanel.add(userSearchTextField);



		userInfoPanel = new JPanel();
		RegistrarView.addPanel(userInfoPanel,window,81,152,600,400,new Color(86,86,86));

		JLabel userInfoLabel = new JLabel();
		RegistrarView.addLabel(userInfoLabel,window,"User Info",0,0,600,40,20,false);
		userInfoLabel.setBackground(new Color(21,21,21));
		userInfoLabel.setOpaque(true);

		 JLabel nameLabel = new JLabel();
		 RegistrarView.addLabel(nameLabel,window,"Name",10,50,300,40,20,false);
		 nameLabel.setBackground(new Color(21,21,21));
		 nameLabel.setOpaque(true);


		nameTextField = new JTextField();
		RegistrarView.addTextField(nameTextField,window,10,90,300,40,20);


		 JLabel currentAmountLabel = new JLabel();
		 RegistrarView.addLabel(currentAmountLabel,window,"Current Pledge Amount:",10,150,300,40,20,false);
		 currentAmountLabel.setBackground(new Color(21,21,21));
		 currentAmountLabel.setOpaque(true);

		 JLabel amountLabel = new JLabel();
		 RegistrarView.addLabel(amountLabel,window,"Amount:",10,190,80,40,20,false);
		 amountLabel.setBackground(new Color(44,44,44));
		 amountLabel.setOpaque(true);

		amountTextField = new JTextField();
		RegistrarView.addTextField(amountTextField,window,90,190,220,40,20);


		JLabel scholarStatsLabel = new JLabel();
		RegistrarView.addLabel(scholarStatsLabel,window,"Scholarship Status",320,50,250,40,20,true);
		scholarStatsLabel.setBackground(new Color(21,21,21));
		scholarStatsLabel.setOpaque(true);

		JLabel scholarDateLabel = new JLabel();
		RegistrarView.addLabel(scholarDateLabel,window,"",320,90,250,140,20,true);
		scholarDateLabel.setBackground(new Color(44,44,44));
		scholarDateLabel.setOpaque(true);

		JLabel scholarInfoLabel = new JLabel();
		RegistrarView.addLabel(scholarInfoLabel,window,"Scholarship Info",10,260,550,40,20,false);
		scholarInfoLabel.setBackground(new Color(21,21,21));
		scholarInfoLabel.setOpaque(true);

		JLabel scholarReasonLabel = new JLabel();
		RegistrarView.addLabel(scholarReasonLabel,window,"",10,300,550,80,20,true);
		scholarReasonLabel.setBackground(new Color(44,44,44));
		scholarReasonLabel.setOpaque(true);

		 
		userInfoPanel.add(userInfoLabel);
		userInfoPanel.add(nameLabel);
		userInfoPanel.add(nameTextField);
		userInfoPanel.add(currentAmountLabel);
		userInfoPanel.add(amountLabel);
		userInfoPanel.add(amountTextField);
		userInfoPanel.add(scholarStatsLabel);
		userInfoPanel.add(scholarDateLabel);
		userInfoPanel.add(scholarInfoLabel);
		userInfoPanel.add(scholarReasonLabel);

		scholarApprovePanel = new JPanel();
		RegistrarView.addPanel(scholarApprovePanel,window,701,36,350,300,new Color(44,44,44));

		JLabel scholarApproveLabel = new JLabel();
		RegistrarView.addLabel(scholarApproveLabel,window,"Scholarship Approval",0,0,350,40,20,false);
		scholarApproveLabel.setBackground(new Color(21,21,21));
		scholarApproveLabel.setOpaque(true);

		JLabel nameScholarLabel = new JLabel();
		RegistrarView.addLabel(nameScholarLabel,window,"Name:",10,50,80,30,20,false);

		nameScholarTextField = new JTextField();
		RegistrarView.addTextField(nameScholarTextField,window,100,50,230,30,20);

		JLabel birthScholarLabel = new JLabel();
		RegistrarView.addLabel(birthScholarLabel,window,"Date of Birth:",10,90,120,30,20,false);

		birthScholarTextField = new JTextField();
		RegistrarView.addTextField(birthScholarTextField,window,140,90,190,30,20);

		JLabel genderScholarLabel = new JLabel();
		RegistrarView.addLabel(genderScholarLabel,window,"Gender:",10,130,80,30,20,false);

		genderScholarTextField = new JTextField();
		RegistrarView.addTextField(genderScholarTextField,window,100,130,230,30,20);


		JLabel addressScholarLabel = new JLabel();
		RegistrarView.addLabel(addressScholarLabel,window,"Address:",10,170,80,20,20,false);

		addressScholarTextField = new JTextField();
		RegistrarView.addTextField(addressScholarTextField,window,100,170,230,20,20);

		approveButton = new JButton("Approve");
		RegistrarView.addButton(approveButton,window,30,210,130,50,15);

		declineButton = new JButton("Decline");
		RegistrarView.addButton(declineButton,window,180,210,130,50,15);
		


		scholarApprovePanel.add(scholarApproveLabel);
		scholarApprovePanel.add(nameScholarLabel);
		scholarApprovePanel.add(nameScholarTextField);
		scholarApprovePanel.add(birthScholarLabel);
		scholarApprovePanel.add(birthScholarTextField);
		scholarApprovePanel.add(genderScholarLabel);
		scholarApprovePanel.add(genderScholarTextField);
		scholarApprovePanel.add(addressScholarLabel);
		scholarApprovePanel.add(addressScholarTextField);
		scholarApprovePanel.add(approveButton);
		scholarApprovePanel.add(declineButton);
		



		RegistrarView.addFrameColor(window);
		window.setVisible(true);
	}
}