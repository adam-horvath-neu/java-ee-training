package hu.training.booking;

import java.util.Collection;

import hu.training.bookingapi.BookingService;
import hu.training.bookingapi.MerchantType;
import hu.training.bookingapi.PaymentType;
import hu.training.bookingapi.Ticket;
import hu.training.bookingcore.Merchant;
import hu.training.bookingcore.MerchantFactory;
import hu.training.bookingcore.PaymentFactory;
import hu.training.bookingcore.PaymentStrategy;
import hu.training.bookingcore.ticket.TicketMock;

public class BookingServiceImpl implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		MerchantFactory mfactory = new MerchantFactory();
		PaymentFactory pfactory = new PaymentFactory();
		
		Merchant merchant = mfactory.getMerchant(merchantType);
		PaymentStrategy pstrategy = pfactory.getPaymentStrategy(paymentType);
		
		merchant.setPaymentMode(pstrategy);
		merchant.bookTicket(id);
		
		return TicketMock.getTicketByID(id);
	}

}
