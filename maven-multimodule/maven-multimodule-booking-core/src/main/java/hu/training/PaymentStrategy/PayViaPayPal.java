package hu.training.PaymentStrategy;

public class PayViaPayPal extends PaymentStrategy {

	@Override
	public void pay(int amount) {

		double fee = 0.03;
		double total = amount + (amount * fee);

		System.out.println("Ticket paid by CREDITCARD: " + amount + " Ft +" + fee * 100 + "% extra fee," + "total: " + total + " Ft");

	}

}
