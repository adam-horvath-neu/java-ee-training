package hu.training.authenticate.booking.factories;

import hu.training.authenticate.booking.paytypes.BankCard;
import hu.training.authenticate.booking.paytypes.Cash;
import hu.training.authenticate.booking.paytypes.PayPal;
import hu.training.authenticate.booking.pstr.PaymentStrategy;
import hu.training.authenticate.booking.type.PaymentType;

public class PaymentFactory {

	public PaymentStrategy getPaymentTypes(PaymentType payment)
	{
		switch (payment) {
		case BANKCARD:
			return new BankCard();
		case CASH:
			return new Cash();
		case PAYPAL:
			return new PayPal();
		default:
			throw new IllegalArgumentException();
		}
	}
	
}
