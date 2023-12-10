package scholarship;

import components.Components;

import javax.swing.*;
import java.awt.*;

public class ScholarshipController extends Components{
			JPanel formPanel;
			JPanel sidePanel;
			JPanel criteriaPanel;
			JTextField firstname;
			JTextField lastname;
			JTextField dateText;
			JTextField emailText;
			JTextField phoneText;
			JTextField addressText;
			JCheckBox maleBox;
			JCheckBox femaleBox;
			JCheckBox agreementBox;
			JButton submitButton;
			JButton dashboardButton;
			JButton paymentButton;
			JButton adminButton;
			JButton exitButton;
			JButton scholarshipButton;
			
	
	public ScholarshipController() {
			
		
			JLabel scholarshipLabel = new JLabel("SCHOLARSHIP APPLICATION FORM");
			scholarshipView.addLabel(scholarshipLabel, window, 350, 0, 560, 40, "Arial", 32, true);
			
			JLabel studentLabel = new JLabel("STUDENT NAME:");
			scholarshipView.addLabel(studentLabel, window, 230, 70, 100, 20, "Arial", 10, false);
			
			JLabel firstnameLabel = new JLabel("(firstname)");
			scholarshipView.addLabel(firstnameLabel, window, 340, 90, 100, 20, "Arial", 10, false);
			
			JLabel lastnameLabel = new JLabel("(lastname)");
			scholarshipView.addLabel(lastnameLabel, window, 450, 90, 100, 20, "Arial", 10, false);
			
			JLabel dateLabel = new JLabel("DATE OF BIRTH:");
			scholarshipView.addLabel(dateLabel, window, 230, 120, 100, 20, "Arial", 10, false);
			
			JLabel genderLabel = new JLabel("GENDER:");
			scholarshipView.addLabel(genderLabel, window, 230, 170, 100, 20, "Arial", 10, false);
			
			JLabel emailLabel = new JLabel("EMAIL ADDRESS:");
			scholarshipView.addLabel(emailLabel, window, 230, 220, 100, 20, "Arial", 10, false);
			
			JLabel phnoeLabel = new JLabel("PHONE NUMBER:");
			scholarshipView.addLabel(phnoeLabel, window, 230, 270, 100, 20, "Arial", 10, false);
			
			JLabel addressLabel = new JLabel("ADDRESS:");
			scholarshipView.addLabel(addressLabel, window, 230, 320, 100, 20, "Arial", 10, false);
			
			JLabel aggrementLabel = new JLabel("<html>This scholarship application form does not guarantee the award of <br> a scholarship.The selection process is"
					+ "competitive, and only a <br> limited number of scholarships may be awarded based on <br> predetermined criteria.Meeting eligibility requirements does not <br> ensure selection. By submitting this application, you acknowledge <br>and agree to these terms.<html>");
			scholarshipView.addLabel(aggrementLabel, window, 230, 337, 500, 100, "Arial", 10, false);
			
			JLabel criteriaLabel = new JLabel("<html>The following criteria will be considered in the evaluation of scholarship applications.<br> Applicants"
					+ "will be assessed based on the information provided and supporting documents submitted.The Scholarship Committee reserves the right to modify or adjust the criteria as needed."
					+ "<br>1.Academic Performance: <br> -Grade Point Average (GPA)<br>"
					+ "-Academic achievements<br>"
					+ "-Class rank (if applicable)"
					+ "<br> 2.Behavior and Conduct: <br> -Demonstrated positive behavior and ethical conduct<br>"
					+ "-Respect for peers, teachers, and staff<br>"
					+ "-Record of responsible and considerate behavior"
					+ "<br> 3.School Involvement: <br> -Participation in extracurricular activities<br>"
					+ "-Involvement in school clubs, organizations, or sports<br>"
					+ "-Contributions to the school community"
					+ "<br> 4.Performance in School: <br> -Consistent attendance and punctuality<br>"
					+ "-Active engagement in class activities<br>"
					+ "-Demonstrated effort and dedication to academic pursuits"
					+ "<br> 4.Time Management: <br> -Efficient use of time for academic and extracurricular activities<br>"
					+ "-Ability to balance school responsibilities with other commitments<br>"
					+ "-Effective organization and planning skills"
					+ "<br> 6.Offenses and Disciplinary Record: -<br> Absence of serious disciplinary offenses<br>"
					+ "-Positive disciplinary record <br>"
					+ "-Adherence to school rules and code of conduct"
					+ "<br> 7.Attitude and Character: <br> -Demonstrated positive attitude toward learning and personal growth<br>"
					+ "-Displays of perseverance and resilience in overcoming challenges<br>"
					+ "-Consideration of others and commitment to community service"
					+ "<br> 8.Financial Need: <br> -Statement of financial need and any relevant supporting documentation<br>"
					+ "-Willingness to disclose and discuss financial circumstances"
					+ "<br> Applicants will be evaluated comprehensively, and the Scholarship Committee will consider the overall alignment of an applicant with these criteria. Meeting all criteria does not guarantee the award of a scholarship, as the decision remains at the discretion of the Scholarship Committee.\r\n"
					+ "Applicants are encouraged to provide detailed information and any supporting documents that demonstrate their achievements, behavior, and commitment to academic and personal growth.");
			scholarshipView.addLabel(criteriaLabel, window, 650, 45, 360, 500, "Arial", 9, false);
			
			firstname = new JTextField(16);
			scholarshipView.addTextField(firstname, window, 320, 70, 95, 20);
			
			lastname = new JTextField(16);
			scholarshipView.addTextField(lastname, window, 430, 70, 95, 20);
			
			dateText = new JTextField(16);
			scholarshipView.addTextField(dateText, window, 320, 120, 205, 20);
			
			emailText = new JTextField(16);
			scholarshipView.addTextField(emailText, window, 320, 220, 205, 20);
			
			phoneText = new JTextField(16);
			scholarshipView.addTextField(phoneText, window, 320, 270, 205, 20);
			
			addressText = new JTextField(16);
			scholarshipView.addTextField(addressText, window, 320, 320, 205, 20);
			
			
			
			maleBox = new JCheckBox("MALE");
			scholarshipView.addCheckBox(maleBox, window, 320, 170, 95, 20);
			
			femaleBox = new JCheckBox("FEMALE");
			scholarshipView.addCheckBox(femaleBox, window, 430, 170, 95, 20);
			
			agreementBox = new JCheckBox();
			scholarshipView.addCheckBox(agreementBox, window, 210, 350, 20, 20);
			
			submitButton = new JButton("Submit");
			scholarshipView.addButton(submitButton, window, 430, 475, 75, 25);
			
			dashboardButton = new JButton();
			scholarshipView.addButton(dashboardButton, window, 5, 10, 40, 40);
			
			paymentButton = new JButton();
			scholarshipView.addButton(paymentButton, window, 5, 60, 40, 40);
			
			adminButton = new JButton();
			scholarshipView.addButton(adminButton, window, 5, 110, 40, 40);
			
			scholarshipButton = new JButton();
			scholarshipView.addButton(scholarshipButton, window, 5, 160, 40, 40);
			
			exitButton = new JButton();
			scholarshipView.addButton(exitButton, window, 5, 510, 40, 40);
			
			sidePanel = new JPanel();
			scholarshipView.addPanel(sidePanel, window, 0, 0, 50, 600);
			sidePanel.setBackground(new Color(0x484D51));
			
			formPanel = new JPanel();
			scholarshipView.addPanel(formPanel, window, 200, 50, 350, 490);
			formPanel.setBackground(new Color(0x776B5D));
			
			criteriaPanel = new JPanel();
			scholarshipView.addPanel(criteriaPanel, window, 650, 50, 350, 490);
			criteriaPanel.setBackground(new Color(0x776B5D));
			
			scholarshipView.frameColor(window);
			window.setLayout(null);
			window.setVisible(true);
	}
	
}
