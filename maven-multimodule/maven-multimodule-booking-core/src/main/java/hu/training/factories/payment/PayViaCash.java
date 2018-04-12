package hu.training.factories.payment;

public class PayViaCash extends Payment {

	@Override
	public void purcashe(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Type: Cash, amount: " + amount + " Ft");
	}

}
