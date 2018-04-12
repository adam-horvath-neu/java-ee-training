package hu.training.bookingcore;

import hu.training.bookingapi.MerchantType;

public class MerchantFactory {

	public Merchant getMerchant(MerchantType merchant) {
		switch (merchant) {
		case TICKETA:
			return new TicketA();
		case TICKETPORTAL:
			return new TicketPortal();
		case TIXA:
			return new Tixa();
		default:
			throw new IllegalArgumentException();
		}
	}

}
