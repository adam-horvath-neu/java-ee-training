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
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INDEX_JSP_URL = "index.jsp";
	private static final String REGISTER_JSP_URL = "register/register.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegisterForm registration = new RegisterForm(request);
		UserServiceImpl register = new UserServiceImpl();

		User user = new User();

		Login login = new Login();
		if (registration.getUser_name().length() < 30) {
			login.setUsername(registration.getUser_name());
		} else {
			request.setAttribute("error", "Username cannot be more than 30 characters!");
			request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
			return;
		}

		Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=\\S+$).{8,}$");
		Matcher passwordMatcher = passwordPattern.matcher(registration.getPassword());
		boolean validPass = passwordMatcher.matches();
		if ((validPass && registration.getPassword().length() >= 8
				&& registration.getPassword().equals(registration.getCpassword()))) {
			login.setPassword(registration.getPassword());
		} else {
			request.setAttribute("error", "Password must be 8 characters, must include a number and must match!");
			request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
			return;
		}

		user.setLogin(login);

		Name name = new Name();
		if (registration.getFirst_name().length() <= 30) {
			name.setFirst(registration.getFirst_name());
		} else {
			request.setAttribute("error", "First name cannot be more than 30 characters!");
			request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
			return;
		}

		if (registration.getLast_name().length() <= 30) {
			name.setLast(registration.getLast_name());
		} else {
			request.setAttribute("error", "Last name cannot be more than 30 characters!");
			request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
			return;
		}

		user.setName(name);

		Pattern emailPattern = Pattern.compile("(.+)(@)(.+)(\\.)(.+)");
		Matcher emailMatcher = emailPattern.matcher(registration.getUser_email());
		boolean emailValid = emailMatcher.matches();
		if (emailValid) {
			user.setEmail(registration.getUser_email());
		} else {
			request.setAttribute("error", "Invalid email!");
			request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
			return;
		}

		Pattern phonePattern = Pattern.compile("(\\+)(\\d{2})(-)(\\d{2})(-)(\\d{3})(-)(\\d{4})");
		Matcher phoneMatcher = phonePattern.matcher(registration.getPhone_number());
		boolean phoneValid = phoneMatcher.matches();
		if (phoneValid) {
			user.setPhone(registration.getPhone_number());
		} else {
			request.setAttribute("error", "Invalid phone number!");
			request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
			return;
		}

		Picture picture = new Picture();
		picture.setLarge(registration.getProfile_picture());
		user.setPicture(picture);

		register.registrationUser(user); 

		response.sendRedirect(INDEX_JSP_URL);

	}

}
