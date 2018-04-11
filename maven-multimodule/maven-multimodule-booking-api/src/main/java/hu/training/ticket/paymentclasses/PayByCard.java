package hu.training.ticket.paymentclasses;

import hu.training.ticket.PaymentStrategy;

public class PayByCard implements PaymentStrategy{

	public void pay(int amount) {
		
		System.out.println("Amount paid by card = " + amount);
	}

}
