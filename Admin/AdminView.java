package PledgeSystem.Admin;

import javax.swing.*;
import java.awt.*;

public class AdminView {
	
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
				
				static void addTextField(JTextField textField, JFrame frame, int x, int y, int width, int height, String fontStyle, int fontSize) {
					textField.setBounds(x, y, width, height);
					textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
					textField.setForeground(Color.WHITE);
					textField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.WHITE));
					textField.setBackground(new Color(0x2c2c2c));
					frame.add(textField);
				}
				
				static void addPanel(JPanel panel, JFrame frame, int x, int y, int width, int height) {
					panel.setLayout(null);
					panel.setBounds(x, y, width, height);
					frame.add(panel);
				}
				
				static void addButton(JButton button, JFrame frame, int x, int y, int width, int height) {
					button.setBounds(x, y, width, height);
					button.setForeground(Color.WHITE);
					button.setFocusable(false);
					frame.add(button);
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
