package hu.training.booking.merchant;

import hu.training.booking.Merchant;

public class Tickething extends Merchant {

	@Override
	protected void printMessage() {
		System.out.println("Your payment is successful via Tickething. Thank for your purchase!");
	}

}
