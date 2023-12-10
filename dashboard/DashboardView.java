package dashboard;

import java.awt.*;
import javax.swing.*;

class DashboardView {

	static void addJTextField (JPanel panel, JTextField textField, int x, int y, int width, int height , int sizeText){
		textField.setBounds(x,y,width,height);
		textField.setFont(new Font("monospace", Font.PLAIN, sizeText));
		textField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));
		textField.setOpaque(false);
		panel.add(textField);
	}

	static void addButton (JPanel panel, JButton button, int x, int y, int width, int height, int sizeFont, String color){
		button.setBounds(x,y,width,height);
		button.setFocusable(false);
		button.setForeground(Color.decode("#FAF6F0"));
		button.setBackground(Color.decode(color));
		button.setFont(new Font("monospace",Font.PLAIN,sizeFont));
		button.setBorder(null);
		panel.add(button);
	}

	static void addLabel (JPanel panel, JLabel label, int x, int y, int width, int height, int sizeText, Boolean alignment, int font, String color){
		label.setBounds(x,y, width,height);

		label.setFont(new Font("monospace", font, sizeText));
		label.setForeground(Color.decode(color));

		if(alignment){
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
		}

		panel.add(label);
	}

	static void addPanelToPanel (JPanel mainPanel, JPanel panel, int x, int y, int width, int height, String color){

		panel.setBounds(x, y, width, height);
		panel.setBackground(Color.decode(color));
		panel.setLayout(null);
		mainPanel.add(panel);

	}

	static void addJTextArea (JPanel panel, JTextArea area, int x, int y, int width, int height){

		area.setBounds(x, y, width, height);
		area.setEditable(false);
		area.setFont(new Font("Monospace", Font.PLAIN, 25));
		area.setBackground(Color.decode("#67729D"));
		area.setForeground(Color.WHITE);
		panel.add(area);

	}

	static void removeComponents (JFrame frame){
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