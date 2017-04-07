package crud;

public class User {
	private int id;
	private String name;
	private String passord;
	private String email;
	public User(int id, String name, String passord) {
		super();
		this.id = id;
		this.name = name;
		this.passord = passord;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassord() {
		return passord;
	}
	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + name + ", passord=" + passord + "]";
	}
	

}
