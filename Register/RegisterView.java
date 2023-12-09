package PledgeSystem.Register;

import javax.swing.*;
import java.awt.*;

class RegisterView{

    static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int height, String color){
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.decode(color));
        panel.setLayout(null);
        frame.add(panel);
    }

    static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int sizeText, Boolean alignment){
        label.setBounds(x,y, width,height);
        label.setFont(new Font("Monospace", Font.PLAIN, sizeText));
        label.setForeground(Color.WHITE);
        
        if(alignment){
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
        }

        panel.add(label);
    }

    static void addTextField(JPanel panel, JTextField textField, int x, int y, int width, int height , int sizeText){
        textField.setBounds(x,y,width,height);
        textField.setFont(new Font("Monospace", Font.PLAIN, sizeText));
        textField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.WHITE));
        textField.setForeground(Color.WHITE);
        textField.setOpaque(false);
        panel.add(textField);
    }

    static void addButton(JPanel panel, JButton button, int x, int y, int width, int height, int sizeFont, String color){
        button.setBounds(x,y,width,height);
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode(color));
        button.setFont(new Font("Monospace",Font.PLAIN,sizeFont));
        button.setBorder(null);
        panel.add(button);
    }

    static void removePanelComponents(JPanel panel){
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }
}
