package payment;

import Database.DataController;
import components.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;


public class PaymentController extends Components implements MouseListener {

	String filename;

	// Payment Components
	JPanel selectPaymentPanel = new JPanel();
	JPanel backgroundAmountPanel = new JPanel();
	JLabel showSelectedAmount = new JLabel("0");
	JLabel amountLabel = new JLabel("Amount :");

	JButton amount1Btn = new JButton("500");
	JButton amount2Btn = new JButton("800");
	JButton amount3Btn = new JButton("1000");

	JLabel specificAmount = new JLabel("Specify Amount");
	JTextField amount = new JTextField();

	JButton inputBtn = new JButton("Input");


	// User Form Components
	JPanel userFormPanel = new JPanel();

	JLabel nameLogo = new JLabel("Student Name");

	JLabel nameLb = new JLabel("Name");
	JTextField nameTf = new JTextField();

	JLabel lastnameLb = new JLabel("Lastname");
	JTextField lastnameTf = new JTextField();

	JLabel dateLb = new JLabel("MM/DD/YY");
	JTextField monthTf = new JTextField();




	// receipt Components
	JPanel receiptPanel = new JPanel();

	JLabel nameDisplay = new JLabel("Full Name : ");
	JLabel payAmountDisplay = new JLabel("Money Input : ");
	JLabel dateDisplay = new JLabel("Date : ");

	JButton submitBtn = new JButton("Submit");

