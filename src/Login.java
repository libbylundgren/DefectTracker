
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

	
	
		public class Login extends JFrame implements ActionListener

		{
			
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			
			JLabel title = new JLabel("Login to Defect Tracker System");
			JLabel userIdLabel = new JLabel("User ID");
			JTextField userId = new JTextField(25);
		    JButton btn1;

			    
		    Login()
		    

		    {
		    	
		        setTitle("Login to Defect Tracker System");

		        setVisible(true);

		        setSize(800, 800);

		        setLayout(null);

		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 

		        title = new JLabel("Login to Defect Tracker System");

		        title.setForeground(Color.blue);

		        title.setFont(new Font("Serif", Font.BOLD, 20));

		 

		        userIdLabel = new JLabel("Enter User Id:");

		        userId = new JTextField();

		        btn1 = new JButton("Submit");

		 

		        title.setBounds(100, 30, 400, 30);

		        userIdLabel.setBounds(80, 70, 200, 30);

		        userId.setBounds(300, 70, 200, 30);

		        btn1.setBounds(150, 160, 100, 30);

		 

		        add(title);

		        add(userIdLabel);

		        add(userId);

		        add(btn1);
		       

		        btn1.addActionListener(this);
		        
		        		        

		    }

		 

		    public void actionPerformed(ActionEvent e)

		    {

		        showData();

		    }

		 

		    public void showData()

		    {
		    	System.out.println("made it to showdata");

		     
		        JPanel f1 = new JPanel();
		        JLabel l, l0;

		 

		        String str1 = userId.getText();

		        try

		        {

		        	makeConnection();
		        	
		        	System.out.println(str1);
		        	
		            PreparedStatement ps = con.prepareStatement("select FIRST_NAME from user where USER_ID='" +str1 +"'");

		            ResultSet rs = ps.executeQuery();

		            if (rs.next())

		            {
		            	JFrame master = new JFrame();
		            	JPanel mainPanel = new MainPanel(str1);
		        		master.add(mainPanel);
		        		master.setSize(800, 800);
		    			master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    			master.setVisible(true);
	 

		            } else

		            {

		                JOptionPane.showMessageDialog(null,

		                   "Incorrect user-Id ..Try Again with Valid User ID");

		            }

		        } 

		        catch (Exception ex)

		        {

		            System.out.println(ex);

		        }

		    }

		 

		    public static void main(String arr[])

		    {

		        new Login();

		    } 
		    public void makeConnection() {
				String url = "jdbc:mysql://localhost:3306/defect_tracking";
				String user = "root";
				String password = "MySQL16";

				try {

					System.out.println("made it here");
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, user, password);
					System.out.println("Connection made");

				} catch (Exception ex) {
					Logger lgr = Logger.getLogger(Login.class.getName());
					lgr.log(Level.SEVERE, ex.getMessage(), ex);
					System.out.println("Sql Exception");

				}

			}
		    
		} 
	
