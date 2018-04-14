package hu.training.ticketmock;

import java.util.Arrays;
import java.util.Collection;

import hu.training.ticket.Ticket;

public class TicketMock {

	private final static Collection<Ticket> tickets;
	
	static {
		tickets = Arrays.asList(new Ticket[]{
			new Ticket("1", "Campus Party", 800),
			new Ticket("2", "Showder Klub", 3000),
			new Ticket("3", "Football", 5000),
			new Ticket("4", "Campus Festival", 10000),
			new Ticket("5", "City Tour", 2000),
			new Ticket("6", "Ship Tour", 4000)
		});
	}
	
	public static Collection<Ticket> getTickets() {
		return tickets;
	}
	
}
