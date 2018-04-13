package hu.training.booking.payment;

public class PayWithCash extends Payment{

	@Override
	public void pay(int amount) {
		System.out.println("Your payment is" + amount + " HUF with Cash.");
		
	}

}
