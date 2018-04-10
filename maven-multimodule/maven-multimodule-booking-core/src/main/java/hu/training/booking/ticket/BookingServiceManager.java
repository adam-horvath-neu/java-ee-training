package hu.training.booking.ticket;

import java.util.Collection;
import java.util.Iterator;

import hu.training.booking.BookingService;
import hu.training.ticketing.Ticket;
import hu.training.types.MerchantType;
import hu.training.types.PaymentType;

public class BookingServiceManager implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketsMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {

		Collection<Ticket> tickets = TicketsMock.getTickets();
		for (Ticket ticket : tickets) {
			if (ticket.getId().equals(id)) {
				return ticket;
			}
		}

		return null;
	}

}
