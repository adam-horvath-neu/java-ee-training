package Payment;

public class CreditCard implements PaymentStrategy {

	public void pay(int amount) {
		System.out.println("Amount paid by credit card = " + amount);
		
	}
		
	}

