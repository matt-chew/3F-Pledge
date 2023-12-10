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

	static void addButton(JFrame frame, JButton button, int x, int y, int width, int height, int sizeFont){
      	button.setBounds(x,y,width,height);
        button.setFocusable(false);
    //    button.setForeground(Color.WHITE);
    //    button.setBackground(Color.BLACK);
        button.setFont(new Font("Monospace",Font.PLAIN,sizeFont));
        button.setBorder(null);
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