package pledge;

import javax.swing.*;
import pledge.adminDashboard.*;
import pledge.components.*;

public class Main extends Components{
	public static void main(String[] args) {
		window.setSize(1100,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		window.setResizable(false);

		new adminController();
	}
}