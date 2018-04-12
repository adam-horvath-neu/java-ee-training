package hu.training.authenticator.user;

import java.util.Arrays;
import java.util.Collection;

import hu.training.authenticator.user.User;

public class UsersMock {

	private final static Collection<User> users;

	static {
		users = Arrays.asList(new User[] {
				new User("Gergo", "jelszo"),
				new User("Jonas", "jelszo"),
				new User("Dora", "jelszo")});
	}
	
	public static Collection<User> getUsers() {
		return users;
	}
}
