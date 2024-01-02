package scholarship.scolarshipApplicant;


import scholarship.Database.DataController;
import scholarship.components.Components;
import scholarship.login.LoginController;
import scholarship.maintab.MainTabController;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;


public class ScholarshipController extends Components implements ActionListener{

    // student info panels
    JPanel studentInfoDisplay = new JPanel();
    JLabel studentInfoLogo = new JLabel("STUDENT INFO");

    // Select Grade Level
    JLabel selectGradeLevelLb = new JLabel("GRADE LEVEL");
    private final String[] gradeLevel = {"1", "2", "3"};
    private final JComboBox<String> gradeLevelJCB = new JComboBox<>(gradeLevel);

    // Select Section
    JLabel selectSectionLb = new JLabel("SECTION");
    private final String[] section = {"A", "B", "C", "D", "E", "F"};
    private final JComboBox<String> sectionJCB = new JComboBox<>(section);

    // Display Area
    JTextArea studentInfo = new JTextArea();
    JScrollPane studentScrollPane = new JScrollPane(studentInfo);

    // List Button
    JButton listBtn = new JButton("List Student");

    // applicants panel
    JLabel scholar = new JLabel("SCHOLARS");
    JPanel applicantsPanels = new JPanel();
    JTextArea studentScholar = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(studentScholar);

    // Buttons
    JButton scholarshipBtn = new JButton("Scholars");
    JButton studentInfoBtn = new JButton("Student Info");
    JButton logoutBtn = new JButton("Logout");

    public ScholarshipController (){

        // Sidebar Panel
        ScholarshipView.addPanel(window, sideBarPanel, 5, 10, 150, 546, "#31304D");

        // dev panel
        ScholarshipView.addPanel(window, divPanel, 157, 10, 925, 546, "#161A30");

        // applicants panels
        ScholarshipView.addLabel(applicantsPanels, scholar, 0, 0, 550, 50, 40, true, 0);
        ScholarshipView.addPanelToPanel(divPanel, applicantsPanels, 150, 20, 600, 500, "#9BB8CD");
        ScholarshipView.addJScrollPane(applicantsPanels, scrollPane, 10,50,580,440);
        displayScholars();

        // buttons
        ScholarshipView.addButton(sideBarPanel, scholarshipBtn, 5, 20, 140, 40, 20, "#7C93C3");
        scholarshipBtn.addActionListener(this);

        ScholarshipView.addButton(sideBarPanel, studentInfoBtn, 5, 80, 140, 40, 20, "#7C93C3");
        studentInfoBtn.addActionListener(this);

        ScholarshipView.addButton(sideBarPanel, logoutBtn, 5, 500, 140, 40, 20, "#7C93C3");
        logoutBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == scholarshipBtn){

            ScholarshipView.removePanelComponents(divPanel);
            new ScholarshipController();

        }

        if(e.getSource() == studentInfoBtn){

            ScholarshipView.removePanelComponents(divPanel);
            studentInfoDisplay();

        }

        if(e.getSource() == listBtn){

            displayStudentInfo();

        }



        // remove frame, main, sidebar components
        if(e.getSource() == logoutBtn){

            ScholarshipView.removePanelComponents(divPanel);
            ScholarshipView.removePanelComponents(sideBarPanel);
            ScholarshipView.removeComponents(window);
            new LoginController();
            new MainTabController();

        }

    }

    void studentInfoDisplay (){

        // Student Info Layout
        ScholarshipView.addLabel(studentInfoDisplay, studentInfoLogo, 0, 0, 550, 40, 35, true, 0);
        ScholarshipView.addPanelToPanel(divPanel, studentInfoDisplay, 350, 60, 550, 460, "#9BB8CD");
        ScholarshipView.addJScrollPane(studentInfoDisplay, studentScrollPane, 10,40,520,400);
        ScholarshipView.jTextAreaDesign(studentInfo, 15);

        // grade level combo box
        ScholarshipView.addLabel(divPanel, selectGradeLevelLb, 10, 120, 150, 30, 20, true, 1);
        ScholarshipView.addJComboBox(divPanel, gradeLevelJCB, 10, 150, 150, 40);

        // section combo box
        ScholarshipView.addLabel(divPanel, selectSectionLb, 180, 120, 150, 30, 20, true, 1);
        ScholarshipView.addJComboBox(divPanel, sectionJCB, 180, 150, 150, 40);

        // button
        ScholarshipView.addButton(divPanel, listBtn, 20, 300, 300, 50, 25, "#1D5B79");
        listBtn.addActionListener(this);

    }


    /*
    *   get Data from Database
    *
    *   Store Data -> scholars
    *   Display Scholars
    *
    * */
    void displayScholars (){

        ScholarshipView.jTextAreaDesign(studentScholar, 23);

        List<List<String>> scholars = DataController.listOfApplicants( "scholars" );

        studentScholar.setText(" Name" + "\t" + " Lastname" + "\t" + " Section" + "\t" + " Batch" + "\n");
        for(List<String> row : scholars){

            studentScholar.append(row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\n");

        }

    }

    /*
     *   get Data from Database
     *
     *   Store Data -> listStudentScholars
     *   Display all information -> listStudentScholars
     *
     * */
    void displayStudentInfo (){

        List<List<String>> listStudentScholars = DataController.listOfScholarStudent(  getGradeLevel(), getSection() );

        studentInfo.setText(" ID" + "\t" + " NAME" + "\t" + " LASTNAME" + "\t" + " SECTION" + "\t" + " BATCH" + "\t" + " SCHOLAR" + "\n");
        for(List<String> row : listStudentScholars){

            studentInfo.append(row.get(0) + "\t" + row.get(1) + "\t" + row.get(2) + "\t" + row.get(3) + "\t" + row.get(4) + "\t" + row.get(5) + "\n");

        }

        if(!listStudentScholars.isEmpty()) listStudentScholars.clear();

    }

    String getSection (){

        return sectionJCB.getItemAt(sectionJCB.getSelectedIndex());

    }

    String getGradeLevel (){

        return gradeLevelJCB.getItemAt(gradeLevelJCB.getSelectedIndex());

    }

}
