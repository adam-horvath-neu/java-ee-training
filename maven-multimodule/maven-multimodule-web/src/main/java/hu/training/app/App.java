package hu.training.app;

import java.util.Scanner;

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
			
			System.out.println("Ezek az elérhető jegyek:");
			System.out.println(ServiceLocator.getBookingService().getTickets());

			System.out.println("Ticket id:");
			String id = scanner.nextLine();

			System.out.println("Choose merchant: (TIXA, TICKETPORTAL, JEGYHU)");
			String merchant = scanner.nextLine();
			MerchantType merchantType = MerchantType.valueOf(merchant); //szebben?

			System.out.println("Choose payment type: (CASH, PAYPAL, BITCOIN)");
			String payment = scanner.nextLine();
			PaymentType paymentType = PaymentType.valueOf(payment); //

			System.out.println("\nYour bill:");
			ServiceLocator.getBookingService().bookTicket(id, merchantType, paymentType);

		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();

	}

}
