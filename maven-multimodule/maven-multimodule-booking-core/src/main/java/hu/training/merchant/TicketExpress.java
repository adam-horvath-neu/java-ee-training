package hu.training.merchant;

import hu.training.ticket.Ticket;

public class TicketExpress extends Merchant {

	@Override
	protected void printMessage(Ticket ticket) {
	
		System.out.println("Order by TicketExpress, the ticketID: " + ticket.getId());

	}

}
