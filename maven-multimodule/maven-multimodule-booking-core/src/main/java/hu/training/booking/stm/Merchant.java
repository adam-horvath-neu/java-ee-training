package hu.training.booking.stm;

import hu.training.booking.mock.TicketMock;
import hu.training.booking.paytypes.Cash;
import hu.training.booking.pstr.PaymentStrategy;
import hu.training.booking.tckt.Ticket;

public abstract class Merchant {

	private PaymentStrategy paymentMode;

	public Merchant() {
		paymentMode = new Cash();
	}

	// Allow to set behavior dynamically
	public void setPaymentMode(PaymentStrategy paymentMode) {
		this.paymentMode = paymentMode;
	}

	// Delegate to the behavior class
	public Ticket bookTicket(String ticketId) {
	
		Ticket ticket = null;
		for (Ticket t : TicketMock.getTicket()) {

			if (t.getId().equals(ticketId)) {
				ticket = t;

			}
		}
		printMessage(ticket);
		paymentMode.pay(ticket.getCost());
		
		System.out.println("---");
		return  ticket;

	}

	public abstract void printMessage(Ticket ticket);
	

}
