package hu.training.merchant;

import hu.training.ticket.Ticket;

public class TicketPortal extends Merchant {

	@Override
	protected void printMessage(Ticket ticket) {
		
		System.out.println("Order by TicketPortal, the ticketID: " + ticket.getId());
		
	}

	
}
