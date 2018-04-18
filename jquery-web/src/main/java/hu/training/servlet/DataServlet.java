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
 * Servlet implementation class DataServlet
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
		Collection<Worker> wmock = WorkerMock.returnWorkerMock();

		if (op.equals("get")) {

			Response rv = new Response(new ArrayList<Worker>(wmock));
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
		doGet(request, response);
		String op = request.getParameter("op");
		Collection<Worker> wmock = WorkerMock.returnWorkerMock();

		if (op.equals("add")) {

			String name = request.getParameter("name");
			String role = request.getParameter("role");
			String age = request.getParameter("age");
			Long id = new Long(wmock.size());
			Worker e = new Worker(id, Integer.parseInt(age), name, role);
			wmock.add(new Worker(id, Integer.parseInt(age), name, role));

		}
	}

	public static class Response {
		private ArrayList<Worker> data;

		public Response(ArrayList<Worker> data) {
			super();
			this.data = data;
		}

		public ArrayList<Worker> getData() {
			return data;
		}

		public void setData(ArrayList<Worker> data) {
			this.data = data;
		}

	}

}
