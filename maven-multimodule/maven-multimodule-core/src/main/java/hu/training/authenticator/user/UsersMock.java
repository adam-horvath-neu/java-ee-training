package hu.training.authenticator.user;

import java.util.Arrays;
import java.util.Collection;

import hu.training.authenticator.dto.User;

public class UsersMock {

	private final static Collection<User> users;

	static {
		users = Arrays.asList(new User[] {
				new User("Bela", "jelszo"),
				new User("Istvan", "jelszo"),
				new User("Balint", "admin")});
	}
	
	public static Collection<User> getUsers() {
		return users;
	}
}
