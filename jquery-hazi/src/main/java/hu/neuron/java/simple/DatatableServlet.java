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
 * Servlet implementation class DatatableServlet
 */
@WebServlet("/DatatableServlet")
public class DatatableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DatatableServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String op = request.getParameter("op");
		Collection<Data> employee = DatatableMock.getEmployee();
		if(op.equals("get")) {
			
			Response rv = new Response(new ArrayList<Data>(employee));
			Gson gson = new Gson();
			response.setCharacterEncoding("UTF-8");
			gson.toJson(rv, response.getWriter());
			
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String op = request.getParameter("op");
		Collection<Data> employee = DatatableMock.getEmployee();
		
		 if (op.equals("add")) {
			 Integer id = new Integer( employee.size());
				String name = request.getParameter("name");
				String job = request.getParameter("job");
				String age = request.getParameter("age");
				employee.add(new Data(id,name,job,age));
			}
		
	}
	
	public static class Response {
		
		
		private ArrayList<Data> data;

		

		public Response(ArrayList<Data> data) {
			super();
			this.data = data;
		}

		public ArrayList<Data> getEmploye() {
			return data;
		}

		public void setEmploye(ArrayList<Data> data) {
			this.data = data;
		}

		
		
	}
	

}
