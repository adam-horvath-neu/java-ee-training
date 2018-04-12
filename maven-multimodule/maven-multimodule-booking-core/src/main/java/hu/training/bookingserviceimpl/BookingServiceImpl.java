package hu.training.bookingserviceimpl;

import java.util.Collection;

import hu.training.bookingservice.BookingService;
import hu.training.factory.merchant.Merchant;
import hu.training.factory.merchant.MerchantFactory;
import hu.training.factory.payment.Payment;
import hu.training.factory.payment.PaymentFactory;
import hu.training.ticket.Ticket;
import hu.training.ticket.merchant.MerchantType;
import hu.training.ticket.payment.PaymentType;
import hu.training.ticketsmock.TicketsMock;

public class BookingServiceImpl implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketsMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		Merchant merchant = MerchantFactory.getMerchantType(merchantType);
		Payment payment = PaymentFactory.getPaymentType(paymentType);
		Ticket ticket = merchant.bookTicket(id);
		merchant.setPayment(payment);
		merchant.getPayment().pay(ticket.getCost());
		merchant.printMessage(ticket);
		return ticket;
	}

}
