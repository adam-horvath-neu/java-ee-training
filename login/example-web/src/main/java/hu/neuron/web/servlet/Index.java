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

/**
 * Servlet implementation class Index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService service = new UserServiceImpl();
		String whatToDo = "-";
		if (null!=request.getParameter("action")) {
			whatToDo=request.getParameter("action");
		}
		System.out.println(whatToDo);
		if (whatToDo.equals("add")) {
			UserVo vo = new UserVo();
			vo.setUsername(request.getParameter("username"));
			vo.setPassword(request.getParameter("password"));
			vo.setEmail(request.getParameter("email"));
			vo.setFirstname(request.getParameter("firstname"));
			vo.setLastname(request.getParameter("lastname"));
			vo.setPhone(request.getParameter("phone"));
			vo.setUrl(request.getParameter("picture"));
			
			service.registration(vo);
		}
//		} else {
//			UserVo vo = new UserVo();
//			vo.setUsername(request.getParameter("username"));
//			vo.setPassword(request.getParameter("password"));
//			vo.setEmail(request.getParameter("email"));
//			vo.setFirstname(request.getParameter("firstname"));
//			vo.setLastname(request.getParameter("lastname"));
//			vo.setPhone(request.getParameter("phone"));
//			vo.setUrl(request.getParameter("picture"));
//			
//			service.registration(vo);
//		}
		request.setAttribute("users", service.getAllUsers());
		request.getRequestDispatcher("index.jsp").forward(request, response);
		

	}

}
