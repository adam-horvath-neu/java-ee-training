package hu.training.authenticate.booking.stm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import hu.training.authenticate.booking.auth.TicketAuthenticate;
import hu.training.authenticate.booking.paytypes.Cash;
import hu.training.authenticate.booking.pstr.PaymentStrategy;
import hu.training.authenticator.booking.mock.TicketMock;
import hu.training.authenticator.booking.tckt.Ticket;

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
	
		int amount=10;
		String eventName="eventname";
		for (Ticket t : TicketMock.getTicket()) {

			if (t.getId().equals(ticketId)) {
				eventName = t.getEventName();
				amount = t.getCost();

			}
		}
		paymentMode.pay(amount);
		
		System.out.println("---");
		return new Ticket(ticketId, eventName, amount);

	}




}
