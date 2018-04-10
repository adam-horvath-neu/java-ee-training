package hu.training.booking.merchant;

public class ViaTicketPortal extends Merchant{

	@Override
	void bookTicket(String ticketId) {
		System.out.println("Your ticketID's number is " + ticketId + ", supported by TicketPortal.");
		
	}

}
