package hu.training.booking;

import java.util.Collection;

import hu.training.PaymentStrategy.PaymentFactory;
import hu.training.bookingservice.BookingService;
import hu.training.bookingservice.MerchantType;
import hu.training.bookingservice.PaymentType;
import hu.training.ticket.Ticket;
import hu.training.ticketmock.TicketMock;
import merchant.Merchant;
import merchant.MerchantFactory;

public class BookingServiceBase implements BookingService {

	public Collection<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return TicketMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		// TODO Auto-generated method stub
		Merchant merchant = MerchantFactory.getMerchantType(merchantType);
		merchant.setPaymentMode(PaymentFactory.getPaymentType(paymentType));

		Ticket bookedTicket = merchant.bookedTicket(id);
		return bookedTicket;
	}

}
