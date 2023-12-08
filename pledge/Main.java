package pledge;

import javax.swing.JFrame;

import payment.PaymentController;
import components.Components;


public class Main extends Components {

	public static void main(String[] args) {
		window.setSize(700,600);
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new PaymentController();

	}

}
