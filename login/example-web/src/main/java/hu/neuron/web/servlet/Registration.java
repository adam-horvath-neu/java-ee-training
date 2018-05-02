package hu.neuron.web.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.neuron.service.UserService;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.UserVo;

@WebServlet("/registration")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService service = new UserServiceImpl();
		UserVo vo = new UserVo();
		boolean isValide = true;

		String username = request.getParameter("username");
		if (service.getUserByName(username) != null) {
			if (username.equals(service.getUserByName(username).getUsername())) {
				request.setAttribute("error", "A megadott felhaználónév már foglalt!");
				request.getRequestDispatcher("public/registration.jsp").forward(request, response);
				isValide = false;
			}
		}

		String password = request.getParameter("password");
		Pattern p = Pattern.compile("[[A-Za-z]*[0-9]+[A-Za-z]*]*");
		if (!(p.matcher(password).find() && password.length() > 7)) {
			request.setAttribute("error", "A megadott jelszó nem megfelelő");
			request.getRequestDispatcher("public/registration.jsp").forward(request, response);
			isValide = false;

		}

		String password2 = request.getParameter("passwordagain");
		if (!password.equals(password2)) {
			request.setAttribute("error", "Jelszó nem egyezik!");
			request.getRequestDispatcher("public/registration.jsp").forward(request, response);
			isValide = false;
		}

		String firstname = request.getParameter("firstname");
		if (!(firstname.length() <= 30 && firstname.length() > 0)) {
			request.setAttribute("error", "A megadott keresztnév nem megfelelő hosszúságú!");
			request.getRequestDispatcher("public/registration.jsp").forward(request, response);
			isValide = false;
		}

		String lastname = request.getParameter("lastname");
		if (!(lastname.length() <= 30 && lastname.length() > 0)) {
			request.setAttribute("error", "A megadott keresztnév nem megfelelő hosszúságú!");
			request.getRequestDispatcher("public/registration.jsp").forward(request, response);
			isValide = false;
		}

		String email = request.getParameter("email");
		p = Pattern.compile("^[A-Za-z0-9-]+(\\-[A-Za-z0-9])*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9])");
		Matcher m = p.matcher(email);
		if (!(m.find())) {
			request.setAttribute("error", "A megadott email cím nem megfelelő formátumú!");
			request.getRequestDispatcher("public/registration.jsp").forward(request, response);
			isValide = false;
		}
		// +36-30/1234-567
		p = Pattern.compile("(\\+)(\\d{2})(-)(\\d{2})(/)(\\d{4})(-)(\\d{3})");
		String phonenumber = request.getParameter("phone");
		if (!(p.matcher(phonenumber).find())) {
			request.setAttribute("error", "A megadott telefon nem megfelelő!");
			request.getRequestDispatcher("public/registration.jsp").forward(request, response);
			isValide = false;
		}

		String url = request.getParameter("url");
		if (isValide) {
			vo.setUsername(username);
			vo.setFirstname(firstname);
			vo.setLastname(lastname);
			vo.setUrl(url);
			vo.setPassword(password);
			vo.setEmail(email);
			vo.setPhone(phonenumber);
			service.registration(vo);
			response.sendRedirect("public/login.jsp");
		}

	}
}