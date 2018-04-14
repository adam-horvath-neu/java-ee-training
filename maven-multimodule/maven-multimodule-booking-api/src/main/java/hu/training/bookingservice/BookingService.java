package hu.training.bookingservice;

import java.util.Collection;

import hu.training.ticket.Ticket;

public interface BookingService {
	
	Collection<Ticket> getTickets();
	
	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);

}
