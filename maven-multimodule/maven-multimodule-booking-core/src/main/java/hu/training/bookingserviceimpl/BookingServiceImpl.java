package hu.training.bookingserviceimpl;

import java.util.Collection;

import hu.training.bookingservice.BookingService;
import hu.training.factory.merchant.Merchant;
import hu.training.factory.merchant.MerchantFactory;
import hu.training.factory.payment.Payment;
import hu.training.factory.payment.PaymentFactory;
import hu.training.ticket.Ticket;
import hu.training.ticket.TicketsMock;
import hu.training.ticket.merchant.MerchantType;
import hu.training.ticket.payment.PaymentType;

public class BookingServiceImpl implements BookingService{

	public Collection<Ticket> getTickets() {
		return TicketsMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		MerchantFactory mf = new MerchantFactory();
		Merchant merchant = mf.getMerchantType(merchantType);
		PaymentFactory pf = new PaymentFactory();
		Payment payment = pf.getPaymentType(paymentType);
		Ticket ticket= null;
		for (Ticket mockTicket : TicketsMock.getTickets()) {
			if (mockTicket.getId().contentEquals(id))
				ticket=mockTicket;
		}
		if (ticket.equals(null)) {
			System.out.println("NEM JOOOO");
		} else {
			merchant.bookTicket(ticket.getId());	//kiírja a merchantot
			payment.pay(ticket.getCost());	//kifizetjük a adott fizetési móddal a jegyet
		}
		
		return ticket;
	}

}
