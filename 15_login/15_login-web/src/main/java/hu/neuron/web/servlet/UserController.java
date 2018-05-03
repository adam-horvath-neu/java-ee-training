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

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";

	public UserController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		UserService service = new UserServiceImpl();
		if (action.equalsIgnoreCase("delete")) {
			Long userId = Long.parseLong(request.getParameter("userId"));
			service.deleteUser(userId);
			forward = LIST_USER;
			request.setAttribute("users", service.getAllUsers());
			
		} else if (action.equalsIgnoreCase("edit")) {
			
			forward = INSERT_OR_EDIT;
			Long userId = Long.parseLong(request.getParameter("userId"));
			UserVO vo = new UserVO();
			vo = service.getUserById(userId);
			request.setAttribute("user", vo);
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("users", service.getAllUsers());
		} else {
			forward = INSERT_OR_EDIT;
		}
		request.getRequestDispatcher(forward).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVO vo = new UserVO();
		UserService service = new UserServiceImpl();
		String userid = request.getParameter("userid");
		vo.setUsername(request.getParameter("username"));
		vo.setPassword(request.getParameter("password"));
		vo.setFirstname(request.getParameter("firstname"));
		vo.setLastname(request.getParameter("lastname"));
		vo.setUrl(request.getParameter("url"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));

		if (userid == null || userid.isEmpty()) {
			service.registration(vo);
		} else {

			vo.setId(Long.parseLong(userid));
			service.updateUser(vo);
		}

		request.setAttribute("users", service.getAllUsers());
		request.getRequestDispatcher(LIST_USER).forward(request, response);

	}
}