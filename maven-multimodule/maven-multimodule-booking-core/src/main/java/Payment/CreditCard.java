package Payment;

public class CreditCard extends Payment {

	@Override
 public	void pay(int amount) {
		System.out.println("Amount" + amount);
		
	}
}
