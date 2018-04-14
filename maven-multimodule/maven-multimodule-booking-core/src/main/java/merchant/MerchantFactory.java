package merchant;

import hu.training.bookingservice.MerchantType;

public class MerchantFactory {

	public static Merchant getMerchantType(MerchantType merchantType) {

		switch (merchantType) {
		case CAMPUSJEGY:
			return new OrderByCampusJegy();
		case TICKETPORTAL:
			return new OrderByTicketPortal();
		case TIXA:
			return new OrderByTixa();
		default:
			throw new IllegalArgumentException();
		}
	}

}
