package hu.training.authenticator.merchant;

import hu.training.authenticator.payment.PayByCash;
import hu.training.authenticator.payment.PaymentStrategy;
import hu.training.authenticator.ticket.TicketsMock;
import hu.training.ticket.Ticket;

public abstract class Merchant implements MerchantMode {
	private PaymentStrategy payment;

	public Merchant() {
		this.payment = new PayByCash();
	}

	public void setPaymentStrategy(PaymentStrategy paymentMode) {
		this.payment = paymentMode;
	}
	

	public Ticket bookTicket(String ticketId) {
		Ticket ticket = null;
		for (Ticket t : new TicketsMock().getTickets()) {
			if (ticketId.equals(t.getId()))
				ticket = t;
		}
		payment.pay(ticket.getCost());
		return ticket;
	}
	
	public abstract void printMessage();
}