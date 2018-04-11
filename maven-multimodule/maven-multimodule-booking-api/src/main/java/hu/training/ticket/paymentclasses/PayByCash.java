package hu.training.ticket.paymentclasses;

import hu.training.ticket.PaymentStrategy;

public class PayByCash implements PaymentStrategy {

		
		public void pay(int amount) {
			
			System.out.println("Amount paid by cash = " + amount);
		}


	}


