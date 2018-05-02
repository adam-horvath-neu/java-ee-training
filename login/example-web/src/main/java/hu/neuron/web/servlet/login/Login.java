package hu.neuron.web.servlet.login;

import java.awt.geom.GeneralPath;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.neuron.service.UserService;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.UserVo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String LOGIN_JSP_URL = "public/login.jsp";
	private static final String SECURED_JSP_URL = "secured/secured.jsp";

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		UserService userService = new UserServiceImpl();
		UserVo userVo = null;
		try {

			userVo = userService.getUserByName(username);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Hibás felhasználónév!");
			request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
			return;
		}
		if (userVo != null) {
			String password = request.getParameter("password");
			if (userVo.getPassword().equals(password)) {
				request.getSession().setAttribute("user", userVo);
				response.sendRedirect(SECURED_JSP_URL);

			} else {
				request.setAttribute("error", "Hibás jelszó!");
				request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
	}
}