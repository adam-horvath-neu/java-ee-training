package hu.sconherz.blog.web.login;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.vo.Id;
import hu.schonherz.blog.service.api.user.vo.Location;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationForm regform = new RegistrationForm(request);
		User user = new User();
		user.setEmail(regform.getEmail());
		user.setCell(regform.getPhone());
		Name name = new Name();
		name.setFirst(regform.getFirstname());
		name.setLast(regform.getLastname());
		name.setTitle("Mr/Mrs");
		user.setName(name);
		user.setGender("-");
		Id id = new Id();
		id.setName("-");
		id.setValue(null);
		Login log = new Login();
		log.setUsername(regform.getUsername());
		log.setPassword(regform.getPassword());
		user.setLogin(log);
		user.setDob("-");
		Location location = new Location();
		location.setCity("-");
		location.setPostcode(1111);
		location.setState("-");
		location.setStreet("-");
		user.setLocation(location);
		user.setId(id);
		user.setNat("-");
		user.setPhone("-");
		String regTime = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
		user.setRegistered(regTime);
		Picture pic = new Picture();
		pic.setLarge(regform.getPicture());
		user.setPicture(pic);
		UserServiceImpl userService = new UserServiceImpl();
		userService.registrationUser(user);
		if (request.getParameter("bt").equals("regist"))
			response.sendRedirect("public/login.jsp");
	}

}
