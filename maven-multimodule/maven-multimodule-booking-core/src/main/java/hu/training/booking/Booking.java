package hu.training.booking;

import java.util.Collection;

import hu.training.booking.dto.Ticket;
import hu.training.booking.merchant.MerchantFactory;
import hu.training.booking.payment.PaymentStrategyFactory;
import hu.training.booking.ticket.TicketsMock;

public class Booking implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketsMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		MerchantFactory merchantFactory = new MerchantFactory();
		Merchant merchant = merchantFactory.getMerchant(merchantType);
		
		PaymentStrategyFactory paymentStrategyFactory = new PaymentStrategyFactory();
		merchant.setPaymentMode(paymentStrategyFactory.getPayment(paymentType));
		
		Ticket ticket = merchant.bookTicket(id);

		return ticket;
	}

}
