package hu.sconherz.blog.web.register;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class RegistrationForm
 */
@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REGISTRATION_JSP_URL = "public/register.jsp";
	private static final String LOGIN_JSP_URL = "public/login.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegistrationForm registrationForm = new RegistrationForm(request);

		String username = registrationForm.getUsername();
		UserService userService = new UserServiceImpl();
		User user = null;
		try {
			user = userService.findUserByName(username);
		} catch (UserNotFoundException e) {

		}

		if (user != null) {
			request.setAttribute("error", "User already exists");
			request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);

		} else {

			User newUser = new User();

			// validate username
			Login login = new Login();
			if (registrationForm.getUsername().length() <= 31) {
				login.setUsername(registrationForm.getUsername());
			} else {
				request.setAttribute("error", "Username max 30 character");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);

			}

			// validate password
			Pattern passwordPattern = Pattern.compile("(.*)(\\d+)(.*)");
			Matcher passwordMatcher = passwordPattern.matcher(registrationForm.getPassword());
			boolean isPasswordValid = passwordMatcher.matches();
			if (registrationForm.getPassword().length() >= 8
					&& registrationForm.getPassword().equals(registrationForm.getPassword2()) && isPasswordValid) {
				login.setPassword(registrationForm.getPassword());
			} else {
				request.setAttribute("error",
						"Password has to be at least 8 characters, must contain a number and must be the same");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);

			}
			// Set username and password
			newUser.setLogin(login);

			// validate first name
			Name name = new Name();
			if (registrationForm.getFirstName().length() <= 30) {
				name.setFirst(registrationForm.getFirstName());
			} else {
				request.setAttribute("error", "First name max 30 characters!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);

			}

			// validate last name
			if (registrationForm.getLastName().length() <= 30) {
				name.setLast(registrationForm.getLastName());
			} else {
				request.setAttribute("error", "Last name max 30 characters!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);

			}
			// Set first and last name
			newUser.setName(name);

			// validate email
			Pattern emailPattern = Pattern.compile("(.+)(@)(.+)(\\.)(.+)");
			Matcher emailMatcher = emailPattern.matcher(registrationForm.getEmail());
			boolean isEmailValid = emailMatcher.matches();
			if (isEmailValid) {
				newUser.setEmail(registrationForm.getEmail());
			} else {
				request.setAttribute("error", "Wrong email format");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);

			}

			// validate phone
			Pattern phonePattern = Pattern.compile("(\\+)(\\d{2})(-)(\\d{2})(/)(\\d{4})(-)(\\d{3})");
			Matcher phoneMatcher = phonePattern.matcher(registrationForm.getPhone());
			boolean isPhoneValid = phoneMatcher.matches();
			if (isPhoneValid) {
				newUser.setPhone(registrationForm.getPhone());
			} else {
				request.setAttribute("error", "Wrong phone number format (e.g. +36-30/1234-567)");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);

			}

			// Set picture
			Picture picture = new Picture();
			picture.setLarge(registrationForm.getPicture());
			newUser.setPicture(picture);

			// Create the new User
			userService.registerUser(newUser);

			response.sendRedirect(LOGIN_JSP_URL);
		}
	}

}
