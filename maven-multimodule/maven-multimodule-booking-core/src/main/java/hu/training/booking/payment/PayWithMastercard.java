package hu.training.booking.payment;

public class PayWithMastercard extends Payment{

	@Override
	public void pay(int amount) {
		System.out.println("Your payment is" + amount + " HUF with Mastercard.");
		
	}

}
