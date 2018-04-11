package hu.training.ticketsmock;

import java.util.Arrays;
import java.util.Collection;

import hu.training.ticket.Ticket;

public class TicketsMock {
	
	private final static Collection<Ticket> tickets;

	static {
		tickets = Arrays.asList(new Ticket[] {
				new Ticket("01","baseball", 7000),
				new Ticket("02","football", 2000),
				new Ticket("03","dance", 1000),
				new Ticket("04","tennis", 3000),
				new Ticket("05","concert", 5000),
				new Ticket("06","lan", 500),});
	}
	
	public static Collection<Ticket> getTickets() {
		return tickets;
	}

}
