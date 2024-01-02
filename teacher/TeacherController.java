package scholarship.teacher;

import scholarship.Database.DataController;
import scholarship.components.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TeacherController extends Components implements MouseListener {

    JLabel registerTeacherLogo;
    JPanel registerTeacherPanel = new JPanel();

    JLabel listOfTeacherLogo;
    JPanel listOfTeacherPanel = new JPanel();

    JPanel componentsPanel = new JPanel();

    JTextArea teachersList = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(teachersList);

    JLabel nameLb;
    JTextField nameTf;

    JLabel lastnameLb;
    JTextField lastnameTf;

    JLabel usernameLb;
    JTextField usernameTf;

    JLabel passwordLb;
    JTextField passwordTf;

    JButton createBtn;

    public TeacherController (){

        // main panel
        TeacherView.addPanel(window, divPanel, 157, 10, 925, 546, "#161A30");

        // Add Teacher
        registerTeacherLogo = new JLabel("ADD TEACHER"); registerTeacherLogo.setForeground(Color.WHITE);
        TeacherView.addLabel(registerTeacherPanel, registerTeacherLogo, 0, 0, 300, 60, 30, true, 1);
        TeacherView.addPanelToPanel(divPanel, registerTeacherPanel, 150, 50, 300, 60, "#711DB0");
        registerTeacherPanel.addMouseListener(this);

        // List all Teacher
        listOfTeacherLogo = new JLabel("LIST TEACHERS"); listOfTeacherLogo.setForeground(Color.WHITE);
        TeacherView.addLabel(listOfTeacherPanel, listOfTeacherLogo, 0, 0, 300, 60, 30, true, 1);
        TeacherView.addPanelToPanel(divPanel, listOfTeacherPanel, 450, 50, 300, 60, "#B06161");
        listOfTeacherPanel.addMouseListener(this);

        // sub panel
        TeacherView.addPanelToPanel(divPanel, componentsPanel, 150, 110, 600, 400, "#F2FFE9");


        registerTeacher(); // Display Register Components

        // change background Color
        registerTeacherPanel.setBackground(Color.decode("#F2FFE9"));
        registerTeacherLogo.setForeground(Color.GRAY);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == createBtn){

            /*
            *   check name, lastname, username, password Field not empty
            *
            *   store account details data to a Database
            *
            *   clear all text in the account details
            * */
            if( !nameTf.getText().isEmpty() && !lastnameTf.getText().isEmpty()
                    && !usernameTf.getText().isEmpty() && !passwordTf.getText().isEmpty() ){

                DataController.inputTeachersData(usernameTf.getText(), passwordTf.getText(), nameTf.getText(), lastnameTf.getText());
                clearText();

            }else authenticationIsBlank(); // if one of the Blank is empty change Line Color to Red

        }

        if(e.getSource() == registerTeacherPanel){

            TeacherView.removePanelComponents(componentsPanel);
            registerTeacher();

        }

        if(e.getSource() == listOfTeacherPanel){

            TeacherView.removePanelComponents(componentsPanel);
            displayTeachers();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getSource() == registerTeacherPanel) {

            registerTeacherPanel.setBackground(Color.decode("#F2FFE9"));
            registerTeacherLogo.setForeground(Color.GRAY);

            listOfTeacherPanel.setBackground(Color.decode("#B06161"));
            listOfTeacherLogo.setForeground(Color.WHITE);
        }

        if(e.getSource() == listOfTeacherPanel){

            listOfTeacherPanel.setBackground(Color.decode("#F2FFE9"));
            listOfTeacherLogo.setForeground(Color.GRAY);

            registerTeacherPanel.setBackground(Color.decode("#711DB0"));
            registerTeacherLogo.setForeground(Color.WHITE);

        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    void registerTeacher (){

        // name
        nameLb = new JLabel("Name");
        TeacherView.addLabel(componentsPanel, nameLb, 30, 40, 230, 20, 20, true, 1);

        nameTf = new JTextField();
        TeacherView.addJTextField(componentsPanel, nameTf, 30, 60, 230, 30, 20);


        // lastname
        lastnameLb = new JLabel("Lastname");
        TeacherView.addLabel(componentsPanel, lastnameLb, 30, 150, 230, 20, 20, true, 1);

        lastnameTf = new JTextField();
        TeacherView.addJTextField(componentsPanel, lastnameTf, 30, 170, 230, 30, 20);


        // username
        usernameLb = new JLabel("Username");
        TeacherView.addLabel(componentsPanel, usernameLb, 320, 40, 230, 20, 20, true, 1);

        usernameTf = new JTextField();
        TeacherView.addJTextField(componentsPanel, usernameTf, 320, 60, 230, 30, 20);


        // password
        passwordLb = new JLabel("Password");
        TeacherView.addLabel(componentsPanel, passwordLb, 320, 150, 230, 20, 20, true, 1);

        passwordTf = new JTextField();
        TeacherView.addJTextField(componentsPanel, passwordTf, 320, 170, 230, 30, 20);


        // button
        createBtn = new JButton("Create");
        TeacherView.addButton(componentsPanel, createBtn, 150, 250, 300, 60, 25, "#321E1E");
        createBtn.addMouseListener(this);

    }

    void jTextAreaDesign (){

        teachersList.setEditable(false);
        teachersList.setFont(new Font("Monospace", Font.PLAIN, 30));
        teachersList.setBackground(Color.decode("#67729D"));
        teachersList.setForeground(Color.WHITE);

    }

    void authenticationIsBlank (){

        if(nameTf.getText().isEmpty()) nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.RED));
        else nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));

        if(lastnameTf.getText().isEmpty()) lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.RED));
        else lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));

        if(usernameTf.getText().isEmpty()) usernameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.RED));
        else usernameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));

        if(passwordTf.getText().isEmpty()) passwordTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.RED));
        else passwordTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));

    }

    void clearText (){

        nameTf.setText(null);
        lastnameTf.setText(null);
        usernameTf.setText(null);
        passwordTf.setText(null);

        nameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));
        lastnameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));
        usernameTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));
        passwordTf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.BLACK));

    }

    void displayTeachers (){

        TeacherView.addJScrollPane(componentsPanel, scrollPane, 10, 10, 580, 380);

        jTextAreaDesign();


        // get Data from Database and store it in 2D ArrayList
        java.util.List<java.util.List<String>> data = DataController.listOfApplicants( "teachers" );

        teachersList.setText(" STATUS" + "\t" + "NAME:" + "\t" + "LASTNAME:" + "\n");

        // Display Data in TeacherList
        for(List<String> row : data){

            teachersList.append(" " + row.get(0) + "\t" + row.get(3) + "\t" + row.get(4) + "\n");

        }

    }

}
