package hu.neuron.java.simple;

import java.util.ArrayList;
import java.util.Collection;

public class DatatableMock {

	private static Collection<Data> employee ;
	 
	 static {
		 
		 employee = new ArrayList<>();
		 
		 employee.add(new Data(1,"Attila","Developer","24"));
		 employee.add(new Data(2,"Béla","Developer","22"));
		 employee.add(new Data(3,"Ferenc","Developer","27"));
		 employee.add(new Data(4,"Tibor","Developer","26"));
		 employee.add(new Data(5,"Sándor","Developer","25"));
		 employee.add(new Data(6,"József","Developer","21"));
		 employee.add(new Data(7,"Gábor","Developer","24"));
		 employee.add(new Data(8,"Márk","Developer","24"));
		 employee.add(new Data(9,"Ádám","Developer","24"));
		 employee.add(new Data(10,"István","Developer","29"));
		 employee.add(new Data(11,"Attila","Developer","24"));
		 employee.add(new Data(12,"Attila","HR","34"));
		 employee.add(new Data(13,"Attila","UI Developer","64"));
		 employee.add(new Data(14,"Attila","Javascript Developer","44"));
		 employee.add(new Data(15,"Attila","Java Developer","84"));
		 
	 }
	 
	 static Collection<Data> getEmployee(){
		 return employee;
	 }
	
}
