package hu.training.app;

import java.util.Collection;
import java.util.Scanner;

import hu.training.booking.ticket.TicketsMock;
import hu.training.login.LoginBean;
import hu.training.ticketing.Ticket;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		if (new LoginBean().login(username, password)) {
			System.out.println("Successfull login.");
		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();

		System.out.println("Avaible Tickets are the following:");
		Collection<Ticket> tickets = TicketsMock.getTickets();
		for (Ticket ticket : tickets) {
			System.out.println(
					"ID: " + ticket.getId() + ", Event: " + ticket.getEventName() + ",Cost: " + ticket.getCost());
		}

		scanner = new Scanner(System.in);
		System.out.println("Choose a ticket by picking an ID: ");
		String ticketId = scanner.nextLine();
		System.out.println("Choose a merchant: ");
		String merchantType = scanner.nextLine();
		System.out.println("Choose the payment type: ");
		String paymentType = scanner.nextLine();

		scanner.close();

	}

}
