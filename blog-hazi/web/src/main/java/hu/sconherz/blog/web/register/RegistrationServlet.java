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
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.Id;
import hu.schonherz.blog.service.api.user.vo.Location;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String LOGIN_JSP_URL = "public/login.jsp";
	private static final String REG_JSP_URL = "public/registration.jsp";
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegistrationForm regForm = new RegistrationForm(request);
		
		User user = new User();
		
		Location location = new Location();
		user.setLocation(location);
		
		Login login = new Login();
		login.setUsername(regForm.getUsername());
		login.setPassword(regForm.getPassword());
		user.setLogin(login);
		
		Id id = new Id();
		user.setId(id);
		
		user.setEmail(regForm.getEmail());
		user.setPhone(regForm.getPhone());
		
		Name name = new Name();
		name.setFirst(regForm.getFirstname());
		name.setLast(regForm.getLastname());
		user.setName(name);
		
		Picture picture = new Picture();
		picture.setLarge(regForm.getImage());
		user.setPicture(picture);

		//username name validálás
		if (login.getUsername().length() > 30){
			request.setAttribute("error", "A Felhasználónév nem lehet több 30 karakternél");
			request.getRequestDispatcher(REG_JSP_URL).forward(request, response);
			return;
		}
		//first name validálás
		if (name.getFirst().length() > 30){
			request.setAttribute("error", "A Keresztnév nem lehet több 30 karakternél");
			request.getRequestDispatcher(REG_JSP_URL).forward(request, response);
			return;
		}
		//last name validálás
		if (name.getLast().length() > 30){
			request.setAttribute("error", "A Vezetéknév nem lehet több 30 karakternél");
			request.getRequestDispatcher(REG_JSP_URL).forward(request, response);
			return;
		}
		//email validálás
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			request.setAttribute("error", "Hibás email cím! ");
			request.getRequestDispatcher(REG_JSP_URL).forward(request, response);
			return;
		}
		//jelszó validálás
		//mivel a servlet meg se kapja a password2t ezért a jelszavak egyezését nem ellenőrzöm
		if (!(login.getPassword().length()>7 && login.getPassword().matches(".*\\d+.*"))) {
			request.setAttribute("error", "A jelszónak minimum 8 karakternek kell lennie és tartalmaznia kell egy számot! ");
			request.getRequestDispatcher(REG_JSP_URL).forward(request, response);
			return;
		}
		//phone number validálás
		if(!user.getPhone().matches("(\\+)(\\d{2})(-)(\\d{2})(/)(\\d{4})(-)(\\d{3})")) {
			request.setAttribute("error", "Rossz telefonszám! helyes formátum: +36-30/1234-567");
			request.getRequestDispatcher(REG_JSP_URL).forward(request, response);
			return;
		}
		UserService userService = new UserServiceImpl();
		userService.registrationUser(user);	
		request.setAttribute("success", "Sikeres Regisztráció");
		request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
	}
}
