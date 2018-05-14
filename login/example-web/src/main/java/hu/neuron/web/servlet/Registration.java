package hu.neuron.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.neuron.service.UserService;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.UserVo;

@WebServlet("/registration")
public class Registration extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String REGISTRATION_JSP_URL = "registration.jsp";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("password");
		String password2 = request.getParameter("cpassword");
		if (password != null && !password.equals(password2)) {
			request.setAttribute("ERROR", "Jelszó nem egyezik!");
			request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			
		}
		String userName = request.getParameter("user_name");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String userEmail = request.getParameter("user_email");
		String phone_number = request.getParameter("phone_number");
		String profile_picture = request.getParameter("profile_picture");
		
		UserService service = new UserServiceImpl();
		UserVo vo = new UserVo();
		vo.setUsername(userName);
		vo.setPassword(password);
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setUserEmail(userEmail);
		vo.setPhoneNumber(phone_number);
		vo.setPictureUrl(profile_picture);
		service.registration(vo);
		request.setAttribute("OK", Boolean.TRUE);

		request.getRequestDispatcher("users.jsp").forward(request, response);
		

	}
}
