package PledgeSystem.Scholarship;

import javax.swing.*;
import java.awt.*;

public class ScholarshipView{
	
	static void addLabel(JLabel label, JFrame frame, int x, int y, int width, int height, String fontStyle, int fontSize, boolean center) {
		label.setBounds(x, y, width, height);
		label.setForeground(Color.BLACK);
		label.setFont(new Font(fontStyle, Font.PLAIN , fontSize));
		if(center) {
			label.setHorizontalAlignment(JLabel.CENTER);
				} else {
			label.setHorizontalAlignment(JLabel.LEFT);
		}	
		frame.add(label);
	}
				
	static void addPanel(JPanel panel, JFrame frame, int x, int y, int width, int height) {
		panel.setBounds(x, y, width, height);
		frame.add(panel);
	}
					
	static void addTextField(JTextField textField, JFrame frame, int x, int y, int width, int height) {
		textField.setBounds(x, y, width, height);
		frame.add(textField);
			
	}
				
	static void addPassField(JPasswordField passField, JFrame frame, int x, int y, int width, int height) {
		passField.setBounds(x, y, width, height);
		frame.add(passField);
					
	}
				
	static void addCheckBox(JCheckBox checkBox, JFrame frame, int x, int y, int width, int height) {
		checkBox.setBounds(x, y, width, height);	
		checkBox.setForeground(Color.WHITE);
		checkBox.setBackground(Color.BLACK);
		checkBox.setFont(new Font("Arial", Font.PLAIN, 10));
		checkBox.setLayout(null);
		checkBox.setFocusable(false);
		frame.add(checkBox);
	}
				
	static void addButton(JButton button, JFrame frame, int x, int y, int width, int height) {
		button.setForeground(Color.BLACK);
		button.setFocusable(false);
		button.setBounds(x, y, width, height);
		frame.add(button);
	}
				
	static void frameColor(JFrame frame) {
		frame.getContentPane().setBackground(new Color(0x88AB8E));
	}
				
    static void removeComponents(JFrame frame){
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.revalidate();
    }

    static void removePanelComponents(JPanel panel){
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }
	
}