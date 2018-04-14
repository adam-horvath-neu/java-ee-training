package merchant;

import hu.training.ticket.Ticket;

public class OrderByTixa extends Merchant {

	@Override
	protected void printMessage(Ticket ticket) {
		
		System.out.println("Ordered by TIXA, the ticketID: " + ticket.getId());
		
	}

}
