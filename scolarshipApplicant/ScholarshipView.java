package scholarship.scolarshipApplicant;

import javax.swing.*;
import java.awt.*;

class ScholarshipView {

    static void addButton (JPanel panel, JButton button, int x, int y, int width, int height, int sizeFont, String color){
        button.setBounds(x,y,width,height);
        button.setFocusable(false);
        button.setForeground(Color.decode("#FAF6F0"));
        button.setBackground(Color.decode(color));
        button.setFont(new Font("monospace",Font.PLAIN,sizeFont));
        button.setBorder(null);
        panel.add(button);
    }

    static void addLabel (JPanel panel, JLabel label, int x, int y, int width, int height, int sizeText, Boolean alignment, int font){
        label.setBounds(x,y, width,height);
        label.setFont(new Font("monospace", font, sizeText));
        label.setForeground(Color.WHITE);

        if(alignment){
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
        }

        panel.add(label);
    }

    static void jTextAreaDesign (JTextArea area, int fontSize){
        area.setEditable(false);
        area.setFont(new Font("Monospace", Font.PLAIN, fontSize));
        area.setBackground(Color.decode("#67729D"));
        area.setForeground(Color.WHITE);
    }


    static void addPanel (JFrame frame, JPanel panel, int x, int y, int width, int height, String color){
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.decode(color));
        panel.setLayout(null);
        frame.add(panel);
    }

    static void addJComboBox (JPanel panel, JComboBox<String> comboBox, int x, int y, int width, int height){
        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        comboBox.setRenderer(listRenderer);
        comboBox.setBounds(x, y, width, height);
        comboBox.setFont(new Font("Monospace", Font.BOLD, 20));
        comboBox.setMaximumRowCount(3);
        comboBox.setSelectedIndex(-1);
        comboBox.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        comboBox.setFocusable(false);
        panel.add(comboBox);
    }

    static void addPanelToPanel (JPanel mainPanel, JPanel panel, int x, int y, int width, int height, String color){

        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.decode(color));
        panel.setLayout(null);
        mainPanel.add(panel);

    }

    static void addJScrollPane (JPanel panel, JScrollPane scrollPane, int x, int y, int width, int height){

        scrollPane.setBounds(x, y, width, height);
        panel.add(scrollPane);

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
