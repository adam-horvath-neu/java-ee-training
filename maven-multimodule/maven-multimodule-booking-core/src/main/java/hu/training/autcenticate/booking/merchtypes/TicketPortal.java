package hu.training.autcenticate.booking.merchtypes;

import hu.training.authenticate.booking.stm.MerchPrint;
import hu.training.authenticate.booking.stm.Merchant;

public class TicketPortal implements MerchPrint{

	/* (non-Javadoc)
	 * @see hu.training.authenticate.booking.stm.MerchPrint#printMessage()
	 */
	public void printMessage() {
		System.out.println("Your payment is successful. Thank you for booking tickets with Ticketportal.com and hope to see you again!!!");		
		
	}

	
}
