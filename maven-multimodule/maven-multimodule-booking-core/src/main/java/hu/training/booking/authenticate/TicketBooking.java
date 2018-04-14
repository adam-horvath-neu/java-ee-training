package hu.training.booking.authenticate;

import java.util.Collection;

import hu.training.booking.BookingService;
import hu.training.booking.Ticket;
import hu.training.booking.facstr.MerchantFactory;
import hu.training.booking.facstr.PaymentFactory;
import hu.training.booking.merchants.Merchant;
import hu.training.booking.types.MerchantType;
import hu.training.booking.types.PaymentType;
import hu.trainingő.booking.mock.TicketMock;

public class TicketBooking implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketMock.getTicket();
	}

	public Ticket bookTicket(String id, MerchantType mType, PaymentType pType) {

		Merchant merchant = MerchantFactory.getMerchantTypes(mType);
		merchant.setPaymentMode(PaymentFactory.getPaymentTypes(pType));
		
		Ticket tick = merchant.bookTicket(id);
		
		return tick;

	}

}
