package hu.neuron.java.simple;

import java.util.ArrayList;
import java.util.Collection;


public class Mock {
	
	private final static Collection<Employee> employees;

	static {
		employees =  new ArrayList<>();
				employees.add(new Employee(1, "AA", "21", "mechanic"));
				employees.add(new Employee(2, "BB", "21", "regional director"));
				employees.add(new Employee(3, "CC", "21", "mechanic"));
				employees.add(new Employee(4, "DD", "21", "senior developer"));
				employees.add(new Employee(5, "EE", "21", "senior developer"));
				employees.add(new Employee(6, "FF", "21", "sales-assistant"));
				employees.add(new Employee(7, "GG", "21", "software engineer"));
				employees.add(new Employee(8, "II", "21", "software engineer"));
				employees.add(new Employee(9, "JJ", "21", "tester"));
				employees.add(new Employee(10, "KK", "21", "tester"));
				employees.add(new Employee(11, "LL", "21", "developer"));
				employees.add(new Employee(12, "MM", "21", "CEO"));
				employees.add(new Employee(13, "NN", "21", "assistant"));
				employees.add(new Employee(14, "OO", "21", "project manager"));
				employees.add(new Employee(15, "PP", "21", "developer"));
				
		
	}
	
	public static Collection<Employee> getEmployees() {
		return employees;
	}
}
