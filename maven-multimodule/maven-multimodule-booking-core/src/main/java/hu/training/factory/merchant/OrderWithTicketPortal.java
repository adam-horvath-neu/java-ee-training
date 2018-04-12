package hu.training.factory.merchant;

import hu.training.ticket.Ticket;

public class OrderWithTicketPortal extends Merchant {

	public void printMessage(Ticket ticket) {
		System.out.println("Merchant: TicketPortal, ticket: " + ticket);
	}

}
