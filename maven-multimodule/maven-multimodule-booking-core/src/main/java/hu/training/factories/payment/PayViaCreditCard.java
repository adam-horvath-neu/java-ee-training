package hu.training.factories.payment;

public class PayViaCreditCard extends Payment {

	@Override
	public void purcashe(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Type: Credit Card, amount: " + amount + " Ft");
	}

}
