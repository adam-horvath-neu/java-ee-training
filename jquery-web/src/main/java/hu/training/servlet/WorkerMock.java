package hu.training.servlet;

import java.util.ArrayList;
import java.util.Collection;

public class WorkerMock {

	private static Collection<Worker> wmock;

	static {
		wmock = new ArrayList<>();

		wmock.add(new Worker(1L, 42, "Kiss Bela", "HR Manager"));
		wmock.add(new Worker(2L, 32, "Kovacs Adam", "Tester"));
		wmock.add(new Worker(3L, 26, "Kocsis Nikolett", "Developer"));
		wmock.add(new Worker(4L, 24, "Torok Balint", "Developer"));
		wmock.add(new Worker(5L, 32, "Nagy Adam", "Tester"));
		wmock.add(new Worker(6L, 26, "Boldizsar Gergo", "Developer"));
		wmock.add(new Worker(7L, 34, "Kiss Bela", "HR Trainee"));
		wmock.add(new Worker(8L, 54, "Kovacs Dezso", "Tester"));
		wmock.add(new Worker(9L, 27, "Tobias Mark", "Developer"));
		wmock.add(new Worker(10L, 42, "Kincs Aminincs", "Junior Trainee"));
		wmock.add(new Worker(11L, 32, "Georgiana Leal", "Tester"));
		wmock.add(new Worker(12L, 26, "Elisa Woodard", "Developer"));
		wmock.add(new Worker(13L, 42, "Franciszek Patton", "Manager"));
		wmock.add(new Worker(14L, 32, "Kit Cain", "Tester"));
		wmock.add(new Worker(15L, 26, "Dexter Pollard", "Developer"));
		wmock.add(new Worker(16L, 42, "Harlow George", "Manager"));
		wmock.add(new Worker(17L, 32, "Misty Molloy", "Tester"));
		wmock.add(new Worker(18L, 26, "Chester Irvine", "Developer"));
		wmock.add(new Worker(19L, 42, "Rebecca Dawe", "Manager"));
		wmock.add(new Worker(20L, 32, "Aleisha Aldred", "Tester"));
		wmock.add(new Worker(21L, 26, "George Smith", "Developer"));
	}

	static Collection<Worker> returnWorkerMock() {
		return wmock;
	}
}
