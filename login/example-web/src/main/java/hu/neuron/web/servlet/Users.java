package hu.neuron.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.neuron.service.UserService;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.UserVo;

/**
 * Servlet implementation class Users
 */
@WebServlet("/users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP_URL = "users.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService service = new UserServiceImpl();

		String name = request.getParameter("searchName");

		UserVo vo = service.findByUsername(name);

		List<UserVo> list = service.findAll();

		request.setAttribute("resultList", list);
		request.getRequestDispatcher(JSP_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO make it cleaner ajax

		String operation = request.getParameter("op");
		UserService service = new UserServiceImpl();
		Long id = Long.parseLong(request.getParameter("id"));
		if ("delete".equals(operation)) {
			System.out.println("delete");

			service.delete(id);
		} else if ("update".equals(operation)) {
			System.out.println("update");
		}

		response.sendRedirect(JSP_URL);
	}

}
