package hu.training.authenticate.booking.factories;

import hu.training.autcenticate.booking.merchtypes.SzallasHU;
import hu.training.autcenticate.booking.merchtypes.TicketPortal;
import hu.training.autcenticate.booking.merchtypes.Tixa;
import hu.training.authenticate.booking.stm.Merchant;
import hu.training.authenticate.booking.type.MerchantType;



public class MerchantFactory {

		Merchant getMerchantTypes(MerchantType merchant)
	{
		switch (merchant) {
		case SZALLASHU:
			return new SzallasHU();
		case TICKETPORTAL:
			return new TicketPortal();
		case TIXA:
			return new Tixa();
		default:
			throw new IllegalArgumentException();
		}
	}
	
}
