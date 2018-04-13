package hu.training.booking.merchant;

import java.util.Collection;

import hu.training.booking.payment.Payment;
import hu.training.booking.ticket.BookingServiceManager;
import hu.training.booking.ticket.TicketsMock;
import hu.training.ticketing.Ticket;

public abstract class Merchant {

	Payment payment;

	public Merchant() {
	}

	public Merchant(Payment payment) {
		super();
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Ticket bookTicket(String ticketId) {
		Collection<Ticket> tickets = new BookingServiceManager().getTickets();
		for (Ticket ticket : tickets) {
			if (ticket.getId().equals(ticketId)) {
				return ticket;
			}
		}
		return null;
	}

	public abstract void printMessage(Ticket ticket);
}
