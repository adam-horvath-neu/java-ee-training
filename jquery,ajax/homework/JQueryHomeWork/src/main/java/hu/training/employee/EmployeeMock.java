package hu.training.employee;

import java.util.Arrays;
import java.util.Collection;

public class EmployeeMock {

	private static Collection<Employee> employees;

	static {

		employees = Arrays.asList(new Employee[] { new Employee(1, "Ádám", 20, "WebDesigner"),
				new Employee(2, "Béla", 21, "WebDesigner"), new Employee(3, "Cecil", 22, "Developer"),
				new Employee(4, "Dezső", 23, "Developer"), new Employee(5, "Elemér", 24, "SoftvareTester"),
				new Employee(6, "Hugó", 25, "Developer"), new Employee(7, "Géza", 26, "WebDesigner"),
				new Employee(8, "Marcell", 19, "Developer"), new Employee(9, "Nándi", 18, "DataBaseAdministrator"),
				new Employee(10, "Péter", 20, "SoftvareTester"), new Employee(11, "Éva", 24, "DataBaseManager"),
				new Employee(12, "Dóra", 23, "Developer"), new Employee(13, "Emma", 22, "Developer"),
				new Employee(14, "Petra", 21, "SoftvareTester"), new Employee(15, "Klára", 20, "Developer"),
				new Employee(16, "Sára", 19, "SoftvareTester"), new Employee(17, "Olga", 18, "DataBaseManager"),
				new Employee(18, "Tünde", 34, "WebDesigner"), new Employee(19, "Anna", 28, "SoftvareTester"),

		});
	}

	public static Collection<Employee> getEmployees() {
		return employees;
	}

}
