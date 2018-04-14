package hu.training.PaymentStrategy;

public class PayViaCreditCard extends PaymentStrategy {

	@Override
	public void pay(int amount) {
		
		int extra = 200;
		int total = amount +extra;
		
		System.out.println("Ticket paid by CREDITCARD: " + amount + " HUF +" + extra + " transaction fee," + "total: " + total + " Ft");

	}

}
