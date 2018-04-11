package hu.training.authenticate.booking.paytypes;

import hu.training.authenticate.booking.pstr.PaymentStrategy;

public class PayPal implements PaymentStrategy{

	public void pay(int amount) {
		System.out.println("Amount paid by paypal = " + amount);
		
	}

}
