package hu.schonherz.blog.service;

import java.util.List;

import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;

public class ListClass {
	static List<User> list;

	public static List<User> getList() {
		return list;
	}

	public static void setList(UserResult req) {
		 list = req.getResults();
	}
	

}
