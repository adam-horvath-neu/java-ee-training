package hu.training.booking;

import java.util.Collection;

import hu.training.ticket.BookingService;
import hu.training.ticket.Merchant;
import hu.training.ticket.MerchantType;
import hu.training.ticket.PaymentType;
import hu.training.ticket.Ticket;
import hu.training.ticket.factories.*;

public class Booking implements BookingService {

	public static void main(String[] args) {

	}

	public Collection<Ticket> getTickets() {
		return TicketMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {

		MerchantFactory mf = new MerchantFactory();
		Merchant merchant = mf.getMerchant(merchantType);

		Ticket ticket = merchant.bookTicket(id);

		PaymentStrategyFactory ptf = new PaymentStrategyFactory();

		ptf.getPaymentStrategy(paymentType);

		return ticket;
	}

}
