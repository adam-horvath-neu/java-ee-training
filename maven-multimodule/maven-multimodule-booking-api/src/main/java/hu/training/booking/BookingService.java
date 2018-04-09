package hu.training.booking;

import java.util.Collection;

import hu.training.ticketing.Ticket;
import hu.training.types.MerchantType;
import hu.training.types.PaymentType;

public interface BookingService {

	Collection<Ticket> getTickets();

	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);
}
