//Paula Bitner

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	JButton view = new JButton("View Defects");
	JButton add = new JButton("Add Defects");
	JButton sort = new JButton("Sort Defects");
	
	public MainPanel(){
		
		removeAll();
		JPanel mainMenu = new JPanel();
	    
		mainMenu.add(view);
		mainMenu.add(add);
		mainMenu.add(sort);
		add(mainMenu);
		
		ButtonHandler handler = new ButtonHandler();
		view.addActionListener(handler);
		add.addActionListener(handler);
		sort.addActionListener(handler);
		
	}
	
	public MainPanel(String n){
        
                
        JLabel welcomeIn = new JLabel();

        welcomeIn.setBounds(60, 50, 500, 500);

        welcomeIn.setText("Welcome " + n + "!");

        welcomeIn.setForeground(Color.red);

        welcomeIn.setFont(new Font("Serif", Font.BOLD, 30)); 
        
        JLabel imIn = new JLabel();

        imIn = new JLabel("You are successfully logged in to the Defect Tracker system.");

        imIn.setForeground(Color.blue);

        imIn.setFont(new Font("Serif", Font.BOLD, 30));
        
        imIn.setBounds(60, 100, 500, 500);
        
        JLabel actionIn = new JLabel();

        actionIn = new JLabel("What function would you like to perform? ");

        actionIn.setForeground(Color.black);

        actionIn.setFont(new Font("Serif", Font.BOLD, 30));
        
        actionIn.setBounds(60, 150, 500, 500);

        
        add(welcomeIn);
        add(imIn);
        add(actionIn);
        
        JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(view);
		buttonPanel.add(add);
		buttonPanel.add(sort);
		
		add(buttonPanel);
      
     
		ButtonHandler handler = new ButtonHandler();
		view.addActionListener(handler);
		add.addActionListener(handler);
		sort.addActionListener(handler);
		
	}
	
	class ButtonHandler implements ActionListener {
		@Override
        public void actionPerformed(ActionEvent e) {
			
			JPanel welcomeIn = new JPanel();
        	welcomeIn = (null);
        	JPanel imIn = new JPanel();
        	imIn = (null);
        	JPanel actionIn = new JPanel();
        	actionIn = (null);
        	
        	
             /*   if (e.getSource() == view) {
 
                	removeAll();
                    JPanel newPanel=new ViewDefects();
                    add(newPanel);
                    revalidate();
                
                } */
                if (e.getSource() == add) {
                	removeAll();
                    JPanel newPanel=new AddDefect();
                    add(newPanel);
                    revalidate();
                    
                }
                if (e.getSource() == sort) {
                    removeAll();
                    JPanel newPanel=new SortDefects();
                    add(newPanel);
                    revalidate();
                  
            }
                
        }

}

} 
