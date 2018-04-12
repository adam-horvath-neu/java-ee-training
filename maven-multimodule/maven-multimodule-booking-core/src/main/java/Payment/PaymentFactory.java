package Payment;

import hu.training.ticket.PaymentEnum.PymentType;

public class PaymentFactory {
      
 public	Payment getPayment (PymentType type) {
		
		switch(type) {
		
		case CASH:
			return new Cash();

		case PAYPAL:
			return new PayPal();
		
		case CREDITCARD:
			return new CreditCard();
		
		default:
			throw new IllegalArgumentException();
		}
		
		
	}
}
