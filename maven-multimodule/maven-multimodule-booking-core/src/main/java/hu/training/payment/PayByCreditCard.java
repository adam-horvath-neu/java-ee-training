package hu.training.payment;

public class PayByCreditCard extends PaymentStrategy {

	@Override
	public void pay(int amount) {
		System.out.println("Amount paid by CreditCard = " + amount);

	}

}
