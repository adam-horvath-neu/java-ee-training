package hu.training.ticket.service;

import java.util.Collection;

import hu.training.ticket.MerchantEnum;
import hu.training.ticket.PaymentEnum;
import hu.training.ticket.Ticket;


public interface BookingService {
	
	Collection<Ticket> getTickets();
	
  public Ticket bookTicket(String id, MerchantEnum.MerchantType merchantType, PaymentEnum.PymentType paymentType);
	
	
}
