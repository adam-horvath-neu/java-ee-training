package hu.training.factory.merchant;

import hu.training.ticket.merchant.MerchantType;

public class MerchantFactory {

	public static Merchant getMerchantType(MerchantType merchantType) {
		switch (merchantType) {
		case TIXA:
			return new OrderWithTixa();
		case TICKETPORTAL:
			return new OrderWithTicketPortal();
		case JEGYHU:
			return new OrderWithJegyHu();
		default:
			throw new IllegalArgumentException();
		}
	}
}
