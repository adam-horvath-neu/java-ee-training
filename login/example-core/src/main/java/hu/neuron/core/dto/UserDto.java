package hu.neuron.core.dto;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String pictureUrl;
	private String password;
	private String phoneNumber;

	public UserDto() {
	}
	
	

	public UserDto(Long id, String username, String firstName, String lastName, String userEmail, String pictureUrl,
			String password, String phoneNumber) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.pictureUrl = pictureUrl;
		this.password = password;
		this.phoneNumber = phoneNumber;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
