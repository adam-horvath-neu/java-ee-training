package hu.training.booking.payment;

import hu.training.types.PaymentType;

public class PaymentFactory {

	public static Payment getPayment(PaymentType paymentType) {
		switch (paymentType) {
		case MASTERCARD:
			return new PayWithMastercard();
		case PAYPAL:
			return new PayWithPaypal();
		case CASH:
			return new PayWithCash();
		default:
			throw new IllegalArgumentException();

		}
	}
}
