package hu.training.merchant;

public class TicketExpress extends Merchant {

	@Override
	public void bookTicket(String tickedId) {
		System.out.println("Order by TicketExpress, the ticketID: " + tickedId);

	}

}
