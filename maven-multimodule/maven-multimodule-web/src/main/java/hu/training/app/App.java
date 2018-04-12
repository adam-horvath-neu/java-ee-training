package hu.training.app;

import java.util.Collection;
import java.util.Scanner;

import hu.training.booking.Ticket;
import hu.training.booking.authenticate.TicketBooking;
import hu.training.booking.types.MerchantType;
import hu.training.booking.types.PaymentType;
import hu.training.login.LoginBean;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Username:");
		String userName = sc.nextLine();

		System.out.println("Password:");
		String password = sc.nextLine();

		if (new LoginBean().login(userName, password)) {
			System.out.println("Successfull login.");

			System.out.println("Tickets:");

			Collection<Ticket> lista = new TicketBooking().getTickets();

			for (Ticket obj : lista) {
				System.out.println(obj);
			}

			System.out.println("Enter an ID:");
			String id = sc.nextLine();

			System.out.println("Merchant:");
			String merchant = sc.nextLine();

			System.out.println("Payment:");
			String payment = sc.nextLine();

			Ticket tick = new TicketBooking().bookTicket(id, MerchantType.valueOf(merchant),
					PaymentType.valueOf(payment));

			System.out.println(tick);

		} else {
			System.out.println("Failed to login.");
		}
		sc.close();

	}

}
