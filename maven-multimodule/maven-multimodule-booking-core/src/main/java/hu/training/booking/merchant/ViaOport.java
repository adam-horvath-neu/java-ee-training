package hu.training.booking.merchant;

import hu.training.ticketing.Ticket;

public class ViaOport extends Merchant {

	@Override
	public void printMessage(Ticket ticket) {
		System.out.println("Your ticket is " + ticket + ", supported by Oport.");

	}

}
