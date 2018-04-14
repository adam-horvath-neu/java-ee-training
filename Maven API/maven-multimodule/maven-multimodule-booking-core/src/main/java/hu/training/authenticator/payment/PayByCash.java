package hu.training.authenticator.payment;

public class PayByCash implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Amount paid by cash =  " + amount);		
	}

}
