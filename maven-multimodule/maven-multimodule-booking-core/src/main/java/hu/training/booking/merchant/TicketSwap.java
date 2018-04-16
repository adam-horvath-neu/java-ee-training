package hu.training.booking.merchant;

import hu.training.booking.Merchant;

public class TicketSwap extends Merchant {

	@Override
	protected void printMessage() {
		System.out.println("Your payment is successful via Ticket Swap. Thank you for your purchase!");
	}

}
