
//Paula Bitner

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
	JButton btn1;

	ListUsersDAO usersDAO = new ListUsersDAO();

	public Login(){
		
		ButtonListener b = new ButtonListener();
		title=new JLabel("Login to Defect Tracker System");
		title.setForeground(Color.blue);
		title.setFont(new Font("Serif",Font.BOLD,20));
		
		userIdLabel=new JLabel("Enter User Id:");
		userId=new JTextField();
		btn1=new JButton("Submit");

		title.setBounds(100,30,400,30);
		userIdLabel.setBounds(80,70,200,30);
		userId.setBounds(300,70,200,30);
		btn1.setBounds(150,160,100,30);

		add(title);
		add(userIdLabel);
		add(userId);
		add(btn1);
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn1) {
				System.out.println("made it to showdata");
				JPanel f1 = new JPanel();
				JLabel l, l0;
				String str1 = userId.getText();
				try {
					usersDAO.getCurrentListFromUser(str1);
					System.out.println("Validating User");
//					if {
					JFrame master = new JFrame();
					JPanel mainPanel = new MainPanel(str1);
					master.add(mainPanel);
					master.setSize(800, 800);
					master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					master.setVisible(true);
//					} else {
//						JOptionPane.showMessageDialog(null,
//							"Incorrect user-Id ..Try Again with Valid User ID");
//					}		
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		}
	}
}