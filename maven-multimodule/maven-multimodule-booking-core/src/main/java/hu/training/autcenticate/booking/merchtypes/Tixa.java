package hu.training.autcenticate.booking.merchtypes;

import hu.training.authenticate.booking.stm.MerchPrint;


public class Tixa implements MerchPrint{

	/* (non-Javadoc)
	 * @see hu.training.authenticate.booking.stm.MerchPrint#printMessage()
	 */
	public void printMessage() {
		System.out.println("Your payment is successful. Thank you for booking tickets with Tixa.com and hope to see you again!!!");	
		
	}

	
}
