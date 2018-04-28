package hu.schonherz.blog.service.api.user.service;

import java.io.IOException;
import java.util.List;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.User;

public interface UserService {

	public List<User> findAllUser();

	User findUserByName(String name) throws UserNotFoundException;
	
	public void registrationUser(User user) throws IOException;
	
	
}
