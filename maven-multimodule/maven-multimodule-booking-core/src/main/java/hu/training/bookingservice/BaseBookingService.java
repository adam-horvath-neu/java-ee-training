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

		MerchantFactory merchantFactory = new MerchantFactory();
		Merchant merchant = merchantFactory.getMerchantType(merchantType);

		PaymentFactory paymentFactory = new PaymentFactory();
		PaymentStrategy paymentStrategy = paymentFactory.getPaymentType(paymentType);

		Ticket ticket = null;

		for (Ticket mock : TicketMock.getTickets()) {
			if (mock.getId().contentEquals(id)) {
				ticket = mock;
			}
		}
		if (ticket.equals(null)) {
			System.out.println("Not valid ticket");
		} else {
			merchant.bookTicket(ticket.getId());
			paymentStrategy.pay(ticket.getCost());
		}
		return ticket;
	}

}
