package Payment;

public class PayPal extends Payment {

	@Override
public	void pay(int amount) {
		System.out.println("Amount" + amount);
		
	}
	
}
