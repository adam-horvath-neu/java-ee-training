package hu.training.booking.merchant;

import hu.training.booking.Merchant;

public class Jegymester extends Merchant {

	@Override
	protected void printMessage() {
		System.out.println("Your payment is successful via Jegymester. Thank you for your purchase!");
	}

}
