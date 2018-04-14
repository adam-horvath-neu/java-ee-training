package hu.training.service;

import java.util.Collection;

import hu.training.merchant.MerchantType;
import hu.training.payment.PaymentType;
import hu.training.ticket.Ticket;

public interface BookingService {
	Collection<Ticket> getTickets();
	Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType);
}
