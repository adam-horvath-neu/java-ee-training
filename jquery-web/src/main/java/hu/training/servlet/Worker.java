package hu.training.servlet;

import java.io.Serializable;

public class Worker implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private int age;
	private String name;
	private String role;
	
	public Worker(Long id, int age, String name, String role) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
	
}
