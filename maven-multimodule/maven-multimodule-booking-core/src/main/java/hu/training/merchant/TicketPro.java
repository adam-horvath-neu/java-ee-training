package hu.training.merchant;

public class TicketPro extends Merchant {

	@Override
	public void bookTicket(String tickedId) {
		
		System.out.println("Order by TicketPro, the ticketID: " + tickedId);

	}

}
