package hu.training.booking.merchants;

import hu.training.booking.Ticket;
import hu.training.booking.facstr.PaymentStrategy;

public class TicketMerchant extends Merchant {
	

	@Override
	public void setPaymentMode(PaymentStrategy paymentMode) {
		super.setPaymentMode(paymentMode);
	}


	public Ticket bookTicket(String ticketId) {
		return super.bookTicket(ticketId);
	}
}
