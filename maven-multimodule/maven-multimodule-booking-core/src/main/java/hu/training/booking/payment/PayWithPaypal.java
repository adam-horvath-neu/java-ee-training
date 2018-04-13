package hu.training.booking.payment;

public class PayWithPaypal extends Payment{

	@Override
	public void pay(int amount) {
		System.out.println("Your payment is" + amount + " HUF with Paypal.");
	}

}
