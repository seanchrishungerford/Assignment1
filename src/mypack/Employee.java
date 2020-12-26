package mypack;

public class Employee {

	private String username;
	private String password;
	public Employee(String nameStr, String passStr) {
		super(); 
		this.username = nameStr;
		this.password = passStr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
