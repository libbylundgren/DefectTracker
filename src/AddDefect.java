//Ashley Risius

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddDefect extends JPanel {

	
	String[] statuses = {"Open", "In Progress", "Closed"};
	String[] priorities = {"Low", "Medium", "High"};
	
	JLabel title = new JLabel("Enter the defect information here: ");
	JLabel defectSummaryLabel = new JLabel("Defect Summary: ");
	JTextField defectSummary = new JTextField(100);
	//JLabel openDate = new JLabel("Date Opened: ");
	JComboBox userId = new JComboBox();
	JLabel descriptionLabel = new JLabel("Enter a description here: ");
	JTextField description = new JTextField(100);
	JComboBox status = new JComboBox(statuses);
	JComboBox priority = new JComboBox(priorities);
	JComboBox assignee = new JComboBox();
	JButton submit = new JButton("Submit");
	JButton back = new JButton("Back to Main");
	JButton viewDefects = new JButton("View Defects");
	ListDefectsDAO defectTracker = new ListDefectsDAO();
	
	public AddDefect() {
		
		ButtonListener b = new ButtonListener();
		submit.addActionListener(b);
		viewDefects.addActionListener(b);
		back.addActionListener(b);
		
		setLayout(new BorderLayout());
		
		
		title.setFont(new Font("Serif", Font.PLAIN, 16));
		add(title, BorderLayout.NORTH);
		
		JPanel buttonLabels = new JPanel(new GridLayout(2,0));
		JPanel textBoxes = new JPanel(new GridLayout(2,0));
		
		buttonLabels.add(defectSummaryLabel);
		textBoxes.add(defectSummary);
		buttonLabels.add(descriptionLabel);
		textBoxes.add(description);
		textBoxes.add(userId);
		textBoxes.add(status);
		textBoxes.add(priority);
		textBoxes.add(assignee);
		
		add(buttonLabels, BorderLayout.WEST);
		add(textBoxes, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		buttonPanel.add(submit);
		buttonPanel.add(viewDefects);
		buttonPanel.add(back);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		
	}
	
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == submit) {

				// need information here from the DefectInfo class

				System.out.println("Add new item to database");
			}

			if (e.getSource() == viewDefects) {
				removeAll();
				JPanel newPanel = new SortDefects();
				add(newPanel);
				revalidate();
				newPanel.repaint();
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
}
