package scholarship.student;

import scholarship.Database.DataController;
import scholarship.components.Components;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentController extends Components {

    JPanel subPanel = new JPanel();

    JLabel studentListLogo = new JLabel("LIST OF ALL STUDENT");

    JTextArea studentList = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(studentList);

    public StudentController (){

        // main panel
        StudentView.addPanel(window, divPanel, 157, 10, 925, 546, "#161A30");

        // sub panel
        StudentView.addLabel(subPanel, studentListLogo, 0, 0, 790, 60, 45, true, 1);
        StudentView.addPanelToPanel(divPanel, subPanel, 60, 30, 800, 500, "#EEEDED");
        displayStudents();

    }

    void jTextAreaDesign (){

        studentList.setEditable(false);
        studentList.setFont(new Font("Monospace", Font.PLAIN, 15));
        studentList.setBackground(Color.decode("#67729D"));
        studentList.setForeground(Color.WHITE);

    }

    /*
    *   get Data from Database
    *
    *   Store it in Scholars -> Data
    *   Display Scholars
    *
    * */

    void displayStudents (){

        StudentView.addJScrollPane(subPanel, scrollPane, 20, 60, 760, 430);

        jTextAreaDesign();

        java.util.List<java.util.List<String>> scholars = DataController.listOfApplicants( "scholars" );

        studentList.setText(" ID:" + "\t" + " NAME:" + "\t" + " LASTNAME:" + "\t" + " SECTION:" + "\t" + " BATCH:" + "\t" + " SCHOLARSHIP:" + "\n");
        for(List<String> row : scholars){

            studentList.append(" " + row.get(0) + "\t" + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t" + row.get(5) + "\n");

        }

    }

}
