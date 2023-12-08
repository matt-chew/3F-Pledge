package pledge;

import javax.swing.JFrame;

import pledge.dashboard.*;
import pledge.components.*;

public class Main extends Components {

	public static void main(String[] args) {
		window.setSize(1100,600);
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new DashboardController();

	}

}
