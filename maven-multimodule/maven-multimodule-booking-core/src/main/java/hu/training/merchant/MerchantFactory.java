package hu.training.merchant;

import hu.training.bookingservice.MerchantType;

public class MerchantFactory {

	public static Merchant getMerchantType(MerchantType merchantType) {
		
		switch(merchantType) {
		case TICKETEXPRESS:
			return new TicketExpress();
		case TICKETPORTAL:
			return new TicketPortal();
		case TICKETPRO:
			return new TicketPro();
		default:
			throw new IllegalArgumentException();
		}
	}

}
