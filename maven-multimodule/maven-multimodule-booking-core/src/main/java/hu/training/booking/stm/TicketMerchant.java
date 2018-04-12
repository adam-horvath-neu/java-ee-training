package hu.training.booking.stm;

import hu.training.booking.pstr.PaymentStrategy;
import hu.training.booking.tckt.Ticket;

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


	@Override
	public void printMessage(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}


	
	

}
