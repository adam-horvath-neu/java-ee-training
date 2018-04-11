package hu.training.autcenticate.booking.merchtypes;

import hu.training.authenticate.booking.stm.Merchant;

public class SzallasHU extends Merchant {

	@Override
	protected void printMessage() {
		System.out.println("Your payment is successful. Thank you for booking tickets with Szallas.hu and hope to see you again!!!");		
	}
	
}
