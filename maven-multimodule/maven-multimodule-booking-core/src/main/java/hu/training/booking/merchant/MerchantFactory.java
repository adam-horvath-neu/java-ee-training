package hu.training.booking.merchant;

import hu.training.types.MerchantType;

public class MerchantFactory {

	Merchant getMerchant(MerchantType merchantType) {
		switch (merchantType) {
		case OPORT:
			return new ViaOport();
		case TIXA:
			return new ViaTixa();
		case TICKETPORTAL:
			return new ViaTicketPortal();
		default:
			throw new IllegalArgumentException();

		}
	}

}
