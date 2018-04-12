package hu.training.bookingcore;

import hu.training.bookingapi.PaymentType;

public class PaymentFactory {

	public PaymentStrategy getPaymentStrategy(PaymentType payment) {
		switch (payment) {
		case CASH:
			return new PayByCash();
		case CREDITCARD:
			return new PayByCreditCard();
		case PAYPAL:
			return new PayByPaypal();
		default:
			throw new IllegalArgumentException();
		}
	}

}
