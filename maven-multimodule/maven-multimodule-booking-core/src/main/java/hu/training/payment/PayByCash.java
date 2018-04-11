package hu.training.payment;

public class PayByCash extends PaymentStrategy {

	@Override
	public void pay(int amount) {
		System.out.println("Amount paid by cash = " + amount);

	}

}
