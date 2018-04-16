package homework;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ HashMap<Long, Employee> db = Mock.getDb();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String op = request.getParameter("op");
			
			if (op.equals("get")) {

				Response rv = new Response(new ArrayList<Employee>(db.values()));
				Gson gson = new Gson();
				response.setCharacterEncoding("UTF-8");
				gson.toJson(rv, response.getWriter());
			} 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if (op.equals("add")) {

			
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String role = request.getParameter("job");
			

			Long id = new Long(db.size());
			
			db.put(id, new Employee(id, name, age, role));
			 
		}	
	
		
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
