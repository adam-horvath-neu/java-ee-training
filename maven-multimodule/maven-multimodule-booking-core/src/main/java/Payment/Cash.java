package Payment;

public class Cash extends Payment {

@Override
public void pay(int amount) {
	System.out.println("Amount" + amount);
	
}
}
