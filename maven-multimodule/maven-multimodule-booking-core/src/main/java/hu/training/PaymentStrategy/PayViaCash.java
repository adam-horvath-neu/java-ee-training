package hu.training.PaymentStrategy;

public class PayViaCash extends PaymentStrategy {

	@Override
	public void pay(int amount) {

		System.out.println("Ticket paid by CASH: " + amount + " Ft");

	}

}
