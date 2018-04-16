package hu.training.employee.mock;

import java.util.ArrayList;
import java.util.Collection;

import hu.training.employee.Employee;

public class EmployeeMock {

	private static Collection<Employee> employees;

	static {
		employees = new ArrayList<>();
		employees.add(new Employee(1, "Adam", 20, "Software Developer"));
		employees.add(new Employee(2, "Béla", 21, "Backend Developer"));
		employees.add(new Employee(2, "Sándor", 22, "Frontend Developer"));
		employees.add(new Employee(3, "József", 23, "UI Developer"));
		employees.add(new Employee(4, "Benedek", 24, "Project Manager"));
		employees.add(new Employee(5, "Kristóf", 25, "UI Developer"));
		employees.add(new Employee(6, "Kornél", 26, "Backend Developer"));
		employees.add(new Employee(7, "István", 27, "UI Developer"));
		employees.add(new Employee(8, "Miklós", 28, "Frontend Developer"));
		employees.add(new Employee(9, "László", 29, "UX Designer"));
		employees.add(new Employee(10, "Menyhárt", 30, "Web Developer"));
		employees.add(new Employee(11, "Lilla", 31, "Software Developer"));
		employees.add(new Employee(12, "Tamás", 32, "Software Developer"));
		employees.add(new Employee(13, "Adam", 33, "Software Developer"));
		employees.add(new Employee(14, "Attila", 34, "Software Developer"));
		employees.add(new Employee(15, "Sándor", 35, "Software Developer"));
	}

	public static Collection<Employee> getEmployees() {
		return employees;
	}

}
