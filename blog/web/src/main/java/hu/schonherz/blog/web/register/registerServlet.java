package hu.schonherz.blog.web.register;

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
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGIN_JSP_URL = "public/login.jsp";
	private static final String REGISTRATION_JSP_URL = "public/registration.jsp";


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Register register = new Register(request);
		
		User create = new User();
		Login log = new Login();
			
		Id id = new Id();
	    create.setId(id);
		
	    Picture picture = new Picture();
	    picture.setLarge(register.getPicture());
	    create.setPicture(picture);
		
			
			if(register.getUsername().length() <= 30) {
				log.setUsername(register.getUsername());
			} else {
				request.setAttribute("error", "Helytelen felhasználónév");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
			
			Name name = new Name();
			
			if(register.getLastName().length() <= 30) {
				name.setLast(register.getLastName());
			} else {
				request.setAttribute("error", "Helytelen Név");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
			if(register.getFirstName().length() <= 30) {
				name.setFirst(register.getFirstName());
			} else {
				request.setAttribute("error", "Helytelen Név");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
			
			String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(register.getEmail());
            if (matcher.matches()) {
            	create.setEmail(register.getEmail());
            }
			
			 else {
				request.setAttribute("error", "Helytelen E-mail cím");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
            
           
            
            
			if(register.getPhone().matches( "(\\+)(\\d{2})(-)(\\d{2})(/)(\\d{4})(-)(\\d{3})")) {
				create.setPhone(register.getPhone());
			} else {
				request.setAttribute("error", "Helytelen Név");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
			
			if(register.getPassword().length() <= 8 && register.getPassword().equals(register.getPassword2()) ) {
				log.setPassword(register.getPassword());
			} else {
				request.setAttribute("error", "Helytelen jelszó");
				request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			}
			create.setLogin(log);
			
			
			create.setCell(register.getPassword());
		
		UserService userservice = new  UserServiceImpl();
		userservice.registrationUser(create);
		
		
		
		request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
		
		
		
		
		}

	}


