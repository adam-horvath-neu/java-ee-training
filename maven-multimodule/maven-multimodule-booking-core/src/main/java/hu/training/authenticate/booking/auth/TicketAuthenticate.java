package hu.training.authenticate.booking.auth;

import java.util.Collection;

import hu.training.authenticate.booking.factories.MerchantFactory;
import hu.training.authenticate.booking.factories.PaymentFactory;
import hu.training.authenticate.booking.pstr.PaymentStrategy;
import hu.training.authenticate.booking.stm.MerchPrint;
import hu.training.authenticate.booking.stm.Merchant;
import hu.training.authenticate.booking.stm.TicketMerchant;
import hu.training.authenticate.booking.type.MerchantType;
import hu.training.authenticate.booking.type.PaymentType;
import hu.training.authentication.booking.BookingService;
import hu.training.authenticator.booking.mock.TicketMock;
import hu.training.authenticator.booking.tckt.Ticket;

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
