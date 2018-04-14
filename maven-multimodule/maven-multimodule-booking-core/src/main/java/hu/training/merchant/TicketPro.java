package hu.training.merchant;

import hu.training.ticket.Ticket;

public class TicketPro extends Merchant {

	@Override
	protected void printMessage(Ticket ticket) {
		System.out.println("Order by TicketPro, the ticketID: " + ticket.getId());
	}

}
