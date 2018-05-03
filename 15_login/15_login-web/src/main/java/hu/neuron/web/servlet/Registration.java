package hu.neuron.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.neuron.service.UserService;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.UserVO;

@WebServlet("/registration")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if( password!= null && !password.equals(password2)) {
			request.setAttribute("error","A ket jelszo nem egyezik");
		}
		UserService service = new UserServiceImpl();
		UserVO vo = new UserVO();
		vo.setUsername(request.getParameter("username"));
		vo.setPassword(password);
		vo.setFirstname(request.getParameter("firstname"));
		vo.setLastname(request.getParameter("lastname"));
		vo.setUrl(request.getParameter("url"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		service.registration(vo);
		
		request.setAttribute("OK",Boolean.TRUE);
		
		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

}
