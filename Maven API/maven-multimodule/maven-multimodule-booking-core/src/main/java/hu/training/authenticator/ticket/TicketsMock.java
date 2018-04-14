package hu.training.authenticator.ticket;

import java.util.Arrays;
import java.util.Collection;

import hu.training.authenticator.payment.PaymentFactory;
import hu.training.merchant.MerchantType;
import hu.training.payment.PaymentType;
import hu.training.service.BookingService;
import hu.training.ticket.Ticket;

public class TicketsMock {
	public final static Collection<Ticket> tickets;
	
	static {
		tickets = Arrays.asList(new Ticket[] {
				new Ticket("1", "event1", 1),
				new Ticket("2", "event2", 2),
				new Ticket("3", "event3", 3),
				new Ticket("4", "event4", 4),
				new Ticket("5", "event5", 5)
				});
	}
	
	public Collection<Ticket> getTickets() {
		return tickets;
	}

}
