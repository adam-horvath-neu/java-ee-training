package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;

public class UserServiceImpl implements UserService {

	private UserResult result;

	public UserServiceImpl() {
		result = init();
	}

	@Override
	public List<User> findAllUser() {
		return result.getResults().stream().sorted(Comparator.comparing(User::getEmail)).collect(Collectors.toList());
	}

	private UserResult init() {
		Gson gson = new Gson();
		ClassLoader classLoader = getClass().getClassLoader();
		try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {
			result = gson.fromJson(bufferedReader, UserResult.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param name
	 * @return
	 */
	public User findUserByName(String name) throws UserNotFoundException {

		List<User> users = result.getResults();
		for (User user : users) {
			if (user.getLogin().getUsername().equals(name)) {
				return user;
			}
		}
		throw new UserNotFoundException();

	}

	@Override
	public void registerUser(User user) {
		List<User> users = result.getResults();
		users.add(user);
		result.setResults(users);

		try {
			listToJson(result.getResults());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
	}

	public void listToJson(List<User> users) throws IOException {
	
		Writer writer = null;

		try {
			writer = new FileWriter("C:\\Users\\admin\\eclipse-workspace\\blog\\service\\src\\test\\resources\\example.txt");
			Gson gson = new GsonBuilder().create();
			gson.toJson(users, writer);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		
	}

}
