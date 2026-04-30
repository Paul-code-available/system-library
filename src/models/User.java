package models;

public class User {

	private String name;
	private String email;
	private String password;
	private String celular;
    private String rol;

    public User(){
    }

	public User(String name, String email) {
		this.name = name;
        this.email = email;
	}

	public User(String name, String email, String celular, String rol) {
		this.name = name;
		this.email = email;
		this.celular = celular;
        this.rol = rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
