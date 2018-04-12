package hu.training.bookingservice;

import java.util.Collection;

import hu.training.ticket.Ticket;
import hu.training.ticket.merchant.MerchantType;
import hu.training.ticket.payment.PaymentType;

public interface BookingService {

	Collection<Ticket> getTickets();

	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);

}
