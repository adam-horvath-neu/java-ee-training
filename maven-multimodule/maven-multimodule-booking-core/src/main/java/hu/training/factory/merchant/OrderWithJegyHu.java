package hu.training.factory.merchant;

public class OrderWithJegyHu extends Merchant {

	public void bookTicket(String ticketId) {
		System.out.println("Merchant: Jegy.hu, ticketID: " + ticketId);

	}

}
