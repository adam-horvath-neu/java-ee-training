package hu.training.merchant;

import hu.training.payment.PayByCash;
import hu.training.payment.PaymentStrategy;
import hu.training.ticket.Ticket;
import hu.training.ticketmock.TicketMock;

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
	public Ticket bookedTicket(String ticketId){
	
		Ticket ticket = null;
		for (Ticket mock : TicketMock.getTickets()) {
			if (mock.getId().equals(ticketId)) {	
				ticket = mock;
			}
		}
		
		printMessage(ticket);
		paymentMode.pay(ticket.getCost());
		return ticket;
	}
	
	protected abstract void printMessage(Ticket ticket);

}
