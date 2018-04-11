package hu.training.payment;

import hu.training.bookingservice.PaymentType;

public class PaymentFactory {
	
	public PaymentStrategy getPaymentType(PaymentType paymentType) {
		
		switch(paymentType) {
		case CASH:
			return new PayByCash();
		case CREDITCARD:
			return new PayByCreditCard();
		case PAYPAL:
			return new PayByPayPal();
		default:
			throw new IllegalArgumentException();
		}
	}

}
