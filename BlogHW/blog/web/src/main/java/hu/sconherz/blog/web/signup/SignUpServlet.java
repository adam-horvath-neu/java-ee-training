package hu.sconherz.blog.web.signup;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_JSP_URL = "public/login.jsp";
	private static final String SECURED_JSP_URL = "secured/secured.jsp";
	private static final String SIGNUP_JSP_URL = "public/signup.jsp";

	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(SIGNUP_JSP_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		SignUpForm signupform = new SignUpForm(request);

		String username = signupform.getUsername();
		List<User> usernamelist = userService.findAllUser();
		for (User user : usernamelist) {
			if (username.equals(user.getLogin().getUsername())) {
				request.setAttribute("error", "A megadott felhasználónév foglalt!");
				request.getRequestDispatcher(SIGNUP_JSP_URL).forward(request, response);
			}
		}
		String firstname = signupform.getFirstname();
		if (!(firstname.length() <= 30 && firstname.length() > 0)) {
			request.setAttribute("error", "A megadott keresztnév nem megfelelő hosszúságú!");
			request.getRequestDispatcher(SIGNUP_JSP_URL).forward(request, response);
		}
		String secondname = signupform.getSecondname();
		if (!(secondname.length() <= 30 && secondname.length() > 0)) {
			request.setAttribute("error", "A megadott keresztnév nem megfelelő hosszúságú!");
			request.getRequestDispatcher(SIGNUP_JSP_URL).forward(request, response);
		}
		String email = signupform.getEmail();

		Pattern p = Pattern.compile("^[A-Za-z0-9-]+(\\-[A-Za-z0-9])*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9])");
		Matcher m = p.matcher(email);
		if (!(m.find())) {
			request.setAttribute("error", "A megadott email cím nem megfelelő formátumú!");
			request.getRequestDispatcher(SIGNUP_JSP_URL).forward(request, response);
		}
		p = Pattern.compile("[[A-Za-z]*[0-9]+[A-Za-z]*]*");
		String password = signupform.getPassword();
		if (!(p.matcher(password).find() && password.length() > 7)) {
			request.setAttribute("error", "A megadott jelszó nem megfelelő");
			request.getRequestDispatcher(SIGNUP_JSP_URL).forward(request, response);
		}
		String passwordagain = signupform.getPasswordagain();
		if (!(password.equals(passwordagain))) {
			request.setAttribute("error", "A jelszavak nem egyeznek!");
			request.getRequestDispatcher(SIGNUP_JSP_URL).forward(request, response);
		}
		// +36-30/1234-567
		p = Pattern.compile("(\\+)(\\d{2})(-)(\\d{2})(/)(\\d{4})(-)(\\d{3})");
		String phonenumber = signupform.getPhonenumber();
		if (!(p.matcher(phonenumber).find())) {
			request.setAttribute("error", "A megadott telefon nem megfelelő!");
			request.getRequestDispatcher(SIGNUP_JSP_URL).forward(request, response);
		}
		String pictureurl = signupform.getPictureurl();

		User user = new User();
		Login userlogin = new Login();
		userlogin.setUsername(username);
		userlogin.setPassword(password);
		user.setLogin(userlogin);
		user.setEmail(email);
		Name name = new Name();
		name.setFirst(firstname);
		name.setLast(secondname);
		user.setName(name);
		user.setPhone(phonenumber);
		Picture picture = new Picture();
		picture.setLarge(pictureurl);
		user.setPicture(picture);
		userService.registrationUser(user);
		response.sendRedirect(LOGIN_JSP_URL);
		
	}

}
