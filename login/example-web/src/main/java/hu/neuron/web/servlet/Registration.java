package hu.neuron.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;

import com.google.gson.Gson;

import hu.neuron.service.UserService;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.UserVo;


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
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("password");
		String password2 = request.getParameter("passwordagain");
		if (password != null && !password.equals(password2)) {
			request.setAttribute("ERROR", "Jelszó nem egyezik!");
		}

		UserService service = new UserServiceImpl();
		UserVo vo = new UserVo();
		vo.setUsername(request.getParameter("username"));
		vo.setPassword(password);
		vo.setFistname(request.getParameter("firstname"));
		vo.setLastname(request.getParameter("lastname"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phonenumber"));
		if(request.getParameter("bt")==null) {}
		else {
		if (request.getParameter("bt").equals("sign-up"))
		service.registration(vo);
		if(request.getParameter("bt").equals("delete")) {
			Long id = Long.parseLong(request.getParameter("id"));
			service.delete(id);
		if(request.getParameter("bt").equals("find")) {
			vo=service.findByUserName(request.getParameter("findByName"));
			System.out.println(vo.toString());
			
		}
		}
		
		}
//		String op = request.getParameter("op");
//		if(op==null) {} else {
//		if (op.equals("get")) {
//			List<UserVo> list = new ArrayList<UserVo>();
//			vo=service.findByUserName("szila");
//			list.add(vo);
//			Response rv = new Response(list);
//			Gson gson = new Gson();
//			response.setCharacterEncoding("UTF-8");
//			gson.toJson(rv, response.getWriter());
//		} 	}

		request.setAttribute("OK", Boolean.TRUE);

		request.getRequestDispatcher("registration.jsp").forward(request, response);
//		}}

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req,resp);
	
	
	}
//	public static class Response {
//		private List<UserVo> data;
//
//		public Response(List<UserVo> data) {
//			super();
//			this.data = data;
//		}
//
//		public List<UserVo> getData() {
//			return data;
//		}
//
//		public void setData(List<UserVo> data) {
//			this.data = data;
//		}
//
//	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */

	
	
}
