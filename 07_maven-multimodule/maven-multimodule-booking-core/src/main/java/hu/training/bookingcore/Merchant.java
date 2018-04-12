package hu.training.bookingcore;

import hu.training.bookingapi.Ticket;
import hu.training.bookingcore.ticket.TicketMock;

public abstract class Merchant {
	private PaymentStrategy paymentMode;

	// By default make payment mode by cash 
	public Merchant() {
		paymentMode = new PayByCash();
	}
	
	// Allow to set behavior dynamically
	public void setPaymentMode(PaymentStrategy paymentMode) {
		this.paymentMode = paymentMode;
	}

	// Delegate to the behavior class
	public void bookTicket(String ticketId) {
		Ticket ticket = TicketMock.getTicketByID(ticketId);
		paymentMode.pay(ticket.getCost());
		printMessage();
	}

	// Each merchant can display different message
	protected abstract void printMessage();

}
