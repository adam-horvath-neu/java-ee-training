package hu.training.factory.merchant;

import hu.training.ticket.Ticket;

public class OrderWithTixa extends Merchant {

	public void printMessage(Ticket ticket) {
		System.out.println("Merchant: Tixa, ticket: " + ticket);
	}

}
