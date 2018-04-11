package hu.training.ticket;

import java.util.Collection;

public interface BookingService {

	Collection<Ticket> getTickets();
	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);
	
}
