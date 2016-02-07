import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListDefectsDAO {

	ArrayList<ListDefects> arrayList = new ArrayList<ListDefects>();
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ListDefectsDAO() {

				makeConnection();
				
				try {
					String q = "SELECT * FROM defect";
					st = con.createStatement();
					rs = st.executeQuery(q);			
					while (rs.next()){
						String tempDefectId = rs.getString(1);
						String tempOpenDate = rs.getString(2);
						String tempCloseDate = rs.getString(3);
						String tempReporterId = rs.getString(4);
						String tempDefectSummary = rs.getString(5);
						String tempDetailDescription = rs.getString(6);
						String tempAssignee = rs.getString(7);
						String tempStatus = rs.getString(8);
						String tempPriority = rs.getString(9);
						String tempComments = rs.getString(10);
//need to add comments from history table.  Connect by defect_id				
						
						ListDefects e = new ListDefects(tempDefectId, tempOpenDate, tempCloseDate, tempReporterId, tempDefectSummary
								        , tempDetailDescription, tempAssignee, tempStatus, tempPriority, tempComments);
						arrayList.add(e);
					}
					if (rs!= null) {
						rs.close();
					}
					if (st!= null) {
						st.close();
					}
					if (con!= null) {
						con.close();
					}
						
				} catch (SQLException ex) {
					System.out.println("Error with table or data");
				}

			}

	public String getCurrentList() {

		String str = "";

		return str;
	}

	public String getCurrentListFromDefect(String s) {
		String str = "";

		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i).getDefectId().equals(s)) {
				str += arrayList.get(i).getOpenDate();
				str += arrayList.get(i).getCloseDate();
				str += arrayList.get(i).getReporterId();
				str += arrayList.get(i).getDefectSummary();
				str += arrayList.get(i).getDetailDescription();
				str += arrayList.get(i).getAssignee();
				str += arrayList.get(i).getStatus();
				str += arrayList.get(i).getPriority();
				str += arrayList.get(i).getComments();
				str += "\n";
			}
		}
		return str;
	}

/*
	 * public void updateDefect(ListDefects i) { 
	 * makeConnection();
	 * 
	 * try { 
	 * 		String q = "update  Users (user_id, first_name, last_name, role, email) values " + " ('" + i.getUserId() + "', '" 
	 * 					+ i.getFirstName() + "', '" + i.getLastName() + "', '" + i.getRole() + "', '" + i.getEmail() + "');";
	 * 
	 * st = con.createStatement();
	 * st.executeUpdate(q);
	 * 
	 * if (st != null) { 
	 * 	st.close(); 
	 * } 
	 * 
	 * if (con != null) { 
	 * 	con.close(); 
	 * }
	 * 
	 * } catch (SQLException ex) { 
	 * 		System.out.println("Error with table or data");
	 * }
	 * 
	 * }
	 */
	public void insertNewDefect(ListDefects i) {
		makeConnection();

		try {
			String q = "insert into defect (defect_id, open_date, close_date, reporter_id, defect_summary, detail_description, assignee, status, priority, comments) values " 
					+ " ('" + i.getDefectId() + "', '" + i.getOpenDate() + "', '" + i.getCloseDate() + "', '" + i.getReporterId() + "', '"
					+ i.getDefectSummary() + "', '" + i.getDetailDescription() + "', '" + i.getAssignee() + "', '" + i.getStatus() + "', '" 
					+ i.getPriority() + "', '" + i.getComments() + "');";

			st = con.createStatement();
			st.executeUpdate(q);

			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException ex) {
			System.out.println("Error with table or data");
		}

	}

	public void deleteDefect(ListDefects i) {
		makeConnection();

		try {
			String q = "delete from defect where defect_id = '" + i.getDefectId() + "' and open_date = '" + i.getOpenDate()
					+ "' and close_date = '" + i.getCloseDate() + "' and reporter_id = '" + i.getReporterId() + "' and defect_summary = '"
					+ i.getDefectSummary() + "' and detail_description = '" + i.getDetailDescription() + "' and assignee = '" + i.getAssignee()
					+ "' and status = '" + i.getStatus() + "' and priority = '" + i.getPriority() + "' and comments = '" + i.getComments()
					+ "' limit 1";

			st = con.createStatement();
			st.executeUpdate(q);

			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException ex) {
			System.out.println("Error with table or data");
		}

	}

	public void makeConnection() {
			String url = "jdbc:mysql://localhost:3306/defect_tracking";
			String user = "root";
			String password = "disney99";

			try {

				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				System.out.println("Connection made");

			} catch (Exception ex) {
				Logger lgr = Logger.getLogger(ListDefectsDAO.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
				System.out.println("Sql Exception");

			}

		}
}
