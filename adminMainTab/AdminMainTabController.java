package scholarship.adminMainTab;


import scholarship.applicants.ApplicantsController;
import scholarship.components.Components;
import scholarship.login.LoginController;
import scholarship.maintab.MainTabController;
import scholarship.student.StudentController;
import scholarship.teacher.TeacherController;

import javax.swing.*;
import java.awt.event.*;

public class AdminMainTabController extends Components implements ActionListener {

    JButton applicantsBtn;
    JButton teacherBtn;
    JButton studentBtn;
    JButton logoutBtn;

    public AdminMainTabController (){

        // main panel
        AdminMainTabView.addPanel(window, divPanel, 157, 10, 925, 546, "#161A30");

        // sidebar
        AdminMainTabView.addPanel(window, sideBarPanel, 10, 10, 140, 546, "#161A30");

        // buttons
        applicantsBtn = new JButton("Applicants");
        AdminMainTabView.addButton(sideBarPanel, applicantsBtn, 10, 20, 120, 50, 20, "#7ED7C1");
        applicantsBtn.addActionListener(this);

        teacherBtn = new JButton("Teacher");
        AdminMainTabView.addButton(sideBarPanel, teacherBtn, 10, 80, 120, 50, 20, "#7ED7C1");
        teacherBtn.addActionListener(this);

        studentBtn = new JButton("Student");
        AdminMainTabView.addButton(sideBarPanel, studentBtn, 10, 140, 120, 50, 20, "#7ED7C1");
        studentBtn.addActionListener(this);

        logoutBtn = new JButton("Logout");
        AdminMainTabView.addButton(sideBarPanel, logoutBtn, 10, 470, 120, 50, 20, "#7ED7C1");
        logoutBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == applicantsBtn){

            remove();
            new ApplicantsController();

        }

        if(e.getSource() == teacherBtn){


            remove();
            new TeacherController();

        }

        if(e.getSource() == studentBtn){

            remove();
            new StudentController();

        }

        if(e.getSource() == logoutBtn){

            remove();
            AdminMainTabView.removeComponents(window);
            AdminMainTabView.removePanelComponents(sideBarPanel);

            new LoginController();
            new MainTabController();

        }

    }

    void remove(){

        AdminMainTabView.removePanelComponents(divPanel);

    }

}
