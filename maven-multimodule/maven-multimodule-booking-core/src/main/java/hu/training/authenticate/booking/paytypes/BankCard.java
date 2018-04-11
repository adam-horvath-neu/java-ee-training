package hu.training.authenticate.booking.paytypes;

import hu.training.authenticate.booking.pstr.PaymentStrategy;

public class BankCard implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Amount paid by bankcard = " + amount);
		
	}

}
