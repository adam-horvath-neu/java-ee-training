package hu.training.bookingservice;

import java.util.Collection;

import hu.training.merchant.Merchant;
import hu.training.merchant.MerchantFactory;
import hu.training.payment.PaymentFactory;
import hu.training.payment.PaymentStrategy;
import hu.training.ticket.Ticket;
import hu.training.ticketmock.TicketMock;

public class BaseBookingService implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {

		Merchant merchant = MerchantFactory.getMerchantType(merchantType);
		merchant.setPaymentMode(PaymentFactory.getPaymentType(paymentType));

		Ticket bookedTicket= merchant.bookedTicket(id);
		return bookedTicket;
	}

}
