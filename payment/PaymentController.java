package payment;

import components.Components;

import javax.swing.*;
import java.awt.*;


public class PaymentController extends Components {
					
			JTextField firstnameLineField;
			JTextField lastnameLineField;
			JTextField dateLineField;
			JTextField amountLineField;
			JTextField yrSectionLineField;
			JButton submitButton;
			JButton returnButton;
	
		public PaymentController() {
			
			
			JLabel paymentLabel = new JLabel("PAYMENT INFO");
			PaymentView.addLabel(paymentLabel, window, 170, 97, 354, 58, "Arial", 48, true);
			
			JLabel firstnameLabel = new JLabel("FIRST NAME");
			PaymentView.addLabel(firstnameLabel, window, 280, 180, 144, 29, "Arial", 24, true);
			
			JLabel lastnameLabel = new JLabel("LAST NAME");
			PaymentView.addLabel(lastnameLabel, window, 280, 260, 144, 29, "Arial", 24, true);
			
			JLabel dateLabel = new JLabel("DATE");
			PaymentView.addLabel(dateLabel, window, 100, 340, 86, 29, "Arial", 20, false);
			
			JLabel mmddyyLabel = new JLabel("(mm/dd/yyyy)");
			PaymentView.addLabel(mmddyyLabel, window, 90, 400, 90, 29, "Arial", 16, false);
			
			JLabel amountLabel = new JLabel("AMOUNT");
			PaymentView.addLabel(amountLabel, window, 290, 340, 108, 29, "Arial", 20, true);
			
			JLabel amountSampleLable = new JLabel("(Whole number)");
			PaymentView.addLabel(amountSampleLable, window, 290, 400, 150, 29, "Arial", 16, false);
			
			JLabel yearSectionLabel = new JLabel("YR&SECTION");
			PaymentView.addLabel(yearSectionLabel, window, 455, 340, 190, 29, "Arial", 20, true);
			
			JLabel yearScampleLabel = new JLabel("(Year 1-6(A-R))");
			PaymentView.addLabel(yearScampleLabel, window, 505, 400, 150, 29, "Arial", 16, false);
			
			firstnameLineField = new JTextField(16);
			PaymentView.addLineTextField(firstnameLineField, window, 200, 210, 300, 20, "Arial", 20);
			
			lastnameLineField = new JTextField(16);
			PaymentView.addLineTextField(lastnameLineField, window, 200, 290, 300, 20, "Arial", 20);
			
			dateLineField = new JTextField(16);
			PaymentView.addLineTextField(dateLineField, window, 60, 380, 150, 20, "Arial", 20);
			
			amountLineField = new JTextField(16);
			PaymentView.addLineTextField(amountLineField, window, 270, 380, 150, 20, "Arial", 20);
			
			yrSectionLineField = new JTextField(16);
			PaymentView.addLineTextField(yrSectionLineField, window, 480, 380, 150, 20, "Arial", 20);
			
			returnButton = new JButton("return");
			PaymentView.addButton(returnButton, window, 160, 460, 130, 30);
			returnButton.setFont(new Font("Arial", Font.PLAIN, 20));
			
			submitButton = new JButton("submit");
			PaymentView.addButton(submitButton, window, 380, 460, 130, 30);
			submitButton.setFont(new Font("Arial", Font.PLAIN, 20));
			
			
			PaymentView.addFrameColor(window);
			window.setLayout(null);
			window.setVisible(true);
		}
}
