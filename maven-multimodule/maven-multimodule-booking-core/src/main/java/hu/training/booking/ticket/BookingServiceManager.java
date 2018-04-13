package hu.training.booking.ticket;

import java.util.Collection;

import hu.training.booking.BookingService;
import hu.training.booking.merchant.Merchant;
import hu.training.booking.merchant.MerchantFactory;
import hu.training.booking.payment.Payment;
import hu.training.booking.payment.PaymentFactory;
import hu.training.ticketing.Ticket;
import hu.training.types.MerchantType;
import hu.training.types.PaymentType;

public class BookingServiceManager implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketsMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		Merchant merchant = MerchantFactory.getMerchant(merchantType);
		Payment payment = PaymentFactory.getPayment(paymentType);
		Ticket ticket = merchant.bookTicket(id);
		merchant.setPayment(payment);
		merchant.getPayment().pay(ticket.getCost());
		merchant.printMessage(ticket);
		return ticket;
	}

}
