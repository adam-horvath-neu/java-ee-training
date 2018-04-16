package hu.training.booking.merchant;

import hu.training.booking.Merchant;

public class EladoJegyek extends Merchant {

	@Override
	protected void printMessage() {
		System.out.println("Your payment is successful via Eladó Jegyek. Thank you for your purchase!");
	}

}
