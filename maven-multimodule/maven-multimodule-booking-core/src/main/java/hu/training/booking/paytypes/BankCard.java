package hu.training.booking.paytypes;

import hu.training.booking.pstr.PaymentStrategy;

public class BankCard implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Amount paid by bankcard = " + amount);
		
	}

}
