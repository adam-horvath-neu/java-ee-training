package hu.training.booking.merchant;

import hu.training.ticketing.Ticket;

public class ViaTixa extends Merchant{

	@Override
	public void printMessage(Ticket ticket) {
		System.out.println("Your ticket is " + ticket + ", supported by Tixa.");
		
	}

	

}
