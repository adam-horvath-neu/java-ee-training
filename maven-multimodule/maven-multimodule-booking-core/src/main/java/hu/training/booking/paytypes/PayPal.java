package hu.training.booking.paytypes;

import hu.training.booking.pstr.PaymentStrategy;

public class PayPal implements PaymentStrategy{

	public void pay(int amount) {
		System.out.println("Amount paid by paypal = " + amount);
		
	}

}
