package hu.sconherz.blog.web.register;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class RegistrationForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	
	private String firstname;

	private String lastname;
	
	private String email;
	
	private String phone;
	
	private String image;

	private String password;
		
	private String password2;
	
	public RegistrationForm() {

	}

	public RegistrationForm(HttpServletRequest request) {
		username = request.getParameter("username");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		image = request.getParameter("picture");
		password = request.getParameter("password");
		password2 = request.getParameter("password2");	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
