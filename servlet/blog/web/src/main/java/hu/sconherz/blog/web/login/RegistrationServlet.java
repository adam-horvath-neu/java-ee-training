package hu.sconherz.blog.web.login;

import java.io.IOException;
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
@WebServlet("/Reg")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationForm registrationForm = new RegistrationForm(request);
		User user = new User();
		
		Name name = new Name();
		name.setFirst(registrationForm.getFirstName());
		name.setLast(registrationForm.getLastName());
		user.setName(name);
		
		Login log = new Login();
		log.setUsername(registrationForm.getUserName());
		log.setPassword(registrationForm.getPassword());
		log.setMd5("-");
		log.setSalt("-");
		log.setSha1("-");
		log.setSha256("-");
		user.setLogin(log);
		
		Picture pic = new Picture();
		pic.setLarge(registrationForm.getImageUrl());
		user.setPicture(pic);
		
		user.setEmail(registrationForm.getEmail());
		user.setCell(registrationForm.getPhoneNumber());
		
		Id id = new Id();
		id.setName("-");
		id.setValue("-");
		user.setId(id);
		
		user.setGender("-");
		user.setDob("-");
		
		Location lock = new Location();
		lock.setCity("-");
		lock.setPostcode(0);
		lock.setState("-");
		lock.setStreet("-");
		user.setLocation(lock);
		
		
		user.setGender("-");
		user.setRegistered("-");
		user.setNat("-");
		user.setPhone("-");
		
		
		UserServiceImpl impl = new UserServiceImpl();
		impl.registrationUser(user);
		if(request.getParameter("bt").equals("save"))
			response.sendRedirect("public/login.jsp");
		
		
		
		
		
		
		
	}

}
