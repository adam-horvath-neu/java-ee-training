package hu.training.app;

import java.util.Scanner;

import hu.training.booking.BookingService;
import hu.training.booking.Merchant;
import hu.training.booking.MerchantType;
import hu.training.booking.PaymentType;
import hu.training.booking.merchant.Tickething;
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
			System.out.println("Successfull login.");
			
			System.out.println("Available tickets:");
			System.out.println(ServiceLocator.getBookingService().getTickets());
			
			System.out.println("id:");
			String id = scanner.nextLine();
			
			System.out.println("Choose a merchant (ELADO_JEGYEK, JEGYMESTER, TICKETHING)");
			MerchantType merchantType = MerchantType.valueOf(scanner.nextLine());
			
			System.out.println("Choose a payment mode (CASH, CREDIT_CARD, PAYPAL)");
			PaymentType paymentType = PaymentType.valueOf(scanner.nextLine());
			
			System.out.println("\n" + ServiceLocator.getBookingService().bookTicket(id, merchantType, paymentType));
		} else {
			System.out.println("Failed to login.");
		}

		
		scanner.close();

	}

}
