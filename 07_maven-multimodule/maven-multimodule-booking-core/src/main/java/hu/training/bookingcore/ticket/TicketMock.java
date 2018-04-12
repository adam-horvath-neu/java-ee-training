package hu.training.bookingcore.ticket;

import java.util.Arrays;
import java.util.Collection;

import hu.training.bookingapi.Ticket;

public class TicketMock {

		private final static Collection<Ticket> tickets;

		static {
			tickets = Arrays.asList(new Ticket[] {
					new Ticket("1", "ticket1", 5000),
					new Ticket("2", "ticket2", 6000),
					new Ticket("3", "ticket3", 100000),
					new Ticket("4", "ticket4", 1000),
					new Ticket("5", "ticket5", 9000),
					new Ticket("6", "ticket6", 8000),
					new Ticket("7", "ticket7", 3000) });
		}
		
		public static Collection<Ticket> getTickets() {
			return tickets;
		}
		public static Ticket getTicketByID(String Id) {
			for (Ticket ticket:tickets) {
				if (ticket.getId().equals(Id))
					return ticket;
			}
			return null;	
		}

}
