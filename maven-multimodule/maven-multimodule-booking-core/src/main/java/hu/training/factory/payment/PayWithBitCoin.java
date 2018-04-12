package hu.training.factory.payment;

public class PayWithBitCoin extends Payment {

	@Override
	public void pay(int amount) {
		System.out.println("PaymentType: BITCOIN, amount: " + amount + " HUF");

	}

}
