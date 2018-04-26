package hu.sconherz.blog.web.login;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class RegistrationForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String picture;
	private String password;
	private String password2;

	public RegistrationForm() {

	}

	public RegistrationForm(HttpServletRequest request) {
		username = request.getParameter("username");
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		picture = request.getParameter("userpicture");
		password = request.getParameter("password");
		password2 = request.getParameter("password2");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}