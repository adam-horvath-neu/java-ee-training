package hu.sconherz.blog.web.login;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class SignUpForm implements Serializable {

	public SignUpForm() {
		
	}
	
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;
	
	private String passwordagain;

	private String phone;
	
	private String email;

	private String image;
	
	private String firstname;

	private String lastname;
	
	public SignUpForm(HttpServletRequest request) {
		username = request.getParameter("username");
		password = request.getParameter("password");
		passwordagain = request.getParameter("passwordagain");
		phone = request.getParameter("phonenumber");
		email = request.getParameter("email");
		image = request.getParameter("image");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the passwordagain
	 */
	public String getPasswordagain() {
		return passwordagain;
	}

	/**
	 * @param passwordagain the passwordagain to set
	 */
	public void setPasswordagain(String passwordagain) {
		this.passwordagain = passwordagain;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

}
