package hu.training.booking.facstr;

import hu.training.booking.paymenttypes.BankCard;
import hu.training.booking.paymenttypes.Cash;
import hu.training.booking.paymenttypes.PayPal;
import hu.training.booking.types.PaymentType;

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
