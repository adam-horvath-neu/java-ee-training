package hu.neuron.core.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String fistname;
	private String lastname;

	public UserDto() {
	}



	public UserDto(String username, String password, String phone, String email, String fistname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.fistname = fistname;
		this.lastname = lastname;
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
	 * @return the fistname
	 */
	public String getFistname() {
		return fistname;
	}



	/**
	 * @param fistname the fistname to set
	 */
	public void setFistname(String fistname) {
		this.fistname = fistname;
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



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
