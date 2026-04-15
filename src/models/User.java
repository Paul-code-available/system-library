package models;

public class User {

	private String name;
	private String email;
	private String password;
	
	public User() {
		
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	 public User(String name, String email, String password) {
	        this.name = name;
	        this.email = email;
	        this.password = password;
	    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toCsv() {
		return name + "," +
				email + ",";
	}
	
	public static User fromCsv(String userData) {
		String data[] = userData.split(",");
		
		String name = data[0];
		String email = data[1];
		
		return new User(name, email);
	}
	
	
}
