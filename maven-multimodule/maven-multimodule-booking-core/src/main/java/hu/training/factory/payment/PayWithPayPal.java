package hu.training.factory.payment;

public class PayWithPayPal extends Payment {

	@Override
	public void pay(int amount) {
		System.out.println("PaymentType: PayPal, amount: " + amount + " HUF");

	}

}
