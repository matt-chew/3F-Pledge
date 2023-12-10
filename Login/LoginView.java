package PledgeSystem.Login;

import javax.swing.*;
import java.awt.*;

class LoginView{

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

    static void addPasswordField(JPanel panel, JPasswordField passwordField, int x, int y, int width, int height, int sizeText){
        passwordField.setBounds(x,y,width,height);
        passwordField.setFont(new Font("Monospace", Font.PLAIN, sizeText));
        passwordField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.WHITE));
        passwordField.setForeground(Color.WHITE);
        passwordField.setOpaque(false);
        panel.add(passwordField);
    }

    static void addCheckBox(JPanel panel, JCheckBox box, int x, int y){
        box.setBounds(x,y,200,15);
        box.setText("Show Password");
        box.setFont(new Font("Monospace", Font.BOLD, 18));
        box.setForeground(Color.WHITE);
        box.setLayout(null);
        box.setBackground(null);
        box.setFocusable(false);
        panel.add(box);
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