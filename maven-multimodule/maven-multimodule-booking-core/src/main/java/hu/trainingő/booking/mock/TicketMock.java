package hu.trainingő.booking.mock;

import java.util.Arrays;
import java.util.Collection;

import hu.training.booking.Ticket;;

public class TicketMock  {

	private static final Collection<Ticket> ticket;
	
	static{
		ticket = Arrays.asList(new Ticket[]{
				
			new Ticket("1", "Utazas1", 10000),
			new Ticket("2", "Utazas2", 20000),
			new Ticket("3", "Utazas3", 40000),
			new Ticket("4", "Utazas4", 80000),
			new Ticket("5", "Utazas5", 16000),
			
		});
		
	}


	public static Collection<Ticket> getTicket() {
		return ticket;
	}

	
	
	
}
