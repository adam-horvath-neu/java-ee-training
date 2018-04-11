package hu.training.authenticate.booking.stm;

import hu.training.authenticate.booking.paytypes.Cash;
import hu.training.authenticate.booking.pstr.PaymentStrategy;


public abstract class Merchant {
	
	private PaymentStrategy paymentMode;
	
	public Merchant() {
		paymentMode = new Cash();
	}
	
	// Allow to set behavior dynamically
	public void setPaymentMode(PaymentStrategy paymentMode) {
		this.paymentMode = paymentMode;
	}

	// Delegate to the behavior class
	public void pay(int amount) {
		paymentMode.pay(amount);
		printMessage();
		System.out.println("---");
	}

	// Each merchant can display different message
	protected abstract void printMessage();

}
