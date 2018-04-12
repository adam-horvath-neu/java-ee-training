package hu.training.bookingcore;



public class PayByCash implements PaymentStrategy{

	public void pay(int amount) {
		System.out.println("Amount paid by cash = " + amount);
	}

}
