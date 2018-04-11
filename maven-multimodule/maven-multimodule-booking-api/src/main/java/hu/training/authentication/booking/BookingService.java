package hu.training.authentication.booking;
import java.util.Collection;

import hu.training.authenticate.booking.type.MerchantType;
import hu.training.authenticate.booking.type.PaymentType;
import hu.training.authenticator.booking.tckt.Ticket;

public interface BookingService {

	Collection<Ticket> getTickets();
	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);
	
	
}
