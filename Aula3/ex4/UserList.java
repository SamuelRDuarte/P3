package Aula3.ex4;

import java.util.*;
import java.util.stream.Collectors;

public class UserList {
	private List<Utilizador> users = new ArrayList<>();
	
	public void addUser(Utilizador user) {
		users.add(user);
	}
	
	public void removeUser(Utilizador user) {
		users.remove(user);
	}
	
	public Utilizador getUser(int cc) {
		/*for(Utilizador user : usersToArray()) {
			if(user.getCc() == cc) {
				return user;
			}
		}
		throw new IllegalArgumentException();*/
		return users.stream().filter(uti-> uti.getCc()==cc).collect(Collectors.toList()).get(0);
	}
	
	public int size() { return users.size(); }
	private Utilizador[] usersToArray() { return users.toArray(new Utilizador[0]); }

	public List<Utilizador> getUsers() {
		return users;
	}
	
}
