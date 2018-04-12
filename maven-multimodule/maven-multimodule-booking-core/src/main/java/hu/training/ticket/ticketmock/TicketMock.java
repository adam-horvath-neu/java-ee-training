package hu.training.ticket.ticketmock;

import java.util.Arrays;
import java.util.Collection;

import hu.training.ticketbuilder.Ticket;

public class TicketMock {
	
	private final static Collection<Ticket> tickets;

	static {
		tickets = Arrays.asList(new Ticket[] {
				new Ticket("1","Cinema 4DX", 2900),
				new Ticket("2","Hall", 1200),
				new Ticket("3","Concert", 2000),
				new Ticket("4","Talkshow", 2000),
				new Ticket("5","Formula-1", 25000),
				});
	}
	
	public static Collection<Ticket> getTickets() {
		return tickets;
	}


}
