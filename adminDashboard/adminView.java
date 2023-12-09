package pledge.adminDashboard;

import javax.swing.*;
import java.awt.*;

 class adminView{
		static void addLabel(JLabel label, JFrame frame, int x, int y, int width, int height, String fontStyle, int fontSize) {
				label.setBounds(x, y, width, height);
				label.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
				label.setForeground(Color.WHITE);
				frame.add(label);
			}
	
			static void addPanel(JPanel panel, JFrame frame, int x, int y, int width, int height) {
				panel.setBounds(x,y,width,height);
				panel.setBackground(new Color(72,77,81));
				panel.setLayout(null);
				frame.add(panel);
			}
	
			
			static void addButton(JButton button, JFrame frame, int x, int y, int width, int height) {
					button.setForeground(Color.BLACK);
					button.setFocusable(false);
					button.setBackground(new Color(46,117,183));
					button.setBounds(x, y, width, height);
					frame.add(button);
			}

			

			static void addFrameColor(JFrame frame) {
				frame.getContentPane().setBackground(new Color(19,19,19));
			}
			
			static void clearFrame(JFrame frame) {
					frame.getContentPane().removeAll();
					frame.repaint();
					frame.validate();
				}
}