	public PaymentController(String filename) {

		this.filename = filename;

		// payment panel
		PaymentView.addPanelToPanel(divPanel, selectPaymentPanel, 380, 20, 500, 220, "#EEF5FF");
		PaymentView.addPanelToPanel(selectPaymentPanel, backgroundAmountPanel, 120, 30, 250, 40, "#B4BDFF");

		PaymentView.addLabel(backgroundAmountPanel, showSelectedAmount, 130, 0, 200, 40, 20, false, 0);
		PaymentView.addLabel(backgroundAmountPanel, amountLabel, 40, 0, 100, 40, 20, false, 0);


		PaymentView.addButton(selectPaymentPanel, amount1Btn, 30, 100, 125, 35, 25, "#9EB8D9");
		amount1Btn.addMouseListener(this);

		PaymentView.addButton(selectPaymentPanel, amount2Btn, 180, 100, 125, 35, 25, "#9EB8D9");
		amount2Btn.addMouseListener(this);

		PaymentView.addButton(selectPaymentPanel, amount3Btn, 330, 100, 125, 35, 25, "#9EB8D9");
		amount3Btn.addMouseListener(this);

		PaymentView.addLabel(selectPaymentPanel, specificAmount, 30, 155, 200, 40, 15, false, 0);
		PaymentView.addJTextField(selectPaymentPanel, amount, 150, 160, 150, 30, 15);

		PaymentView.addButton(selectPaymentPanel, inputBtn, 325, 160, 100, 30, 25, "#9EB8D9");
		inputBtn.addMouseListener(this);


		// name and lastname panel
		PaymentView.addPanelToPanel(divPanel, userFormPanel, 30, 20, 300, 240, "#EEF5FF");

		PaymentView.addLabel(userFormPanel, nameLogo, 0, 5, 300, 60, 20, true, 0);

		PaymentView.addLabel(userFormPanel, nameLb, 50, 65, 200, 30, 15, true, 0);
		PaymentView.addJTextField(userFormPanel, nameTf, 50, 90, 200, 20, 15);

		PaymentView.addLabel(userFormPanel, lastnameLb, 50, 130, 200, 30, 15, true, 0);
		PaymentView.addJTextField(userFormPanel, lastnameTf, 50, 155, 200, 20, 15);

		PaymentView.addLabel(userFormPanel, dateLb, 50, 200, 200, 30, 15, false, 0);
		PaymentView.addJTextField(userFormPanel, monthTf, 130, 200, 100, 20, 15);


		// receipt panel
		PaymentView.addPanelToPanel(divPanel, receiptPanel, 100, 280, 600, 250, "#EEF5FF");

		PaymentView.addLabel(receiptPanel, nameDisplay, 30, 50, 250, 20, 15, false, 0);
		PaymentView.addLabel(receiptPanel, payAmountDisplay, 30, 100, 200, 20, 15, false, 0);
		PaymentView.addLabel(receiptPanel, dateDisplay, 30, 150, 200, 20, 15, false, 0);

		PaymentView.addButton(receiptPanel ,submitBtn, 350, 100, 200, 50, 20, "#9EB8D9");
		submitBtn.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if(e.getSource() == amount1Btn) {

			showSelectedAmount.setText(amount1Btn.getText() + ".00");
			amount.setText(amount1Btn.getText());

		}

		if(e.getSource() == amount2Btn) {

			showSelectedAmount.setText(amount2Btn.getText() + ".00");
			amount.setText(amount2Btn.getText());

		}

		if(e.getSource() == amount3Btn) {

			showSelectedAmount.setText(amount3Btn.getText() + ".00");
			amount.setText(amount3Btn.getText());

		}

		if(!amount.getText().isEmpty()) {

			if (checkIsNumber(amount.getText())) {

				if (e.getSource() == inputBtn) showSelectedAmount.setText(amount.getText() + ".00");

			} else {

				amount.setText(null);
				showSelectedAmount.setText("Input number only !!");

			}

		}

		if( !nameTf.getText().isEmpty() && !lastnameTf.getText().isEmpty() ) nameDisplay.setText("Full Name : " + nameTf.getText() + " " + lastnameTf.getText());
		if( !showSelectedAmount.getText().isEmpty() ) payAmountDisplay.setText("Money Input : " + showSelectedAmount.getText());
		if( !monthTf.getText().isEmpty() ) dateDisplay.setText("Date : " + monthTf.getText().substring(0, 2) + "/" + monthTf.getText().substring(2, 4) + "/" + monthTf.getText().substring(4));

		validationColor();

		if(e.getSource() == submitBtn){

			if ( !nameTf.getText().isEmpty() && !lastnameTf.getText().isEmpty()  && !showSelectedAmount.getText().isEmpty() && !monthTf.getText().isEmpty() ){

				JOptionPane.showMessageDialog(null, " Payment Successful ", " Payment save ", JOptionPane.INFORMATION_MESSAGE);
				DataController.inputPayment(filename, nameTf.getText(), lastnameTf.getText(), showSelectedAmount.getText(), dateDisplay.getText().substring(7));
				clearTextField();
				textFieldRepaintLineBlack();

			}

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

		if(e.getSource() == submitBtn){

			if ( !nameTf.getText().isEmpty() && !lastnameTf.getText().isEmpty()  && !showSelectedAmount.getText().isEmpty() && !monthTf.getText().isEmpty() ) {
				nameDisplay.setText("Full Name : " + nameTf.getText() + " " + lastnameTf.getText());
				payAmountDisplay.setText("Money Input : " + showSelectedAmount.getText());
				dateDisplay.setText("Date : " + monthTf.getText().substring(0, 2) + "/" + monthTf.getText().substring(2, 4) + "/" + monthTf.getText().substring(4));
			}

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	boolean checkIsNumber (String number){

		try {

			int intValue = Integer.parseInt(number);
			return true;

		} catch (NumberFormatException ignored) {}

		return false;
	}

	void validationColor (){

		if( nameTf.getText().isEmpty() ) nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.RED));
			else nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.GREEN));

		if( lastnameTf.getText().isEmpty() ) lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.RED));
			else lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.GREEN));

		if( monthTf.getText().isEmpty() ) monthTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.RED));
			else monthTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.GREEN));

		if( amount.getText().isEmpty() ) amount.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.RED));
			else amount.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.GREEN));

	}

	void clearTextField (){

		nameTf.setText(null);
		lastnameTf.setText(null);
		showSelectedAmount.setText(null);
		monthTf.setText(null);
		amount.setText(null);
		nameDisplay.setText("Full Name : ");
		payAmountDisplay.setText("Money Input : ");
		dateDisplay.setText("Date : ");

	}

	void textFieldRepaintLineBlack (){

		nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));
		lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));
		monthTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));
		amount.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));

	}
}
