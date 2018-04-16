package hu.training.booking;

import java.util.Collection;

import hu.training.booking.dto.Ticket;

public interface BookingService {
	Collection<Ticket> getTickets();
	
	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);
}
