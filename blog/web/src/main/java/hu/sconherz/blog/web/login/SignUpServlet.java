package hu.sconherz.blog.web.login;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.ListClass;
import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.Id;
import hu.schonherz.blog.service.api.user.vo.Location;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SignUpForm signUpForm = new SignUpForm(request);
		User user = new User();
		
		user.setEmail(signUpForm.getEmail());
		user.setCell(signUpForm.getPhone());
		
		Name name =new Name();
		name.setFirst(signUpForm.getFirstname());
		name.setLast(signUpForm.getLastname());
		name.setTitle("Mr/Mrs");
		user.setName(name);
		user.setDob("-");
		user.setGender("male/female");
		
		Id id = new Id();
		id.setName("-");
		id.setValue(null);	
		user.setId(id);
		
		Location loc = new Location();
		loc.setCity("-");
		loc.setPostcode(000);
		loc.setState("-");
		loc.setStreet("-");
		user.setLocation(loc);
		user.setNat("-");
		user.setPhone("-");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.-HH:mm").format(Calendar.getInstance().getTime());
		user.setRegistered(timeStamp);
		
		Login log = new Login();
		log.setUsername(signUpForm.getUsername());
	
		
		log.setPassword(signUpForm.getPassword());
		
		user.setLogin(log);
		
		Picture pic = new Picture();
		pic.setLarge(signUpForm.getImage());
		user.setPicture(pic);
		
		UserServiceImpl serviceImpl = new UserServiceImpl();
		serviceImpl.registrationUser(user);
		if (request.getParameter("bt").equals("sign-up")) {
	        
        	response.sendRedirect("public/login.jsp");

    }
		
	}

}
