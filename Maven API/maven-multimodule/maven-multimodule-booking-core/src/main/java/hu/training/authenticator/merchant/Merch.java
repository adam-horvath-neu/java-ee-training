package hu.training.authenticator.merchant;

import hu.training.authenticator.payment.PaymentStrategy;
import hu.training.ticket.Ticket;

public class Merch extends Merchant {
	@Override
	public void setPaymentStrategy(PaymentStrategy paymentMode) {
		super.setPaymentStrategy(paymentMode);
	}

	@Override
	public Ticket bookTicket(String ticketId) {
		// TODO Auto-generated method stub
		return super.bookTicket(ticketId);
	}
	

	@Override
	public void printMessage() {
		
	}

}
