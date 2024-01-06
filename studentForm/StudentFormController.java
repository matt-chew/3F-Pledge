package scholarship.studentForm;

import scholarship.Database.DataController;
import scholarship.components.Components;
import scholarship.login.LoginController;
import scholarship.maintab.MainTabController;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

public class StudentFormController extends Components implements ActionListener {
    
    String username;
    
    private final String[] section = {  "1A", "1B", "1C", "1D", "1E", "1F",
                                        "2A", "2B", "2C", "2D", "2E", "2F",
                                        "3A", "3B", "3C", "3D", "3E", "3F" };

    JLabel sectionLb = new JLabel("Section & Batch");
    final JComboBox<String> sectionJCB = new JComboBox<>(section);

    private final String[] batch = {"Batch 31", "Batch 32", "Batch 33", "Batch 34"};
    private final JComboBox<String> batchJCB = new JComboBox<>(batch);

    JLabel scholarshipLb = new JLabel("SCHOLARSHIP");
    private final String[] scholarship = {"JayJoe Enterprises Scholarship", "Bacalla Bakery Scholarship", "Fund For Bata Scholarship", "JamePaul Engineering Program"};
    private final JComboBox<String> scholarshipJCB = new JComboBox<>();





    JPanel formPanel = new JPanel();
    JLabel formLogo = new JLabel("Scholarship Form");

    JLabel nameLb = new JLabel("Name");
    JTextField nameTf = new JTextField();

    JLabel lastnameLb = new JLabel("Lastname");
    JTextField lastnameTf = new JTextField();


    JButton submitBtn = new JButton("Submit");

    JButton logoutBtn = new JButton("Logout");


    public StudentFormController (String username) {
        
        this.username = username;

        calendar(); // display scholarship Available base on month

        // side panel
        StudentFormView.addPanel(window, sideBarPanel, 5, 10, 150, 546, "#31304D");

        // dev panel
        StudentFormView.addPanel(window, divPanel, 157, 10, 925, 546, "#161A30");

        // form panel
        StudentFormView.addLabel(formPanel, formLogo, 0, 0, 600, 60, 40, true, 1);
        StudentFormView.addPanelToPanel(divPanel, formPanel, 200, 20, 550, 500, "#9BB8CD");

        // name
        StudentFormView.addLabel(formPanel, nameLb, 5, 100, 190, 30, 30, true, 0);
        StudentFormView.addJTextField(formPanel, nameTf, 210, 100, 300, 40, 20);

        // lastname
        StudentFormView.addLabel(formPanel, lastnameLb, 5, 170, 190, 30, 30, true, 0);
        StudentFormView.addJTextField(formPanel, lastnameTf, 210, 170, 300, 40, 20);

        // select scholarship Applicants
        StudentFormView.addLabel(formPanel, scholarshipLb, 5, 230, 190, 30, 20, true, 1);
        StudentFormView.addJComboBox(formPanel, scholarshipJCB, 210, 230, 300, 35);


        // select Section And Batch
        StudentFormView.addLabel(formPanel, sectionLb, 5, 280, 190, 30, 20, true, 1);
        StudentFormView.addJComboBox(formPanel, sectionJCB, 230, 280, 120, 30);
        StudentFormView.addJComboBox(formPanel, batchJCB, 370, 280, 120, 30);


        // submit button
        StudentFormView.addButton(formPanel, submitBtn, 210, 380, 300, 60, 30, "#7C93C3");
        submitBtn.addActionListener(this);

        // logout button
        StudentFormView.addButton(sideBarPanel, logoutBtn, 5, 500, 140, 40, 20, "#7C93C3");
        logoutBtn.addActionListener(this);



    }

    public void actionPerformed(ActionEvent e){

        /*
         *   check Personal details if not empty
         *
         *   Store all Personal details to Database
         *
         *   Display pop-up Successfully apply for Scholarship
         *
         * */

        if(e.getSource() == submitBtn){

            if ( !nameTf.getText().isEmpty() && !lastnameTf.getText().isEmpty() && getSectionSelected() != null && getBatchSelected() != null && getScholarship() != null){

                DataController.scholarshipApplicants(   username, nameTf.getText(), lastnameTf.getText(), getSectionSelected(),
                                                        getBatchSelected(), getScholarship());

                JOptionPane.showMessageDialog(null, " Your application has been Saved ", " Save ", JOptionPane.INFORMATION_MESSAGE);
                clearTextField();

            }

        }

        /*
         *   remove all components
         *
         *   Display Login Panel
         *   Display Tab Panel
         * */

        if(e.getSource() == logoutBtn){

            StudentFormView.removeComponents(window);
            StudentFormView.removePanelComponents(divPanel);
            StudentFormView.removePanelComponents(sideBarPanel);
            new LoginController();
            new MainTabController();

        }

    }

    String getSectionSelected (){

       return sectionJCB.getItemAt(sectionJCB.getSelectedIndex());

    }

    String getBatchSelected (){

        return batchJCB.getItemAt(batchJCB.getSelectedIndex());

    }

    String getScholarship (){

        return scholarshipJCB.getItemAt(scholarshipJCB.getSelectedIndex());

    }


    void clearTextField (){

        nameTf.setText(null);
        lastnameTf.setText(null);
        sectionJCB.setSelectedIndex(-1);
        batchJCB.setSelectedIndex(-1);
        scholarshipJCB.setSelectedIndex(-1);

    }

    /*
    *   Get current Month
    *
    *   Sets the specific scholarship based on the given month.
    *
    *   January, February, March            -> JayJoe Enterprises Scholarship
    *   April, May, June                    -> Bacalla Bakery Scholarship
    *   July, August, September             -> Fund For Bata Scholarship
    *   October, November, and December     -> JamePaul Engineering Program
    *
    * */

     void calendar(){

        Calendar date = Calendar.getInstance();

        int calendarMonth = date.get(Calendar.MONTH);

        if(calendarMonth == 0 || calendarMonth == 1 || calendarMonth == 2){
            scholarshipJCB.removeAll();
            scholarshipJCB.addItem(scholarship[0]);
        }
        else if(calendarMonth == 3 || calendarMonth == 4 || calendarMonth == 5){
            scholarshipJCB.removeAll();
            scholarshipJCB.addItem(scholarship[1]);
        }
        else if(calendarMonth == 6 || calendarMonth == 7 || calendarMonth == 8){
            scholarshipJCB.removeAll();
            scholarshipJCB.addItem(scholarship[2]);
        }
        else if(calendarMonth == 9 || calendarMonth == 10 || calendarMonth == 11){
            scholarshipJCB.removeAll();
            scholarshipJCB.addItem(scholarship[3]);
        }

    }

}
