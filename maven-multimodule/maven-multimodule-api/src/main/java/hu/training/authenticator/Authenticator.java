package hu.training.authenticator;

import hu.training.authenticator.user.User;

public interface Authenticator {
	boolean authenticate(User user);
}
