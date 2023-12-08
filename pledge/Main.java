package pledge;

import javax.swing.JFrame;

import pledge.payment.*;
import pledge.components.*;

public class Main extends FrameView {

	public static void main(String[] args) {
		display.setSize(700,600);
		display.setLayout(null);
		display.setLocationRelativeTo(null);
		display.setResizable(false);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new PaymentController();

	}

}
