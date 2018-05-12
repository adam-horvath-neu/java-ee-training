package hu.neuron.web.servlet.data;

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

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DataServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		UserService userservice = new UserServiceImpl();
		List<UserVo> db = userservice.findAllUser();

		if (op.equals("get")) {
			Response rv = new Response(new ArrayList<UserVo>(db));
			Gson gson = new Gson();
			response.setCharacterEncoding("UTF-8");
			gson.toJson(rv, response.getWriter());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		String op = request.getParameter("op");
		if ("add".equals(op)) {
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			if (password != null && !password.equals(password2)) {
				request.setAttribute("ERROR", "The passwords do not match!");
			}
			UserVo vo = new UserVo();
			vo.setUsername(request.getParameter("username"));
			vo.setPassword(password);
			vo.setFirstname(request.getParameter("firstname"));
			vo.setLastname(request.getParameter("lastname"));
			vo.setEmail(request.getParameter("email"));
			vo.setPhone(request.getParameter("phone"));
			service.registration(vo);
			
		} else if ("delete".equals(op)) {
			Long id = Long.parseLong(request.getParameter("id"));
			userService.delete(id);
		} else if ("update".equals(op)) {
			
			UserVo userVo = new UserVo();
			userVo.setUsername(request.getParameter("username"));
			userVo.setFirstname(request.getParameter("firstname"));
			userVo.setLastname(request.getParameter("lastname"));
			userVo.setEmail(request.getParameter("email"));
			userVo.setPhone(request.getParameter("phone"));
			String idString = request.getParameter("id");
			Long id = new Long(idString);
			userVo.setId(id);
			service.update(userVo);

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