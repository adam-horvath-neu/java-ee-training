package hu.training.booking.facstr;

import hu.training.booking.merchants.Merchant;
import hu.training.booking.mtypes.Ibusz;
import hu.training.booking.mtypes.SzallasHU;
import hu.training.booking.mtypes.Trivago;
import hu.training.booking.types.MerchantType;



public class MerchantFactory {

	public	static Merchant getMerchantTypes(MerchantType merchant)
	{
		switch (merchant) {
		case SZALLASHU:
			return new SzallasHU();
		case IBUSZ:
			return new Ibusz();
		case TRIVAGO:
			return new Trivago();
		default:
			return null;
		}
	}
	
}
