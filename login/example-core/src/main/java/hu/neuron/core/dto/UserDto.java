package hu.neuron.core.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String url;
	private String password;
	private String email;
	private String phone;

	public UserDto() {
	}

	public UserDto(Long id, String username, String firstname, String lastname, String password, String email,
			String phone) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public UserDto(Long id, String username, String firstname, String lastname, String url, String password,
			String email, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.url = url;
		this.password = password;
		this.email = email;
		this.phone = phone;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
