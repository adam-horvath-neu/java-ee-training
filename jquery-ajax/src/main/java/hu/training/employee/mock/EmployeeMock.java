package hu.training.employee.mock;

import java.util.ArrayList;
import java.util.Collection;

import hu.training.employee.Employee;

public class EmployeeMock {

	private static Collection<Employee> employees;

	static {

		employees = new ArrayList<>();
		employees.add(new Employee(1, "Aladár", "20", "UI Developer"));
		employees.add(new Employee(2, "Béla", "22", "AJAX Developer"));
		employees.add(new Employee(2, "Béla", "22", "Web Developer"));
		employees.add(new Employee(3, "Cecil", "24", "UI Developer"));
		employees.add(new Employee(4, "Dénes", "27", "UI Developer"));
		employees.add(new Employee(5, "Feri", "30", "UI Developer"));
		employees.add(new Employee(6, "Sanyi", "35", "Web Developer"));
		employees.add(new Employee(7, "Pista", "20", "UI Developer"));
		employees.add(new Employee(8, "László", "25", "Web Developer"));
		employees.add(new Employee(9, "Sára", "26", "UI Developer"));
		employees.add(new Employee(10, "Csilla", "55", "Web Developer"));
		employees.add(new Employee(11, "Zsanett", "21", "UI Developer"));
		employees.add(new Employee(12, "Tomi", "19", "UI Developer"));
		employees.add(new Employee(13, "Peti", "35", "UI Developer"));
		employees.add(new Employee(14, "Tibi", "27", "Web Developer"));
		employees.add(new Employee(15, "Marianna", "28", "UI Developer"));

		/*
		 * employees = Arrays.asList(new Employee[] {
		 * 
		 * new Employee(1, "Aladár", "20", "UI Developer"), new Employee(2, "Béla",
		 * "22", "AJAX Developer"), new Employee(3, "Cecil", "27", "WEB Developer"), new
		 * Employee(4, "Dénes", "23", "JS Developer"), new Employee(5, "Ferenc", "32",
		 * "DB Developer"), new Employee(6, "Géza", "34", "BACKEND Developer"), new
		 * Employee(7, "Helén", "42", "FRONTEND Developer"), new Employee(8, "István",
		 * "55", "NORMAL Developer"), new Employee(9, "József", "45",
		 * "STUPID Developer"), new Employee(10, "Kata", "30", "WORKING Developer"), new
		 * Employee(11, "László", "34", "FACTORY Developer"), new Employee(12, "Mária",
		 * "27", "JAVA Developer"), new Employee(13, "Nóra", "28", "CSS Developer"), new
		 * Employee(14, "Olga", "30", "TEST Developer"), new Employee(15, "Péter", "27",
		 * "CONSTRUCTOR Developer"), new Employee(16, "Réka", "30",
		 * "FACTORY Developer"), new Employee(17, "Sanyi", "40", "BUILDER Developer"),
		 * new Employee(18, "Tibor", "20", "CHINESE Developer"), new Employee(19,
		 * "Ubul", "24", "KOREAN Developer"), new Employee(20, "Virág", "25",
		 * "UI Developer"),
		 * 
		 * });
		 */
	}

	public static Collection<Employee> getEmployees() {
		return employees;
	}

}
