package merchant;

import hu.training.ticket.Ticket;

public class OrderByTicketPortal extends Merchant {

	@Override
	protected void printMessage(Ticket ticket) {
		
		System.out.println("Ordered by TICKETPORTAL, the ticketID: " + ticket.getId());
		
	}

}
