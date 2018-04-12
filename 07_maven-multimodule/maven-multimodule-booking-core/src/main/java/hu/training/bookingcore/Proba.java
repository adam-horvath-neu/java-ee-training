package hu.training.bookingcore;

import hu.training.bookingapi.MerchantType;
import hu.training.bookingapi.PaymentType;

public class Proba {

	public static void main(String[] args) {
		// Client makes use of an encapsulated family of algorithms for payment
		
		// OO principle - programming to an interface, not an implementation		
		Merchant m = new Tixa();
		m.bookTicket("10"); // By default it pays by cash
		m.setPaymentMode(new PayByPaypal()); // Change payment mode to Paypal
		m.bookTicket("100");
		
		m = new TicketA();
		m.setPaymentMode(new PayByCreditCard());
		m.bookTicket("1000");
		
		MerchantFactory mfactory = new MerchantFactory();
		
		Merchant ticketa = mfactory.getMerchant(MerchantType.TICKETA);
		Merchant ticketportal = mfactory.getMerchant(MerchantType.TICKETPORTAL);
		Merchant tixa = mfactory.getMerchant(MerchantType.TIXA);
		
		ticketa.printMessage();
		ticketportal.printMessage();
		tixa.printMessage();
		
		PaymentFactory pfactory = new PaymentFactory();
		
		PaymentStrategy paybycash = pfactory.getPaymentStrategy(PaymentType.CASH);
		PaymentStrategy paybycc = pfactory.getPaymentStrategy(PaymentType.CREDITCARD);
		PaymentStrategy paybypp = pfactory.getPaymentStrategy(PaymentType.PAYPAL);
		
		paybycash.pay(10);
		paybycc.pay(20);
		paybypp.pay(50);

	}

}
