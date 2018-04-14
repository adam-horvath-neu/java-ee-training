package hu.training.authenticator.ticket;

import java.util.Collection;

import hu.training.authenticator.merchant.Merch;
import hu.training.authenticator.merchant.Merchant;
import hu.training.authenticator.merchant.MerchantFactory;
import hu.training.authenticator.payment.PaymentFactory;
import hu.training.authenticator.payment.PaymentStrategy;
import hu.training.merchant.MerchantType;
import hu.training.payment.PaymentType;
import hu.training.service.BookingService;
import hu.training.ticket.Ticket;

public class TicketsBooking implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketsMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		Ticket ticket = null;
		MerchantFactory merchant = new MerchantFactory();
		merchant.getMerchant(merchantType).printMessage();
		PaymentFactory payment = new PaymentFactory();
		Merch m = new Merch();
		m.setPaymentStrategy(payment.getPaymentStrategy(paymentType));
		return m.bookTicket(id);
	}

}
