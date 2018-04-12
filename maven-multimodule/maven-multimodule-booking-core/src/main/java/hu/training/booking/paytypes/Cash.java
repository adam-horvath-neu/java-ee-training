package hu.training.booking.paytypes;

import hu.training.booking.pstr.PaymentStrategy;

public class Cash implements PaymentStrategy{

	public void pay(int amount) {
		System.out.println("Amount paid by cash = " + amount);
		
	}

}
