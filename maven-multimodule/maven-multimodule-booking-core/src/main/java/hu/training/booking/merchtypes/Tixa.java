package hu.training.booking.merchtypes;

import hu.training.booking.stm.Merchant;
import hu.training.booking.tckt.Ticket;


public class Tixa extends Merchant{

	/* (non-Javadoc)
	 * @see hu.training.authenticate.booking.stm.MerchPrint#printMessage()
	 */
	public void printMessage(Ticket ticket) {
		System.out.println("Your payment is successful. Thank you for booking tickets with Tixa.com and hope to see you again!!!");	
		
	}

	
}
