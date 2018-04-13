package Payment;

public class PayPal implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Amount paid by paypal gateway = " + amount);
	}
		
	}
	

