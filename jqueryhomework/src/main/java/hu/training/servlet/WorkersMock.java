package hu.training.servlet;

import java.util.ArrayList;
import java.util.Collection;


public class WorkersMock {

	private static Collection<Worker> workers;

	static {
		workers = new ArrayList<>();
		workers.add(new Worker(1, "Máté", 20, "Frontend fejlesztő"));
		workers.add(new Worker(2, "Sándor", 21, "Fejlesztő"));
		workers.add(new Worker(2, "János", 34, "Tesztelő"));
		workers.add(new Worker(6, "Kornél", 31, "Backend fejlesztő"));
		workers.add(new Worker(3, "Zoltán", 22, "Tesztelő"));
		workers.add(new Worker(4, "Miklós", 24, "Tesztelő"));
		workers.add(new Worker(5, "Dávid", 26, "Frontend fejlesztő"));
		workers.add(new Worker(7, "István", 27, "Frontend fejlesztő"));
		workers.add(new Worker(8, "Tamás", 24, "Tesztelő"));
		workers.add(new Worker(9, "Attila", 33, "Designer"));
		workers.add(new Worker(10, "Krisztina", 25, "Designer"));
		workers.add(new Worker(11, "Karina", 23, "Tesztelő"));
		workers.add(new Worker(12, "Tamás", 21, "Webfejlesztő"));
		workers.add(new Worker(13, "János", 27, "Backend fejlesztő"));
		workers.add(new Worker(14, "László", 28, "Webfejlesztő"));
		workers.add(new Worker(15, "Zsolt", 32, "Backend fejlesztő"));
		workers.add(new Worker(16, "Gergő", 33, "Webfejlesztő"));
		workers.add(new Worker(17, "Csaba", 30, "Tesztelő"));
		workers.add(new Worker(18, "Tamás", 30, "Tesztelő"));
	}

	
	public static Collection<Worker> getWorkers() {
		return workers;
	}

}



