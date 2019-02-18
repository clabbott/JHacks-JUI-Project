

public class User {
	
	private String name;
	private String password;
	private IDStuff id;
	
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		id = null;
	}
	
	public User(String name, String password, IDStuff id) {
		this.name = name;
		this.password = password;
		this.id = id;
	}
	
	public User(User other) {
		this.name = other.name;
		this.password = other.password;
		this.id = other.id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setId(IDStuff id) {
		this.id = id;
	}
	
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		if(!(other instanceof User)) {
			return false;
		}
		User u = (User) other;
		return (this.name.equals(u.name)) && (this.password.equals(u.password));
	}
	
	public boolean process(User other) {
		if(!(this.equals(other))) {
			return false;
		}
		if(this.id.compaerer(other.id)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "Username: "+name+" Password: "+password+ " ID: "+id;
	}
	
}
