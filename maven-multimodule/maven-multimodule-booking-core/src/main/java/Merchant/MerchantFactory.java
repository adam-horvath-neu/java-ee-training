package Merchant;

import hu.training.ticket.MerchantEnum.MerchantType;

public class MerchantFactory {

 public	Merchant getMerchant (MerchantType type) {
		
		switch(type) {
		case TIXA:
			return new Tixa();
			
		case TICKETPORTAL:	
		    
			return new TicketPortal();
			
		case TICKETEXPRESS:
			
			return new Ticketexpress();
			
		default:
			throw new IllegalArgumentException();
		}
	}	
}
