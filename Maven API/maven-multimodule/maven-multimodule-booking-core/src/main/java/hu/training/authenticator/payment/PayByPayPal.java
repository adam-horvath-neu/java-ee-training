package hu.training.authenticator.payment;

public class PayByPayPal implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Amount paid by PayPal = " + amount);
	}

}
