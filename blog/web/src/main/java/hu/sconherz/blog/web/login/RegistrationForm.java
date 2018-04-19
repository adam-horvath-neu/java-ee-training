package hu.sconherz.blog.web.login;

import java.io.Serializable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class RegistrationForm implements Serializable {

	public RegistrationForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String picture;
	private String password;
	private String password2;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public RegistrationForm(HttpServletRequest req) {
		username = req.getParameter("username");
		firstname = req.getParameter("firstname");
		lastname = req.getParameter("lastname");
		email = req.getParameter("email");
		phone = req.getParameter("phone");
		picture = req.getParameter("picture");
		password = req.getParameter("password");
		password2 = req.getParameter("password2");

	}
	
}
