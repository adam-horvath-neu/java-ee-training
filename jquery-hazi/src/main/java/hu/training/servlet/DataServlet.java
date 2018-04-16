package hu.training.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<Data> db = DbMock.getDb();
		String op = request.getParameter("op");
		if (op.equals("get")) {

			Response rv = new Response(new ArrayList<Data>(db));
			Gson gson = new Gson();
			response.setCharacterEncoding("UTF-8");
			gson.toJson(rv, response.getWriter());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<Data> db = DbMock.getDb();
		String op = request.getParameter("op");
		if (op.equals("add")) {
			int id = db.size();
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String job = request.getParameter("job");
			db.add(new Data(id, name, age, job));

		}
	}

	public static class Response {
		private ArrayList<Data> data;

		public Response(ArrayList<Data> data) {
			super();
			this.data = data;
		}

		public ArrayList<Data> getData() {
			return data;
		}

		public void setData(ArrayList<Data> data) {
			this.data = data;
		}

	}

}
