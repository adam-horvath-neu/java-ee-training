package hu.training.authenticator.payment;

import hu.training.payment.PaymentType;


public class PaymentFactory {
	public PaymentStrategy getPaymentStrategy(PaymentType payment) {
		switch (payment) {
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
