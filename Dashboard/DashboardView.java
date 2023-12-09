package PledgeSystem.Dashboard;

import java.awt.*;
import javax.swing.*;

public class DashboardView {
			
			static void addLabel(JLabel label, JFrame frame, int x, int y, int width, int height, String fontStyle, int fontSize) {
				label.setBounds(x, y, width, height);
				label.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
				label.setForeground(Color.WHITE);
				frame.add(label);
			}
	
			static void addPanel(JPanel panel, JFrame frame, int x, int y, int width, int height) {
				panel.setBounds(x,y,width,height);
				frame.add(panel);
			}
	
			
			static void addButton(JButton button, JFrame frame, int x, int y, int width, int height) {
					button.setForeground(Color.BLACK);
					button.setFocusable(false);
					button.setBounds(x, y, width, height);
					frame.add(button);
			}

			

			static void addFrameColor(JFrame frame) {
				frame.getContentPane().setBackground(new Color(0x131313));
			}
			
			static void clearFrame(JFrame frame) {
					frame.getContentPane().removeAll();
					frame.repaint();
					frame.validate();
				}
}