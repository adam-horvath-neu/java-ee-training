package hu.sconherz.blog.web.signup;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class SignUpForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String firstname;
	private String secondname;
	private String password;
	private String passwordagain;
	private String email;
	private String phonenumber;
	private String pictureurl;

	SignUpForm() {

	}

	public SignUpForm(HttpServletRequest request) {
		username = request.getParameter("username");
		firstname = request.getParameter("firstname");
		secondname = request.getParameter("secondname");
		password = request.getParameter("password");
		passwordagain = request.getParameter("passwordagain");
		email = request.getParameter("email");
		phonenumber = request.getParameter("phonenumber");
		pictureurl = request.getParameter("pictureurl");
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordagain() {
		return passwordagain;
	}

	public void setPasswordagain(String passwordagain) {
		this.passwordagain = passwordagain;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
