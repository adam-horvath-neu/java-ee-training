package hu.training.factory.merchant;

import hu.training.factory.payment.Payment;
import hu.training.ticket.Ticket;
import hu.training.ticketsmock.TicketsMock;

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
		return TicketsMock.getTickets().stream().filter(f -> f.getId().equals(ticketId)).findFirst().get();
	}

	public abstract void printMessage(Ticket ticket);

}
