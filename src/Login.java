
//Paula Bintner

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JFrame;

public class Login extends JPanel {

	JLabel title = new JLabel("Login to Defect Tracker System");
	JLabel userIdLabel = new JLabel("User ID");
	JTextField userId = new JTextField(25);
	JButton submitBtn;

	ListUsersDAO usersDAO = new ListUsersDAO();

	public Login(){
		
		
		title=new JLabel("Login to Defect Tracker System");
		title.setForeground(Color.blue);
		title.setFont(new Font("Serif",Font.BOLD,20));
		
		userIdLabel=new JLabel("Enter User Id:");
		userId=new JTextField(25);
		submitBtn=new JButton("Submit");
		
		ButtonListener b = new ButtonListener();
		submitBtn.addActionListener(b);
		

		title.setBounds(100,30,400,30);
		userIdLabel.setBounds(80,70,200,30);
		userId.setBounds(300,70,200,30);
		submitBtn.setBounds(150,160,100,30);

		add(title);
		add(userIdLabel);
		add(userId);
		add(submitBtn);
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submitBtn) {
			//	System.out.println("made it to showdata");
				String str1 = userId.getText();
				try {
			//		System.out.println("made it to try");
					String str = usersDAO.getCurrentListFromUser(str1);
			//		System.out.println("Validating User");
					if (str.equals("")){
						JOptionPane.showMessageDialog(null,
								"Incorrect user-Id ..Try Again with Valid User ID");
						JPanel mainPanel = new Login();
						userId.setText("");}
						else {
							if (!str.equals(" "));{
					//			System.out.println("returning from try");
					//			System.out.println(str);
								JFrame master = new JFrame();
								JPanel mainPanel = new MainPanel();
								master.add(mainPanel);
								master.setSize(800, 800);
								master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								master.setVisible(true);
							}
						}
							
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		}
	}
}