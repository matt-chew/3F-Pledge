package pledge.registrar;

import javax.swing.*;
import java.awt.*;

 class RegistrarView{
		static void addLabel(JLabel label, JFrame frame,String text, int x, int y, int width, int height, int fontSize,boolean center) {
				label.setBounds(x, y, width, height);
				label.setText(text);
				label.setFont(new Font("inter", Font.PLAIN, fontSize));
				if(center) {
						label.setHorizontalAlignment(JLabel.CENTER);
					} else {
						label.setHorizontalAlignment(JLabel.LEFT);
					}
					
				label.setForeground(Color.WHITE);
				frame.add(label);
			}
	
			static void addPanel(JPanel panel, JFrame frame, int x, int y, int width, int height,Color color) {
				panel.setBounds(x,y,width,height);
				panel.setBackground(color);
				panel.setLayout(null);
				frame.add(panel);
			}
			static void addTextField(JTextField textField, JFrame frame, int x, int y, int width, int height, int fontSize) {
					textField.setBounds(x, y, width, height);
					textField.setFont(new Font("inter", Font.PLAIN, fontSize));
					textField.setForeground(Color.WHITE);
					textField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.WHITE));
					textField.setBackground(new Color(44,44,44));
					frame.add(textField);
				}
	
			
			static void addButton(JButton button, JFrame frame, int x, int y, int width, int height,int fontSize) {
					button.setForeground(Color.BLACK);
					button.setFont(new Font("inter",Font.PLAIN,fontSize));
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