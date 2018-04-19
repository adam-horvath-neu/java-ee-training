package hu.schonherz.blog.service;

import java.util.List;

import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;

public class ListClass {
	
	static List<User> users;
	
	public static List<User> getList(){
		return users;
	}
	
	public static void setList(UserResult result) {
		users = result.getResults();
	}
}
