//Libby Lundgren

public class UserInfo {
	
	private String userID;
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	
	
	public UserInfo(String uID, String fn, String ln, String e, String r){
		userID = uID;
		firstName = fn;
		lastName = ln;
		email = e;
		role = r;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return "UserInfo [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", role=" + role + "]";
	}
}
