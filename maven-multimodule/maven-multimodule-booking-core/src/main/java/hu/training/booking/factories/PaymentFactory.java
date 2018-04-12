package hu.training.booking.factories;

import hu.training.booking.paytypes.BankCard;
import hu.training.booking.paytypes.Cash;
import hu.training.booking.paytypes.PayPal;
import hu.training.booking.pstr.PaymentStrategy;
import hu.training.booking.type.PaymentType;

public class PaymentFactory {

	public static PaymentStrategy getPaymentTypes(PaymentType payment)
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
