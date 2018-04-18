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
 * Servlet implementation class RegistrationForm
 */
@WebServlet("/Registration")
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

		if (user != null) { // Létezik ilyen felhasználó

			request.setAttribute("error", "Ilyen felhasználónév már létezik!");
			request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);

		} else {
			User newUser = new User();

			Login login = new Login();
			if (registrationForm.getUsername().length() <= 31) {
				login.setUsername(registrationForm.getUsername());
			} else {
				request.setAttribute("error", "Username max 30 karakter");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}

			Pattern p = Pattern.compile(".*+\\d++.*+"); 		// NOT GOOD
			Matcher m = p.matcher(registrationForm.getPassword());
			boolean b = m.matches();
			if (registrationForm.getPassword().length() <= 8
					&& registrationForm.getPassword().equals(registrationForm.getPassword2()) && b) {
				login.setPassword(registrationForm.getPassword());
			} else {
				request.setAttribute("error", "Jelszó max 8 karakter, azonosak, 1 szám legyen!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
			newUser.setLogin(login);

			Name name = new Name();
			if (registrationForm.getFirstName().length() <= 30) {
				name.setFirst(registrationForm.getFirstName());
			} else {
				request.setAttribute("error", "First name max 30 karakter legyen!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
			
			if (registrationForm.getLastName().length() <= 30) {
				name.setLast(registrationForm.getLastName());
			} else {
				request.setAttribute("error", "Last name max 30 karakter legyen!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
			newUser.setName(name);

			if (registrationForm.getEmail().contains("@") && registrationForm.getEmail().contains(".")) {
				newUser.setEmail(registrationForm.getEmail());
			} else {
				request.setAttribute("error", "Helyesen add meg az emailcímet!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
			
			if (registrationForm.getPhone() != "a") {
				newUser.setPhone(registrationForm.getPhone());	//NEM JÓ
			} else {
				request.setAttribute("error", "Helyesen add meg a telefonszámod!");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}

			Picture picture = new Picture();
			picture.setLarge(registrationForm.getPicture());
			newUser.setPicture(picture);

			userService.registrationUser(newUser);

			request.setAttribute("error", "Sikeres regisztráció!");
			request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
		}
	}

}
