package Merchant;

import hu.training.ticket.Ticket;

public class Tixa extends Merchant {

	@Override
 public	Ticket bookTicket(String ticketId) {
		System.out.println("TicketId" + ticketId);
		return null;
		
	}
}
