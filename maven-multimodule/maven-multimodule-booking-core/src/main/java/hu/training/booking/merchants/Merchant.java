package hu.training.booking.merchants;

import hu.training.booking.Ticket;
import hu.training.booking.facstr.PaymentStrategy;
import hu.training.booking.paymenttypes.Cash;
import hu.trainingő.booking.mock.TicketMock;

public abstract class Merchant {

	private PaymentStrategy paymentMode;

	public Merchant() {
		paymentMode = new Cash();
	}

	public void setPaymentMode(PaymentStrategy paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public Ticket bookTicket(String id) {
	
		String eventName = null;
		int amount = 0;
		
		for (Ticket obj : TicketMock.getTicket()) {

			if (obj.getId().equals(id)) {
				
				eventName = obj.getEventName();
				
				amount = obj.getCost();

			}
		}
		paymentMode.pay(amount);
		
		
		System.out.println("---");
		
		System.out.print("Your Ticket: ");
		
		return new Ticket(id, eventName, amount);

	}




}
