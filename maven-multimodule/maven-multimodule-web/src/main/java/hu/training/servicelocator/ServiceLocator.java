package hu.training.servicelocator;

import org.maven.multimodule.booking.core.BookingServiceImpl;

import hu.training.authenticator.Authenticator;
import hu.training.authenticator.DBAuthenticator;
import hu.training.authenticator.LDAPAuthenticator;
import hu.training.ticket.service.BookingService;

public class ServiceLocator {

	public static Authenticator getDbAuthenticator() {
		return new DBAuthenticator();
	}
	
	public static Authenticator getLDAPAuthenticator() {
		return new LDAPAuthenticator();
	}
	
	public static BookingService  getBooking() {
		return new BookingServiceImpl();
	}
}
