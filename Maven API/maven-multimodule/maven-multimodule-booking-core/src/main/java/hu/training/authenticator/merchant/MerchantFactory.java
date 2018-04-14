package hu.training.authenticator.merchant;

import hu.training.merchant.MerchantType;


public class MerchantFactory {
	public Merchant getMerchant(MerchantType merchant) {
		switch (merchant) {
		case TIXA:
			return new Tixa();
		case TICKETPORTAL:
			return new TicketPortal();
		case TICKETPRO:
			return new TicketPro();
		default:
			throw new IllegalArgumentException();
		}
	}
}
