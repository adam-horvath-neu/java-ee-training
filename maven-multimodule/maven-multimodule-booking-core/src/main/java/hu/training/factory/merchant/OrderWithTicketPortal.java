package hu.training.factory.merchant;

public class OrderWithTicketPortal extends Merchant {

	public void bookTicket(String ticketId) {
		System.out.println("Merchant: TicketPortal, ticketID: " + ticketId);
	}

}
