package org.maven.multimodule.booking.core;

import java.util.Arrays;
import java.util.Collection;

import hu.training.ticket.Ticket;

public class TicketMock {

	private final static Collection<Ticket> ticket;
	
	 static {
		 
		 ticket = Arrays.asList(new Ticket[] {
			 
			       new Ticket("01","Student", 200),
			       new Ticket("02","Free", 0),
			       new Ticket("03","Adult", 2000),
			       new Ticket("04","Pensioner Ticket", 100),
			       new Ticket("05","30%", 600),
			       new Ticket("06","50%", 1000)});
	 }
	 public static Collection<Ticket> geTickets() {
		 return ticket;
	 }
	 
	  public static Ticket getTicketById(String Id) {
		  
		  for(Ticket item: ticket) {
			  if(item.getId().equals(Id)) {
				  return item;
			  }
		  }
		  return null;
	  }
	 
}
