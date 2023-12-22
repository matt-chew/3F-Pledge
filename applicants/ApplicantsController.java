package scholarship.applicants;

import scholarship.Database.DataController;
import scholarship.adminMainTab.AdminMainTabController;
import scholarship.components.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ApplicantsController extends Components implements ActionListener {

    private final List<List<String>> data = DataController.listOfApplicants( "applicants" );

    JLabel[] userRequest;
    JButton[] acceptBtn;
    JButton[] declineBtn;

    // student scholarship list waiting for approval
    JPanel list = createContentPanel();
    JScrollPane scrollPane = new JScrollPane(list);
    
    JLabel applicantLogo = new JLabel("List of applicants");
    JPanel applicantList = new JPanel();


    public ApplicantsController(){

        // dev panel
        ApplicantsView.addPanel(window, divPanel, 157, 10, 925, 546, "#161A30");


        // admin panel
        ApplicantsView.addLabel(applicantList, applicantLogo, 0, 0, 690, 50, 40, true, 1);
        ApplicantsView.addPanelToPanel(divPanel, applicantList, 100, 50, 700, 450, "#FF90BC");
        ApplicantsView.addJScrollPane(applicantList, scrollPane, 10,50,680,390);

        if (data.size() <= 3) scrollPane.setBounds(10,100,680,100);
        else if (data.size() > 4) scrollPane.setBounds(10,50,680,390);

    }

    private JPanel createContentPanel() {

        userRequest = new JLabel[data.size()];
        acceptBtn = new JButton[data.size()];
        declineBtn = new JButton[data.size()];

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(data.size(), 3, 10,10));

        int num = 0;

        for(List<String> row : data){

            userRequest[num] = new JLabel(row.get(0) + " " + row.get(1) + " " + row.get(2));
            ApplicantsView.addLabel(panel, userRequest[num], 0, 100, 278, 40, 20, false, 0);

            acceptBtn[num] = new JButton("ACCEPT");
            ApplicantsView.addButton(panel, acceptBtn[num], 0, 100, 100, 60, 20, "#9ADE7B");
            acceptBtn[num].addActionListener(this);

            declineBtn[num] = new JButton("DECLINE");
            ApplicantsView.addButton(panel, declineBtn[num], 0, 100, 100, 60, 20, "#BE3144");
            declineBtn[num].addActionListener(this);

            num++;
        }

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    int num = 0;

        while(num < data.size()) {

            if (e.getSource() == acceptBtn[num]) {

                String getData = data.get(num).toString();
                DataController.acceptedScholars(getData.substring(1, getData.length()-1));
                data.remove(num);
                DataController.updateFile(data);

                refresh();

            }

            if(e.getSource() == declineBtn[num]){

                data.remove(num);
                DataController.updateFile(data);

                refresh();

            }

            ++num;
        }

    }

    void refresh(){

        ApplicantsView.removeComponents(window);
        ApplicantsView.removePanelComponents(divPanel);
        new ApplicantsController();
        new AdminMainTabController();
        window.repaint();
        window.revalidate();

    }

    void remove(){

        ApplicantsView.removeComponents(window);
        ApplicantsView.removePanelComponents(divPanel);

    }
}
