package hu.training.booking;
import java.util.Collection;

import hu.training.booking.types.MerchantType;
import hu.training.booking.types.PaymentType;

public interface BookingService {

	Collection<Ticket> getTickets();
	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);
	
	
}
