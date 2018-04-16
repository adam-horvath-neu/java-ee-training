package hu.training.booking.ticket;

import java.util.Arrays;
import java.util.Collection;

import hu.training.booking.dto.Ticket;

public class TicketsMock {
	private final static Collection<Ticket> tickets;

	static {
		tickets = Arrays.asList(new Ticket[] { new Ticket("1", "Balaton Sound", 19000), new Ticket("2", "Volt", 2000),
				new Ticket("3", "Oldtimer show", 5000), new Ticket("4", "Debreceni pulykanapok", 1000),
				new Ticket("5", "MITEM", 1000) });
	}

	public static Collection<Ticket> getTickets() {
		return tickets;
	}
}
