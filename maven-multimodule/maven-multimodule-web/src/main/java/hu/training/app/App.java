package hu.training.app;

import java.util.Scanner;

import hu.training.bookingservice.MerchantType;
import hu.training.bookingservice.PaymentType;
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
			
			System.out.println(ServiceLocator.getBookingService().getTickets());
			System.out.println("Select ID (1-6): ");
			String id = scanner.nextLine();

			for (MerchantType merctypes : MerchantType.values()) {
				System.out.println(merctypes);
			}
			System.out.println("Select Merchant (CAMPUSJEGY, TICKETPORTAL, TIXA): ");
			String merchant = scanner.nextLine();
			MerchantType merchantType = MerchantType.valueOf(merchant);

			for (PaymentType paytypes : PaymentType.values()) {
				System.out.println(paytypes);
			}
			System.out.println("Select Payment Method (CASH, CREDITCARD, PAYPAL): ");
			String payment = scanner.nextLine();
			PaymentType paymentType = PaymentType.valueOf(payment);

			ServiceLocator.getBookingService().bookTicket(id, merchantType, paymentType);
			
		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();

	}

}
