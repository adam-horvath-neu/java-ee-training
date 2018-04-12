package hu.training.booking.service;
import java.util.Collection;

import hu.training.booking.tckt.Ticket;
import hu.training.booking.type.MerchantType;
import hu.training.booking.type.PaymentType;

public interface BookingService {

	Collection<Ticket> getTickets();
	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);
	
	
}
