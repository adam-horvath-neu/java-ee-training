package hu.training.ticket.paymentclasses;

import hu.training.ticket.PaymentStrategy;

public class PayByPayPal implements PaymentStrategy {

	public void pay(int amount) {
		
		System.out.println("Amount paid using PayPal = " + amount);
	}

}
