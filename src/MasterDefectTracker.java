import javax.swing.JFrame;
import javax.swing.JPanel;

public class MasterDefectTracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame master = new JFrame();
		JPanel mainPanel = new MainPanel();
		master.add(mainPanel);
		
		master.setSize(400, 250);
		master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		master.setVisible(true);

	}

}
