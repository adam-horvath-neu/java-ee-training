package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;

public class ListClass {

	
	static List<User> list;
	
	
	public static List<User> getList() {
		return list;
	}


	public static void setList(UserResult result) {
		list = result.getResults();
	}


	
	

}
	
	

