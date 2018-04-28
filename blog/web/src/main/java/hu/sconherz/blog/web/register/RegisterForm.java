package hu.sconherz.blog.web.register;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

import hu.schonherz.blog.service.api.user.vo.User;

public class RegisterForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String user_name;
	private String first_name;
	private String last_name;
	private String user_email;
	private String profile_picture;
	private String phone_number;
	private String password;
	private String cpassword;
	
	public RegisterForm() {
		
	}

	public RegisterForm(HttpServletRequest request) {
		  this.user_name = request.getParameter("user_name");
		  this.first_name = request.getParameter("first_name");
		  this.last_name = request.getParameter("last_name");
		  this.user_email = request.getParameter("user_email");
		  this.profile_picture = request.getParameter("profile_picture");
		  this.phone_number = request.getParameter("phone_number");
		  this.password = request.getParameter("password");
		  this.cpassword = request.getParameter("cpassword");
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

}
