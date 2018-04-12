package hu.training.bookticket;

import java.util.Collection;

import hu.training.booking.BookingService;
import hu.training.factories.merchant.Merchant;
import hu.training.factories.merchant.MerchantFactory;
import hu.training.factories.payment.Payment;
import hu.training.factories.payment.PaymentFactory;
import hu.training.merchant.MerchantType;
import hu.training.payment.PaymentType;
import hu.training.ticket.ticketmock.TicketMock;
import hu.training.ticketbuilder.Ticket;

public class BookingServiceImpl implements BookingService {

	public Collection<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return TicketMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		// TODO Auto-generated method stub
		PaymentFactory paymentFactory = new PaymentFactory();
		Payment payment = paymentFactory.paymentType(paymentType);
		MerchantFactory merchantFactory = new MerchantFactory();
		Merchant merchant = merchantFactory.merchantType(merchantType);
		Ticket ticket = null;
		for (Ticket mockT : TicketMock.getTickets()) {
			if (mockT.getId().equals(id)) {
				ticket = mockT;
			}
		}
		if (ticket.equals(null)) {
			System.out.println("Nincs ilyen jegy!");
		} else {
			merchant.bookTicket(ticket.getId());
			payment.purcashe(ticket.getCost());
		}

		return ticket;
	}

}
