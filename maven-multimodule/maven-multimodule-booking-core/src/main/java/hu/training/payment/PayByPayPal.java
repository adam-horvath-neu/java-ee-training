package hu.training.payment;

public class PayByPayPal extends PaymentStrategy {

	@Override
	public void pay(int amount) {
		System.out.println("Amount paid by PayPal = " + amount);

	}

}
