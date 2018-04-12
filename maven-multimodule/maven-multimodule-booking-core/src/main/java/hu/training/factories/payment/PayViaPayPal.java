package hu.training.factories.payment;

public class PayViaPayPal extends Payment {

	@Override
	public void purcashe(int amount) {
		// TODO Auto-generated method stub
		double fee = amount * 0.05;
		double total = fee + amount;
		System.out.println("Type: Paypal, amount: " + amount + " Ft" + " fee: " + fee + " Ft " + " total: " + total + " Ft");
	}

}
