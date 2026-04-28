package models;

public class User {

	private String name;
	private String email;
	private String password;
	private String celular;
	
	public User(String name, String email) {
		this.name = name;
        this.email = email;
	}
	/*
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	*/
	public User(String name, String email, String celular) {
		this.name = name;
		this.email = email;
		this.celular = celular;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String toCsv() {
		return name + "," +
				email + "," +
				celular;
	}
	
	public static User fromCsv(String userData) {
		String data[] = userData.split(",");

        if (data.length < 3){
            return null;
        }
		
		String name = data[0];
		String email = data[1];
		String celular = data[2];
		
		return new User(name, email, celular);
	}
	
	
}
