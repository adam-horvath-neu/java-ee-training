package hu.training.booking.ticket;

import java.util.Arrays;
import java.util.Collection;

import hu.training.ticketing.Ticket;

public class TicketsMock {
	
	private final static Collection<Ticket> tickets;

	static {
		tickets = Arrays.asList(new Ticket[] {
				new Ticket(1,"Sound jegy",40000),
				new Ticket(2,"Campus jegy",15000),
				new Ticket(3,"Sziget jegy",30000),
				new Ticket(4,"Volt jegy",20000),
				new Ticket(5,"Tomorrowland jegy",50000)
		});
		
		
	}
	
	public static Collection<Ticket> getTickets() {
		return tickets;
	}
	
	
	

}
