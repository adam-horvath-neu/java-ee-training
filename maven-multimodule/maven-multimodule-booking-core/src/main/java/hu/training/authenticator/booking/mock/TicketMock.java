package hu.training.authenticator.booking.mock;

import java.util.Arrays;
import java.util.Collection;

import hu.training.authenticator.booking.tckt.Ticket;;

public class TicketMock {

	private static final Collection<Ticket> ticket;
	
	static{
		ticket = Arrays.asList(new Ticket[]{
			new Ticket("ID1","EVENT1",100),
			new Ticket("ID2","EVENT2",200),
			new Ticket("ID3","EVENT3",300),
			new Ticket("ID4","EVENT4",500),
			new Ticket("ID5","EVENT5",1000),
			new Ticket("ID6","EVENT6",10000),
		});
		
	}
	
	public static Collection<Ticket> getTickets(){
		return ticket;
	}
	
	
}
