package Merchant;

import java.util.Collection;

import org.maven.multimodule.booking.core.TicketMock;

import Payment.Payment;
import hu.training.ticket.Ticket;

public abstract class Merchant {
	
	private Payment paymentMode;
	private Ticket tickets;


public void setPaymentMode(Payment paymentMode) {
		this.paymentMode = paymentMode;
	}

public Ticket bookTicket (String ticketId) {
	
   tickets = null;
   int cost = 0;
   Collection <Ticket> ticket = TicketMock.geTickets();
   
   for(Ticket item: ticket ) {
	   if(item.getId().equals(ticketId)) {
		   item = tickets;
		   cost = item.getCost();
	   }
	   paymentMode.pay(cost); 
	 System.out.println(tickets.toString());

   }
 
return tickets;
 
    
   
 
 }}
