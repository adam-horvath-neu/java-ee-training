package hu.training.authenticator.user;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

import hu.training.authenticator.dto.User;

public class UserMock {
	
	private final static Collection<User> users;
	static {
		users = Arrays.asList(new User[]
				{
					new User("Bela", "jelszo"),
					new User("szabi", "jelszo")
				});
	}
}
