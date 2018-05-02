package hu.neuron.service.vo;

import java.io.Serializable;
import java.util.List;

public class UserVo implements Serializable {
	private static final long serialVersionUID = 6059096016587583729L;

	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String url;
	private String password;
	private String email;
	private String phone;
	private List<RoleVo> roles;

	public UserVo() {
	}

	public UserVo(Long id, String username, String firstname, String lastname, String url, String password,
			String email, String phone, List<RoleVo> roles) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.url = url;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.roles = roles;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<RoleVo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVo> roles) {
		this.roles = roles;
	}

}
