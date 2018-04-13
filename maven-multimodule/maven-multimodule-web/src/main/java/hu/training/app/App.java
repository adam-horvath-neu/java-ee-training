package hu.training.app;

import java.util.Collection;
import java.util.Scanner;

import hu.training.booking.ticket.BookingServiceManager;
import hu.training.login.LoginBean;
import hu.training.servicelocator.ServiceLocator;
import hu.training.ticketing.Ticket;
import hu.training.types.MerchantType;
import hu.training.types.PaymentType;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		if (new LoginBean().login(username, password)) {
			System.out.println("Successfull login.");
			System.out.println("Avaible Tickets are the following:");
			Collection<Ticket> tickets = new BookingServiceManager().getTickets();
			for (Ticket ticket : tickets) {
				System.out.println(ticket);
			}
			System.out.println("Choose a ticket by picking an ID: ");
			String ticketId = scanner.nextLine();
			System.out.println("Choose a merchant: ");
			String merchant = scanner.nextLine();
			System.out.println("Choose the payment type: ");
			String payment = scanner.nextLine();
			
			MerchantType merchantType = MerchantType.valueOf(merchant);
			PaymentType paymentType = PaymentType.valueOf(payment);
			
			ServiceLocator.getBookingServiceManager().bookTicket(ticketId, merchantType, paymentType);
			
		} else {
			System.out.println("Failed to login.");
		}

		scanner.close();

	}

}
