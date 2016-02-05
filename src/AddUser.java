import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddUser extends JPanel {

	JLabel title = new JLabel("Add New User");
	JLabel firstNameLabel = new JLabel("First Name: ");
	JTextField firstName = new JTextField(30);
	JLabel lastNameLabel = new JLabel("Last Name: ");
	JTextField lastName = new JTextField(30);
	JLabel userIdLabel = new JLabel("User Id: ");
	JTextField userId = new JTextField(30);
	JLabel emailLabel = new JLabel("Email: ");
	JTextField email = new JTextField(30);
	JButton back = new JButton("Back to Main");
	JButton addUser = new JButton("Add User");

	ListUsersDAO defectTracker = new ListUsersDAO;


	public AddUser() {

		ButtonListener b = new ButtonListener();
		addUser.addActionListener(b);
		back.addActionListener(b);

		setLayout(new BorderLayout());

		title.setFont(new Font("Serif", Font.PLAIN, 16));
		add(title, BorderLayout.NORTH);

		JPanel buttonLabels = new JPanel(new GridLayout(4, 0));
		JPanel textBoxes = new JPanel(new GridLayout(4, 0));

		buttonLabels.add(firstNameLabel);
		textBoxes.add(firstName);
		buttonLabels.add(lastNameLabel);
		textBoxes.add(lastName);
		buttonLabels.add(userIdLabel);
		textBoxes.add(userId);
		buttonLabels.add(emailLabel);
		textBoxes.add(email);

		add(buttonLabels, BorderLayout.WEST);
		add(textBoxes, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		buttonPanel.add(addUser);
		buttonPanel.add(back);

		add(buttonPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == addUser) {

			// need information here from the DefectInfo class

			System.out.println("Add new user to database");
		}


		if (e.getSource() == back) {
			removeAll();
			JPanel newPanel = new MainPanel();
			add(newPanel);
			revalidate();
			newPanel.repaint();
		}
	}

}
