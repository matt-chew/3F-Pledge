package scholarship.maintab;

import scholarship.components.Components;
import scholarship.login.LoginController;
import scholarship.teacherlogin.TeacherLoginController;

import javax.swing.*;
import java.awt.event.*;

public class MainTabController extends Components implements MouseListener {
    
    JPanel sidePanel = new JPanel();
    
    JLabel studentBtn = new JLabel(studentBtnImage);

    JLabel teacherBtn = new JLabel(teacherBtnImage);


    public MainTabController (){

        MainTabView.addPanelToPanel(divPanel, sidePanel, 10, 10, 30, 30, "#EEEDED");
        sidePanel.addMouseListener(this);

        MainTabView.addLabel(sidePanel, studentBtn, 0, 40, 200, 40, 15, false, 0);
        studentBtn.addMouseListener(this);

        MainTabView.addLabel(sidePanel, teacherBtn, 0, 90, 200, 40, 15, false, 0);
        teacherBtn.addMouseListener(this);


    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == studentBtn) {

            MainTabView.removePanelComponents(divPanel);
            MainTabView.removeComponents(window);
            new MainTabController();
            new LoginController();

        }

        if(e.getSource() == teacherBtn) {

            MainTabView.removePanelComponents(divPanel);
            MainTabView.removeComponents(window);
            new MainTabController();
            new TeacherLoginController();

        }

        if(e.getSource() == sidePanel) sidePanel.setBounds(10, 10, 200, 150);



    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getSource() == studentBtn) studentBtn.setIcon(studentBtnImageClicked);

        if(e.getSource() == teacherBtn) teacherBtn.setIcon(teacherBtnImageClicked);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if(e.getSource() == studentBtn) studentBtn.setIcon(studentBtnImage);

        if(e.getSource() == teacherBtn) teacherBtn.setIcon(teacherBtnImage);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
