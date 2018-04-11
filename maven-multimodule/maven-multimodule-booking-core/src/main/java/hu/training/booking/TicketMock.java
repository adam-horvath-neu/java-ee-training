package hu.training.booking;

import java.util.Arrays;
import java.util.Collection;

import hu.training.ticket.Ticket;

public class TicketMock {
	
	private final static Collection<Ticket> tickets;

	static {
		tickets = Arrays.asList(new Ticket[] {
				new Ticket("1", "Mozi", 1200),
				new Ticket("2", "Szinhaz", 1000),
				new Ticket("3", "Koncert", 3000),
				new Ticket("4", "Muzeum", 900),
				new Ticket("5", "Felcsutikisvonat", 4000),
				new Ticket("6", "Allatkert", 2000)});
	}
	
	public static Collection<Ticket> getTickets() {
		return tickets;
	}

}
