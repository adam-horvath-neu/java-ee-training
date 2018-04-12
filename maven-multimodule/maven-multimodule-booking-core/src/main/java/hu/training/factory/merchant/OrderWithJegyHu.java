package hu.training.factory.merchant;

import hu.training.ticket.Ticket;

public class OrderWithJegyHu extends Merchant {

	public void printMessage(Ticket ticket) {
		System.out.println("Merchant: Jegy.hu, ticket: " + ticket);

	}

}
