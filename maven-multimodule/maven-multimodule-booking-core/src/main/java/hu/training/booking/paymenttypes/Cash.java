package hu.training.booking.paymenttypes;

import hu.training.booking.facstr.PaymentStrategy;

public class Cash implements PaymentStrategy{

	public void pay(int amount) {
		System.out.println("Amount paid by cash = " + amount);
		
	}

}
