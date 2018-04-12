package hu.training.app;

import java.util.Scanner;

import hu.training.bookingservice.BookingService;
import hu.training.login.LoginBean;
import hu.training.servicelocator.ServiceLocator;
import hu.training.ticket.merchant.MerchantType;
import hu.training.ticket.payment.PaymentType;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		if (new LoginBean().login(username, password)) {
			System.out.println("Successfull login.");

			BookingService bs = ServiceLocator.getBookingService();

			System.out.println("\nAvailable tickets: \n" + bs.getTickets());

			System.out.println("Ticket id:");
			String id = scanner.nextLine();

			System.out.println("Choose merchant: (TIXA, TICKETPORTAL, JEGYHU)");
			String merchantScanner = scanner.nextLine();

			System.out.println("Choose payment type: (CASH, PAYPAL, BITCOIN)");
			String paymentScanner = scanner.nextLine();

			System.out.println("\n-------------------------------------------------------");
			MerchantType merchantType = MerchantType.valueOf(merchantScanner); // ENUM érték
			PaymentType paymentType = PaymentType.valueOf(paymentScanner); // ENUM érték
			bs.bookTicket(id, merchantType, paymentType);

		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();

	}

}
