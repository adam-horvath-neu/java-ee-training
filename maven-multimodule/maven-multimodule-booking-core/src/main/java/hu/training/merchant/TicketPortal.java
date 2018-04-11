package hu.training.merchant;

public class TicketPortal extends Merchant {

	@Override
	public void bookTicket(String tickedId) {
		System.out.println("Order by TicketPortal, the ticketID: " + tickedId);

	}

}
