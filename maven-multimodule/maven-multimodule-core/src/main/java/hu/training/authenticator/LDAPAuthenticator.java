package hu.training.authenticator;

import hu.training.authenticator.dto.User;
import hu.training.authenticator.user.UserMock;

public class LDAPAuthenticator implements Authenticator {

	public boolean authenticate(User user) {
		return UserMock.getUsers().contains(user);
	}

}
