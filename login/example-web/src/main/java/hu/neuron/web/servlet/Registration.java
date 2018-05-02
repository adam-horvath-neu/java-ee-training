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
	
	private static final String REGISTRATION_JSP_URL = "registration.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("password");
		String password2 = request.getParameter("passwordConfirm");
		if (password != null && !password.equals(password2)) {
			request.setAttribute("ERROR", "Password not match!");
			request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
			return;
		}
		//TODO server side validation
		UserService service = new UserServiceImpl();
		UserVo vo = new UserVo();
		vo.setUsername(request.getParameter("username"));
		vo.setPassword(password);
		vo.setLastname(request.getParameter("lastName"));
		vo.setFirstname(request.getParameter("firstName"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		vo.setUrl(request.getParameter("picture"));

		service.registration(vo);

//		request.setAttribute("OK", "Successful registration");
		response.sendRedirect(request.getContextPath() + "/users");

	}
}
