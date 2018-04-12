package hu.training.app;

import java.util.Scanner;

import hu.training.booking.auth.TicketAuthenticate;
import hu.training.booking.stm.TicketMerchant;
import hu.training.booking.tckt.Ticket;
import hu.training.booking.type.MerchantType;
import hu.training.booking.type.PaymentType;
import hu.training.login.LoginBean;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		if (new LoginBean().login(username, password)) {
			System.out.println("Successfull login.");
			System.out.println("The following tickets are aviable");
			
			for (Ticket t : new TicketAuthenticate().getTickets()) {
				System.out.println(t);
			}
			System.out.println("Select one ticket by ID");
			String id = scanner.nextLine();
			System.out.println("Choose one merchant type from te list : TIXA, TICKETPORTAL, SZALLASHU");
			String merchant = scanner.nextLine();
			System.out.println("Choose one payment type from te list : CASH, PAYPAL, BANKCARD");
			String payment = scanner.nextLine();
			Ticket types =new TicketAuthenticate().bookTicket(id, MerchantType.valueOf(merchant), PaymentType.valueOf(payment));
			System.out.println(types);
			
		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();

	}

}
