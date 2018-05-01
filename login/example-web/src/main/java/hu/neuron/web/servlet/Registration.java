package hu.neuron.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		UserService service = new UserServiceImpl();
		String op = request.getParameter("op");
		String password = request.getParameter("password");
		String password2 = request.getParameter("passwordagain");
		if (password != null && !password.equals(password2)) {
			request.setAttribute("ERROR", "Jelszó nem egyezik!");
		}
		else {
		UserVo vo = new UserVo();
		vo.setUsername(request.getParameter("username"));
		vo.setPassword(password);
		vo.setFirstname(request.getParameter("firstname"));
		vo.setLastname(request.getParameter("lastname"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		
		
		if(op.equals("add"))			
		
			service.registration(vo);
		}
		if(op.equals("del")) {
			Long id = Long.parseLong(request.getParameter("did"));
			service.delete(id);
		}
		else if(op.equals("update")) {
			UserVo vo = new UserVo();
			vo.setUsername(request.getParameter("username"));
			vo.setPassword(request.getParameter("password"));
			vo.setFirstname(request.getParameter("firstname"));
			vo.setLastname(request.getParameter("lastname"));
			vo.setEmail(request.getParameter("email"));
			vo.setPhone(request.getParameter("phone"));
			service.update(vo);
		}
		request.setAttribute("OK", Boolean.TRUE);
		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		UserService service = new UserServiceImpl();
		if (op.equals("get")) {
			List<UserVo> list = new ArrayList<UserVo>();			
			list =service.findAllElements();
			if(list.isEmpty()) {
				}
			else {
			Response rv = new Response(list);
			Gson gson = new Gson();
			resp.reset();
			resp.setCharacterEncoding("UTF-8");
			
			gson.toJson(rv, resp.getWriter());
			}
			resp.getWriter().close();
		}	
	}
	public static class Response {
		private List<UserVo> data;

		public Response(List<UserVo> data) {
			super();
			this.data = data;
		}

		public List<UserVo> getData() {
			return data;
		}

		public void setData(List<UserVo> data) {
			this.data = data;
		}
	}	
}
