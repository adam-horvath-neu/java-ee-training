package hu.training.servicelocator;

import hu.training.authenticate.booking.auth.TicketAuthenticate;
import hu.training.authentication.booking.BookingService;
import hu.training.authenticator.Authenticator;
import hu.training.authenticator.DBAuthenticator;
import hu.training.authenticator.LDAPAuthenticator;

public class ServiceLocator {

	public static Authenticator getDbAuthenticator() {
		return new DBAuthenticator();
	}
	
	public static Authenticator getLDAPAuthenticator() {
		return new LDAPAuthenticator();
		
	}
	
	public static BookingService getBooking() {
		return new TicketAuthenticate();
	}
	
}
