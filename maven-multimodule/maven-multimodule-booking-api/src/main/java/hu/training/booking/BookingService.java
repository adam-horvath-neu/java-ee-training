package hu.training.booking;

import java.util.Collection;

import hu.training.merchant.MerchantType;
import hu.training.payment.PaymentType;
import hu.training.ticketbuilder.Ticket;

public interface BookingService {
	
	Collection<Ticket> getTickets();
	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);

}