package hu.neuron.java;

import java.util.HashMap;

public class Mock {

	static HashMap<Long, Employee> db = new HashMap<Long, Employee>();

	static HashMap<Long, Employee> getDb() {
		return db;
	}
}
