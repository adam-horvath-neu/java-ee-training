package hu.training.authenticator.payment;

public class PayByCreditCard implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Amount paid by credit card = " + amount);
	}

}
