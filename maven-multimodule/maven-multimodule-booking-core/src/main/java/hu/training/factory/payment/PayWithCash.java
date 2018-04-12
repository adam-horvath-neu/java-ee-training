package hu.training.factory.payment;

public class PayWithCash extends Payment {

	@Override
	public void pay(int amount) {
		System.out.println("PaymentType: CASH, amount: " + amount + " HUF");
	}

}
