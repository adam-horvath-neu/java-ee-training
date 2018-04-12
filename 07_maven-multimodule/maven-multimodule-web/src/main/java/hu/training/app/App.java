package hu.training.app;

import java.util.Collection;
import java.util.Scanner;

import hu.training.booking.BookingServiceImpl;
import hu.training.bookingapi.MerchantType;
import hu.training.bookingapi.PaymentType;
import hu.training.bookingapi.Ticket;
import hu.training.login.LoginBean;
import hu.training.servicelocator.ServiceLocator;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		if (new LoginBean().login(username, password)) {
			System.out.println("Successful login. Welcome " + username + "!!");
			//BookingServiceImpl bs = new BookingServiceImpl();
			BookingServiceImpl bs = ServiceLocator.getBookingServiceImpl();
			System.out.println("Avaliable Tickets: ");
			Collection<Ticket> tickets = bs.getTickets();
			tickets.stream().forEach(System.out::println);
			System.out.println("Enter Ticket Id: ");
			String ticketId = scanner.nextLine();
			System.out.println("Merchants: ");
			System.out.println("1. TicketA ");
			System.out.println("2. Tixa ");
			System.out.println("3. Ticketportal ");
			System.out.println("Enter Merchant Id: ");
			String merchant = scanner.nextLine();
			MerchantType mt = null;
			boolean data_is_ok = true;
			switch (merchant) {
			case "1":
				mt = MerchantType.TICKETA;
				break;
			case "2":
				mt = MerchantType.TIXA;
				break;
			case "3":
				mt = MerchantType.TICKETPORTAL;
				break;
			default:
				System.out.println("Merchant doesnt exist!");
				data_is_ok = false;
				break;
			}
			System.out.println("Payment Methods: ");
			System.out.println("1. Cash ");
			System.out.println("2. Credit Card ");
			System.out.println("3. PayPal ");
			System.out.println("Enter the Id of Payment Mehtod: ");
			String pmethod = scanner.nextLine();
			PaymentType pt = null;
			switch (pmethod) {
			case "1":
				pt = PaymentType.CASH;
				break;
			case "2":
				pt = PaymentType.CREDITCARD;
				break;
			case "3":
				pt = PaymentType.PAYPAL;
				break;
			default:
				System.out.println("Payment type doesnt exist!");
				data_is_ok = false;
				break;
			}
			if (data_is_ok)
				System.out.println(bs.bookTicket(ticketId, mt, pt));
		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();

	}

}
