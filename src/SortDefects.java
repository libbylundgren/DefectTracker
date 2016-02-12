//Ashley Risius

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import SortListPanel.ButtonAndStoreSelectorListener;

public class SortDefects extends JPanel{

	JLabel title = new JLabel("Sort Defects");
	JLabel defectSummaryLabel = new JLabel("Defect Summary: ");
	//JLabel openDate = new JLabel("Date Opened: ");
	JComboBox defectId = new JComboBox();
	JComboBox userId = new JComboBox();
	String[] statuses = {"Open", "In Progress", "Closed"};
	JComboBox status = new JComboBox(statuses);
	String[] priorities = {"Low", "Medium", "High"};
	JComboBox priority = new JComboBox(priorities);
	JComboBox assignee = new JComboBox();
	
	JButton back = new JButton("Back to Main");
	DefectTrackerDAO defectTracker = new DefectTrackerDAO;
	
	public SortDefects(){
		title.setFont(new Font("Serif", Font.PLAIN, 16));
		setMinimumSize(new Dimension(400,250));

	    
	    JScrollPane scroll = new JScrollPane();
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
        SortListener ss = new SortListener();
        defectId.addActionListener(ss);
        userId.addActionListener(ss);
        status.addActionListener(ss);
        priority.addActionListener(ss);
        assignee.addActionListener(ss);
        back.addActionListener(ss);
        
        setLayout(new BorderLayout());
        
		add(title, BorderLayout.NORTH);
		add(defectId, BorderLayout.WEST);
		add(userId, BorderLayout.WEST);
		add(status, BorderLayout.WEST);
		add(priority, BorderLayout.WEST);
		add(assignee, BorderLayout.WEST);
		add(scroll, BorderLayout.CENTER);
		add(back, BorderLayout.SOUTH);	
		
	}
	class SortListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = //insert information for DAO here
			
			System.out.println("noted change");
			
			if(e.getSource() == back){
				removeAll();
                JPanel newPanel= new MainPanel();
                add(newPanel);
                revalidate();
                newPanel.repaint();
			}
		}
		
	}
	
	
}
