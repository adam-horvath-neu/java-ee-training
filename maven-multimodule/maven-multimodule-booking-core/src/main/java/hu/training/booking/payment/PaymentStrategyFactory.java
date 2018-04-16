package hu.training.booking.payment;

import hu.training.booking.PaymentStrategy;
import hu.training.booking.PaymentType;

public class PaymentStrategyFactory {
	public PaymentStrategy getPayment(PaymentType payment) {
		switch (payment) {
		case CASH:
			return new PayByCash();
		case CREDIT_CARD:
			return new PayByCreditCard();
		case PAYPAL:
			return new PayByPayPal();
		default:
			throw new IllegalArgumentException();
		}
	}
}
