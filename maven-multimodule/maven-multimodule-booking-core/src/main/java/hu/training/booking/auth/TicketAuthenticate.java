package hu.training.booking.auth;

import java.util.Collection;

import hu.training.booking.factories.MerchantFactory;
import hu.training.booking.factories.PaymentFactory;
import hu.training.booking.mock.TicketMock;
import hu.training.booking.pstr.PaymentStrategy;
import hu.training.booking.service.BookingService;
import hu.training.booking.stm.MerchPrint;
import hu.training.booking.stm.Merchant;
import hu.training.booking.stm.TicketMerchant;
import hu.training.booking.tckt.Ticket;
import hu.training.booking.type.MerchantType;
import hu.training.booking.type.PaymentType;

public class TicketAuthenticate implements BookingService {

	
	public Collection<Ticket> getTickets() {
		return TicketMock.getTicket();
	}


	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		MerchantFactory merchant = new MerchantFactory();
		MerchPrint m = merchant.getMerchantTypes(merchantType);
		m.printMessage();
		
		PaymentFactory payment = new PaymentFactory();
		TicketMerchant p = new TicketMerchant();
		p.setPaymentMode(payment.getPaymentTypes(paymentType));
		
		return p.bookTicket(id);
	
	}

}
