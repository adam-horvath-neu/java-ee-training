package hu.neuron.java.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class EmployeeMock {

	private static Collection<Employee> employees;

	static {
		employees = new ArrayList<>();

		employees.add(new Employee(1, "Ádám", "20", "WebDesigner"));
		employees.add(new Employee(2, "Béla", "21", "WebDesigner"));
		employees.add(new Employee(3, "Cecil", "22", "Developer"));
		employees.add(new Employee(4, "Dezső", "23", "Developer"));
		employees.add(new Employee(5, "Elemér", "24", "SoftwareTester"));
		employees.add(new Employee(6, "Hugó", "25", "Developer"));
		employees.add(new Employee(7, "Géza", "26", "WebDesigner"));
		employees.add(new Employee(8, "Marcell", "19", "Developer"));
		employees.add(new Employee(9, "Nándi", "18", "DataBaseAdministrator"));
		employees.add(new Employee(10, "Péter", "20", "SoftwareTester"));
		employees.add(new Employee(11, "Éva", "24", "DataBaseManager"));
		employees.add(new Employee(12, "Dóra", "23", "Developer"));
		employees.add(new Employee(13, "Emma", "22", "Developer"));
		employees.add(new Employee(14, "Petra", "21", "SoftwareTester"));
		employees.add(new Employee(15, "Klára", "20", "Developer"));
		employees.add(new Employee(16, "Sára", "19", "SoftwareTester"));
		employees.add(new Employee(17, "Olga", "18", "DataBaseManager"));
		employees.add(new Employee(18, "Tünde", "34", "WebDesigner"));
		employees.add(new Employee(19, "Anna", "28", "SoftwareTester"));

	}

	public static Collection<Employee> getEmployees() {
		return employees;
	}

}
