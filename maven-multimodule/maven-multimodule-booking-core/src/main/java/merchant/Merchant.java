package merchant;

import hu.training.PaymentStrategy.PayViaCash;
import hu.training.PaymentStrategy.PaymentStrategy;
import hu.training.ticket.Ticket;
import hu.training.ticketmock.TicketMock;

public abstract class Merchant {
	
	private PaymentStrategy paymentMode;

	//default
	public Merchant() {
		paymentMode = new PayViaCash();
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
