package hu.training.factory.payment;

import hu.training.ticket.payment.PaymentType;

public class PaymentFactory {
	
	public Payment getPaymentType(PaymentType paymentType) {
		switch (paymentType) {
		case CASH:
			return new PayWithCash();
		case BITCOIN:
			return new PayWithBitCoin();
		case PAYPAL:
			return new PayWithPayPal();
		default:
			throw new IllegalArgumentException();
		}
	}
}


