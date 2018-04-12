package hu.training.bookingcore;

public class PayByPaypal implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Amount paid by paypal gateway = " + amount);
	}

}