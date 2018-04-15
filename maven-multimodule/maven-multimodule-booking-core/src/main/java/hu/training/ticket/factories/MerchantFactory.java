package hu.training.ticket.factories;

import hu.training.ticket.MerchantType;
import hu.training.ticket.booking.Merchant;
import hu.training.ticket.merchants.BestBuy;
import hu.training.ticket.merchants.ShopOnline;
import hu.training.ticket.merchants.Vouchers;

public class MerchantFactory {

	public Merchant getMerchant(MerchantType merchant) {

		switch (merchant) {

		case BESTBUY:
			Merchant b = new BestBuy();
			return b;

		case SHOPONLINE:
			Merchant s = new ShopOnline();
			return s;

		case VOUCHERS:
			Merchant v = new Vouchers();
			return v;

		default:
			throw new IllegalStateException();
		}
	}

}
