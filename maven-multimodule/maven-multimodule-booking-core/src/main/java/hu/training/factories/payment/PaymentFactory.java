package hu.training.factories.payment;

import hu.training.payment.PaymentType;

public class PaymentFactory {

	public Payment paymentType(PaymentType paymentType) {
		switch (paymentType) {
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
