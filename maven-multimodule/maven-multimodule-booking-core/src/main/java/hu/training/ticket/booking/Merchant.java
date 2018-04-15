package hu.training.ticket.booking;

import java.util.Collection;

import hu.training.ticket.PaymentStrategy;
import hu.training.ticket.Ticket;
import hu.training.ticket.paymentclasses.PayByCash;

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
	public Ticket bookTicket(String ticketID) {
		int amount = 0;
		Ticket returnedTicket = null;
		Collection<Ticket> tickets = TicketMock.getTickets();
		for(Ticket t : tickets) {
			if(t.getId().equals(ticketID)) {
				returnedTicket = t;
				amount = t.getCost();
		}
		}
		paymentMode.pay(amount);
		printMessage();
		System.out.println("---");
		System.out.println(returnedTicket.toString());
		return returnedTicket;
	}


	// Each merchant can display different message
	protected abstract void printMessage();
}
