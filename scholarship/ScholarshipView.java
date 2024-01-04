package scholarship;

import javax.swing.*;
import java.awt.*;

class ScholarshipView {

    static void addLabel(JLabel label, JPanel panel, int x, int y, int width, int height, String fontStyle, int fontSize, boolean center) {
        label.setBounds(x, y, width, height);
        label.setForeground(Color.BLACK);
        label.setFont(new Font(fontStyle, Font.PLAIN , fontSize));

        if(center) {
            label.setHorizontalAlignment(JLabel.CENTER);
        } else {
            label.setHorizontalAlignment(JLabel.LEFT);
        }

        panel.add(label);
    }

    static void addTextField(JTextField textField, JPanel panel, int x, int y, int width, int height) {
        textField.setBounds(x, y, width, height);
        panel.add(textField);

    }

    static void addCheckBox(JCheckBox checkBox, JPanel panel, int x, int y, int width, int height) {
        checkBox.setBounds(x, y, width, height);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(Color.BLACK);
        checkBox.setFont(new Font("Arial", Font.PLAIN, 10));
        checkBox.setLayout(null);
        checkBox.setFocusable(false);
        panel.add(checkBox);
    }

    static void addButton(JButton button, JPanel panel, int x, int y, int width, int height) {
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.setBounds(x, y, width, height);
        panel.add(button);
    }

    static void addPanelToPanel(JPanel mainPanel, JPanel panel, int x, int y, int width, int height, String color){

        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.decode(color));
        panel.setLayout(null);
        mainPanel.add(panel);

    }

    static void clearpanel(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.validate();
    }

}
