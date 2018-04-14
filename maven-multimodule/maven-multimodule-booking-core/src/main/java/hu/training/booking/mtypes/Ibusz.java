package hu.training.booking.mtypes;

import hu.training.booking.Ticket;
import hu.training.booking.merchants.Merchant;

public class Ibusz extends Merchant{



	@Override
	public void printMessage(Ticket ticket) {
		System.out.println("Your payment is successful. Thank you for choosen us, Ibusz");		
		
	}

	
}
