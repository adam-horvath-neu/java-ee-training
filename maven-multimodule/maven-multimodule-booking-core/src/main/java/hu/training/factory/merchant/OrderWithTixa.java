package hu.training.factory.merchant;

public class OrderWithTixa extends Merchant {

	public void bookTicket(String ticketId) {
		System.out.println("Merchant: Tixa, ticketID: " + ticketId);
	}

}
