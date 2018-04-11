package hu.training.ticketmock;

import java.util.Arrays;
import java.util.Collection;

import hu.training.ticket.Ticket;

public class TicketMock {
	
	private final static Collection<Ticket> tickets;
	
	static {
		tickets = Arrays.asList(new Ticket[]{
			new Ticket("1", "Formula 1", 20000),
			new Ticket("2", "Football", 8000),
			new Ticket("3", "Basketball", 5000),
			new Ticket("4", "Festival", 15000),
			new Ticket("5", "Museum", 2000)
		});
	}

	public static Collection<Ticket> getTickets() {
		return tickets;
	}
}
