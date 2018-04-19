package hu.sconherz.blog.web.login;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class RegistrationForm implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String imageUrl;
	private String password;
	private String passwordAgain;
	
	public RegistrationForm() {}

	public RegistrationForm(HttpServletRequest request) {
		userName = request.getParameter("username");
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		email = request.getParameter("email");
		phoneNumber = request.getParameter("phone");
		imageUrl = request.getParameter("picture");
		password = request.getParameter("password");
		passwordAgain = request.getParameter("passwordAgain");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
