import java.util.ArrayList;	
public class Server {
	ArrayList<User> users;
	public Server() {
		users = new ArrayList<User>();
	}
	 public ArrayList<User> getServer(){
     	return users;
     }
}
