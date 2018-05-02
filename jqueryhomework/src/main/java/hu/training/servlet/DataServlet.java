package hu.training.servlet;


import hu.training.servlet.WorkersMock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<Worker> db = WorkersMock.getWorkers();
		String op = request.getParameter("op");

		Response rv = new Response(new ArrayList<Worker>(db));
		Gson gson = new Gson();
		response.setCharacterEncoding("UTF-8");
		gson.toJson(rv, response.getWriter());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Collection<Worker> db = WorkersMock.getWorkers();
		String op = request.getParameter("op");

		Integer id = new Integer(db.size());
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String job = request.getParameter("job");
		db.add(new Worker(id, name, age, job));

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
