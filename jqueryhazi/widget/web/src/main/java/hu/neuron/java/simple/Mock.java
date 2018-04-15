package hu.neuron.java.simple;

import java.util.Arrays;
import java.util.Collection;


public class Mock {
	
	private final static Collection<Employee> employees;

	static {
		employees = Arrays.asList(new Employee[] {
				new Employee(1, "AA", "21", "mechanic"),
				new Employee(2, "BB", "21", "regional director"),
				new Employee(3, "CC", "21", "mechanic"),
				new Employee(4, "DD", "21", "senior developer"),
				new Employee(5, "EE", "21", "senior developer"),
				new Employee(6, "FF", "21", "sales-assistant"),
				new Employee(7, "GG", "21", "software engineer"),
				new Employee(8, "II", "21", "software engineer"),
				new Employee(9, "JJ", "21", "tester"),
				new Employee(10, "KK", "21", "tester"),
				new Employee(11, "LL", "21", "developer"),
				new Employee(12, "MM", "21", "CEO"),
				new Employee(13, "NN", "21", "assistant"),
				new Employee(14, "OO", "21", "project manager"),
				new Employee(15, "PP", "21", "developer"),
				
		});
	}
	
	public static Collection<Employee> getEmployees() {
		return employees;
	}
}
