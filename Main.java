package pledge;

import javax.swing.JFrame;
import scholarship.ScholarshipController.*;
import components.Components*;

public class Main extends Components {

	public static void main(String[] args) {
		window.setSize(1100,600);
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		windowy.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new ScholarshipController();

	}

}