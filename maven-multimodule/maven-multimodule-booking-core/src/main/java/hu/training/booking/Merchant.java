package hu.training.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import hu.training.booking.dto.Ticket;
import hu.training.booking.payment.PayByCash;
import hu.training.booking.ticket.TicketsMock;

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

	public Ticket bookTicket(String ticketId) {		
		
		Collection<Ticket> tickets = new ArrayList<Ticket>();
		tickets = TicketsMock.getTickets();
		List<Ticket> ticket = tickets.stream().filter(x -> x.getId().equals(ticketId)).collect(Collectors.toList());
		if (ticket.isEmpty()) {
			System.out.println("Error: ticket not found");
		} else {
			System.out.println("---------");
			printMessage();
			paymentMode.pay(ticket.get(0).getCost());
		}
		
		return ticket.get(0);
	}

	// Each merchant can display different message
	protected abstract void printMessage();
}
