package hu.training.login;

import hu.training.authenticator.Authenticator;
import hu.training.authenticator.dto.User;
import hu.training.booking.BookingService;
import hu.training.servicelocator.ServiceLocator;
import hu.training.types.MerchantType;
import hu.training.types.PaymentType;

public class LoginBean {
	
	public boolean login(String username, String password) {
		Authenticator authenticator = ServiceLocator.getDbAuthenticator();
		return authenticator.authenticate(new User(username, password));
	}
	
//	public boolean ticket(String id, MerchantType merchantType,PaymentType paymentType) {
//		BookingService manager = ServiceLocator.getBookingServiceManager();
//		return manager.bookTicket(id, merchantType, paymentType);
//	}

}
