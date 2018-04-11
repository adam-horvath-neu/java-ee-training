package hu.training.authenticate.booking.stm;

import hu.training.authenticate.booking.pstr.PaymentStrategy;
import hu.training.authenticator.booking.tckt.Ticket;

public class TicketMerchant extends Merchant {
	
	

	/* (non-Javadoc)
	 * @see hu.training.authenticate.booking.stm.Merchant#setPaymentMode(hu.training.authenticate.booking.pstr.PaymentStrategy)
	 */
	@Override
	public void setPaymentMode(PaymentStrategy paymentMode) {
		// TODO Auto-generated method stub
		super.setPaymentMode(paymentMode);
	}


	public Ticket bookTicket(String ticketId) {
		// TODO Auto-generated method stub
		return super.bookTicket(ticketId);
	}


	
	

}
