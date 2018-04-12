package hu.training.factories.merchant;

import hu.training.merchant.MerchantType;

public class MerchantFactory {

	public Merchant merchantType(MerchantType merchantType) {
		switch (merchantType) {
		case CAMPUSJEGY:
			return new OrderViaCampusJegy();
		case TICKETPORTAL:
			return new OrderViaTicketPortal();
		case BOOKINGDOTCOM:
			return new OrderViaBookingDotCom();
		default:
			throw new IllegalArgumentException();
		}
	}

}
