package hu.training.PaymentStrategy;

import hu.training.bookingservice.PaymentType;

public class PaymentFactory {
	
	public static PaymentStrategy getPaymentType(PaymentType paymentType) {
		
		switch(paymentType) {
		case CASH:
			return new PayViaCash();
		case CREDITCARD:
			return new PayViaCreditCard();
		case PAYPAL:
			return new PayViaPayPal();
		default:
			throw new IllegalArgumentException();
		}
		
	}

}
