package hu.training.booking.factories;

import hu.training.booking.merchtypes.SzallasHU;
import hu.training.booking.merchtypes.TicketPortal;
import hu.training.booking.merchtypes.Tixa;
import hu.training.booking.stm.MerchPrint;
import hu.training.booking.stm.Merchant;
import hu.training.booking.type.MerchantType;



public class MerchantFactory {

	public	MerchPrint getMerchantTypes(MerchantType merchant)
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
