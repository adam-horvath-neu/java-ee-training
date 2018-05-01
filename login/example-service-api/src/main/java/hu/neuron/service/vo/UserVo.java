package hu.neuron.service.vo;

import java.io.Serializable;
import java.util.List;

public class UserVo implements Serializable {
	private static final long serialVersionUID = 6059096016587583729L;

	private Long id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String firstname;
	private String lastname;
	private List<RoleVo> roles;

	public UserVo() {
	}

	public UserVo(String username, String password, String phone, String email, String firstname, String lastname,
			List<RoleVo> roles) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.roles = roles;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
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
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fistname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param fistname
	 *            the fistname to set
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
	 * @param lastname
	 *            the lastname to set
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

	public List<RoleVo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVo> roles) {
		this.roles = roles;
	}

}
