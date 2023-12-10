package PledgeSystem.Payment;

import java.awt.*;
import javax.swing.*;

public class PaymentView {
		
	static void addLabel(JLabel label, JFrame frame, int x, int y, int width, int height, String fontStyle, int fontSize, boolean center) {
		label.setBounds(x, y, width, height);
		label.setForeground(Color.WHITE);
		label.setFont(new Font(fontStyle, Font.PLAIN , fontSize));
		if(center) {
			label.setHorizontalAlignment(JLabel.CENTER);
		} else {
			label.setHorizontalAlignment(JLabel.LEFT);
		}
					
		frame.add(label);
	}
	
	static void addLineTextField(JTextField textField, JFrame frame, int x, int y, int width, int height, String fontStyle, int fontSize) {
		textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
		textField.setBackground(new Color(0x131313));
		textField.setForeground(Color.WHITE);
		textField.setBounds(x, y, width, height);
		textField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE));
		frame.add(textField);
	}
			
	static void addLinePasswordField(JPasswordField passField, JFrame frame, int x, int y, int width, int height) {
		Color labelColor = Color.WHITE;
		passField.setBackground(new Color(0x131313));
		passField.setForeground(Color.WHITE);
		passField.setBounds(x, y, width, height);
		passField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, labelColor));
		frame.add(passField);
	}
			
	static void addButton(JButton button, JFrame frame, int x, int y, int width, int height) {
		button.setForeground(Color.BLACK);
		button.setFocusable(false);
		button.setBounds(x, y, width, height);
		frame.add(button);
	}
	
	static void addCheckBox(JCheckBox checkBox, JFrame frame, int x, int y, int width, int height) {
		checkBox.setBounds(x, y, width, height);
		checkBox.setBackground(new Color(0x131313));
		checkBox.setForeground(Color.WHITE);
		checkBox.setFont(new Font("Arial", Font.PLAIN, 13));
		checkBox.setLayout(null);
		checkBox.setFocusable(false);
		frame.add(checkBox);
	}
			
	static void addFrameColor(JFrame frame) {
	    frame.getContentPane().setBackground(new Color(0x131313));
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
