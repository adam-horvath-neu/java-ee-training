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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if (password != null && !password.equals(password2)) {
			request.setAttribute("ERROR", "Jelszó nem egyezik!");
		}

		UserService service = new UserServiceImpl();
		UserVo vo = new UserVo();
		vo.setUsername(request.getParameter("username"));
		vo.setPassword(password);
		vo.setFirstname(request.getParameter("firstname"));
		vo.setLastname(request.getParameter("lastname"));
		vo.setUrl(request.getParameter("url"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		service.registration(vo);
		
		
		request.setAttribute("OK", Boolean.TRUE);
		
		request.getRequestDispatcher("registration.jsp").forward(request, response);

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		UserService service = new UserServiceImpl();
		if (op.equals("get")) {
			List<UserVo> lista = new ArrayList<UserVo>();			
			lista = service.findAllElements();
			if(lista.isEmpty()) {
				}
			else {
			Response rv = new Response(lista);
			Gson gson = new Gson();
			response.reset();
			response.setCharacterEncoding("UTF-8");
			gson.toJson(rv, response.getWriter());
			}
			
			response.getWriter().close();
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
