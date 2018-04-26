package hu.sconherz.blog.web.login;

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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REGISTRATION_JSP_URL = "public/registration.jsp";
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			//
		}

		if (user != null) {
			request.setAttribute("error", "User exists!");
			request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
		} else {
			User newUser = new User();
			Login login = new Login();
			if (registrationForm.getUsername().length() <= 30) {
				login.setUsername(registrationForm.getUsername());
			} else {
				request.setAttribute("error", "Max 30 karakter a username");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
				return;
			}
			Pattern passwordPattern = Pattern.compile("(.*)(\\d+)(.*)");
			Matcher passwordMatcher = passwordPattern.matcher(registrationForm.getPassword());
			boolean passwordValid = passwordMatcher.matches();
			if (registrationForm.getPassword().length() <= 8
					&& registrationForm.getPassword().equals(registrationForm.getPassword2()) && passwordValid) {
				login.setPassword(registrationForm.getPassword());
			} else {
				request.setAttribute("error", "Password max 8 karakter, matchelni kell & min 1 number!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
				return;
			}
			newUser.setLogin(login);

			Name name = new Name();
			if (registrationForm.getFirstName().length() <= 30) {
				name.setFirst(registrationForm.getFirstName());
			} else {
				request.setAttribute("error", "Max 30 karakter a firstname!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
				return;
			}

			if (registrationForm.getLastName().length() <= 30) {
				name.setLast(registrationForm.getLastName());
			} else {
				request.setAttribute("error", "Max 30 karakter a lastname!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
				return;
			}
			newUser.setName(name);

			Pattern emailPattern = Pattern.compile("(.+)(@)(.+)(\\.)(.+)");
			Matcher emailMatcher = emailPattern.matcher(registrationForm.getEmail());
			boolean emailValid = emailMatcher.matches();
			if (emailValid) {
				newUser.setEmail(registrationForm.getEmail());
			} else {
				request.setAttribute("error", "Ez nem Email cím!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
				return;
			}

			Pattern phonePattern = Pattern.compile("(\\+)(\\d{2})(-)(\\d{2})(/)(\\d{4})(-)(\\d{3})");
			Matcher phoneMatcher = phonePattern.matcher(registrationForm.getPhone());
			boolean phoneValid = phoneMatcher.matches();
			if (phoneValid) {
				newUser.setPhone(registrationForm.getPhone());
			} else {
				request.setAttribute("error", "Ez nem valid telefon!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
				return;
			}
			Picture picture = new Picture();
			picture.setLarge(registrationForm.getPicture());
			newUser.setPicture(picture);
			userService.registrationUser(newUser);
			response.sendRedirect(LOGIN_JSP_URL);
		}
	}
}
