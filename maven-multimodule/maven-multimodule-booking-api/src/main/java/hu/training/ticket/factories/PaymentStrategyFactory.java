package hu.training.ticket.factories;

import hu.training.ticket.PaymentStrategy;
import hu.training.ticket.PaymentType;
import hu.training.ticket.paymentclasses.PayByCard;
import hu.training.ticket.paymentclasses.PayByCash;
import hu.training.ticket.paymentclasses.PayByCrypto;
import hu.training.ticket.paymentclasses.PayByPayPal;

public class PaymentStrategyFactory {

	public PaymentStrategy getPaymentStrategy(PaymentType type) {

		switch (type) {
		case CARD:
			PaymentStrategy ca = new PayByCard();
			return ca;

		case CASH:
			PaymentStrategy c = new PayByCash();
			return c;

		case CRYPTO_CURRENCY:
			PaymentStrategy cc = new PayByCrypto();
			return cc;

		case PAYPAL:
			PaymentStrategy pp = new PayByPayPal();
			return pp;

		default:
			throw new IllegalStateException();

		}
	}
}
