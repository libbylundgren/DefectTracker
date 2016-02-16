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
	//not adding defectId as the table should add sequentially add this
	//not adding close date since this is the open slot.
	//not adding reportId as this should be whoever is logged in
	JLabel title = new JLabel("Enter the defect information here: ");
	JLabel summaryLabel = new JLabel("Defect Summary: ");
	JTextField summary = new JTextField(100);
	//JLabel openDate = new JLabel("Date Opened: "); //do i need this or will table populate current date?
	//JComboBox userId = new JComboBox(); //do i need this?  what's the different between this and reported/assignee?
	JLabel descriptionLabel = new JLabel("Enter a description here: ");
	JTextField description = new JTextField(100);
	JComboBox priority = new JComboBox(priorities);
	JComboBox status = new JComboBox(statuses);
	JComboBox assigneeID = new JComboBox();
	JLabel commentsLabel = new JLabel("Comments: ");
	JTextField comments - new JTextField(5000);
	


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
		
		buttonLabels.add(summaryLabel);
		textBoxes.add(summary);
		buttonLabels.add(descriptionLabel);
		buttonLabels.add(commentsLabel);
		textBoxes.add(description);
		textBoxes.add(status);
		textBoxes.add(priority);
		textBoxes.add(assigneeID);
		textBoxes.add(comments);
		
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

				 String tempSummary = summary.getText();
				 String tempDescription = description.getText();
				 String tempPriority = priority.getSelectedItem().toString();
				 String tempStatus = status.getSelectedItem().toString();
				 String tempAssigneeID = assigneeID.getSelectedItem().toString();
				 String tempComments = comments.getText();

				 //need to add some type of error handling if options are empty
				 
				DefectInfo d = new DefectInfo(tempSummary, tempDescription, tempPriority, tempStatus, tempAssigneeID, tempComments);
				//I think this is messed up because i'm not passing the same number as in the constructor? 
				ListDefectsDAO.insertNewDefect(d);
					
				summary.setText("");
				description.setText("");
				comments.setText("");
					
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
