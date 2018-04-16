package hu.training.booking.merchant;

import hu.training.booking.Merchant;
import hu.training.booking.MerchantType;

public class MerchantFactory {
	public Merchant getMerchant(MerchantType merchant) {
		switch (merchant) {
		case ELADO_JEGYEK:
			return new EladoJegyek();
		case JEGYMESTER:
			return new Jegymester();
		case TICKETHING:
			return new Tickething();
		case TICKET_SWAP:
			return new TicketSwap();
		default:
			throw new IllegalArgumentException();
		}
	}
}
