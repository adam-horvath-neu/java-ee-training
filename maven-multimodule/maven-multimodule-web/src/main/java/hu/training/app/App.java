package hu.training.app;

import java.util.Collection;
import java.util.Scanner;

import hu.training.bookticket.BookingServiceImpl;
import hu.training.login.LoginBean;
import hu.training.merchant.MerchantType;
import hu.training.payment.PaymentType;
import hu.training.servicelocator.ServiceLocator;
import hu.training.ticketbuilder.Ticket;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		if (new LoginBean().login(username, password)) {
			System.out.println("Successfull login.");
			Collection<Ticket> ticket = new BookingServiceImpl().getTickets();
			System.out.println("Available Tickets:");
			for (Ticket t : ticket) {
				System.out.println(t);
			}
			System.out.println("Select ID (1-5):");
			String id = scanner.nextLine();
			System.out.println("Select Merchant (CAMPUSJEGY, TICKETPORTAL, BOOKINGDOTCOM):");
			MerchantType merchantType = MerchantType.valueOf(scanner.nextLine());
			System.out.println("Select Payment Method (CASH, CREDITCARD, PAYPAL):");
			PaymentType paymentType = PaymentType.valueOf(scanner.nextLine());
			System.out.println("Total:");
			ServiceLocator.getBookingService().bookTicket(id, merchantType, paymentType);
		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();

	}

}
