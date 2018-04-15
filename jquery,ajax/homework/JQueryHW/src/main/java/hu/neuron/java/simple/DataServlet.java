package hu.neuron.java.simple;

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
		String op = request.getParameter("op");
//		HashMap<Long, Data> db = DbMock.getDb();
		Collection<Employee> db = EmployeeMock.getEmployees();
		if (op.equals("get")) {

			Response rv = new Response(new ArrayList<Employee>(db));
			Gson gson = new Gson();
			response.setCharacterEncoding("UTF-8");
			gson.toJson(rv, response.getWriter());
		} else if (op.equals("add")) {
			Integer id = new Integer(db.size());
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String job = request.getParameter("job");
			db.add(new Employee(id, name, age, job));			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static class Response {
		private ArrayList<Employee> data;

		public Response(ArrayList<Employee> data) {
			super();
			this.data = data;
		}

		public ArrayList<Employee> getData() {
			return data;
		}

		public void setData(ArrayList<Employee> data) {
			this.data = data;
		}

	}

}
