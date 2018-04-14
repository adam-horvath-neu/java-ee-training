package merchant;

import hu.training.ticket.Ticket;

public class OrderByCampusJegy extends Merchant {

	@Override
	protected void printMessage(Ticket ticket) {

		System.out.println("Ordered by CAMPUSJEGY, the ticketID: " + ticket.getId());
		
	}

}
