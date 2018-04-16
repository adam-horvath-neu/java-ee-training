package hu.training.booking.payment;

import hu.training.booking.PaymentStrategy;

public class PayByPayPal implements PaymentStrategy {

	public void pay(int amount) {
		System.out.printf("%d HUF paid by PayPal", amount);
	}

}
