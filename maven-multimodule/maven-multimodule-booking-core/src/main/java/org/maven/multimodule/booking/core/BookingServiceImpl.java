package org.maven.multimodule.booking.core;

import java.util.Collection;

import Merchant.Merchant;
import Merchant.MerchantFactory;
import Payment.Payment;
import Payment.PaymentFactory;
import hu.training.ticket.MerchantEnum.MerchantType;
import hu.training.ticket.PaymentEnum.PymentType;
import hu.training.ticket.Ticket;
import hu.training.ticket.service.BookingService;

public class BookingServiceImpl  implements BookingService  {

	public Ticket bookTicket(String id, MerchantType merchantType, PymentType paymentType) {
		
		  MerchantFactory merchantFactory = new MerchantFactory();
		  Merchant merchant = merchantFactory.getMerchant(merchantType);
		  
		  PaymentFactory paymentFactory = new PaymentFactory();
		  
		  Payment payment = paymentFactory.getPayment(paymentType);
		  
		  merchant.setPaymentMode(payment);
		  
		  Ticket ticket = merchant.bookTicket(id);
		  
		
		  
		  return ticket;
		
		
	}
	
	public Collection<Ticket> getTickets() {
		return  TicketMock.geTickets();
	}
}
