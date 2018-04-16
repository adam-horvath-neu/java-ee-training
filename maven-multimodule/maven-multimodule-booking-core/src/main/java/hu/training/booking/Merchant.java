package hu.training.booking;

import hu.training.booking.payment.PayByCash;

public abstract class Merchant {
	private PaymentStrategy paymentMode;

	// By default make payment mode by cash
	public Merchant() {
		paymentMode = new PayByCash();
	}

	// Allow to set behavior dynamically
	public void setPaymentMode(PaymentStrategy paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void bookTicket(String ticketId) {

	}

	// Each merchant can display different message
	protected abstract void printMessage();
}
