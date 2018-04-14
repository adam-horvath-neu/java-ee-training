package hu.training.app;

import java.util.Scanner;

import hu.training.authenticator.ticket.TicketsBooking;
import hu.training.login.LoginBean;
import hu.training.merchant.MerchantType;
import hu.training.payment.PaymentType;
import hu.training.servicelocator.ServiceLocator;
import hu.training.ticket.Ticket;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		if (new LoginBean().login(username, password)) {
			System.out.println("Successfull login.");
			System.out.println("A valasztek:");
			for (Ticket t : ServiceLocator.getBooking().getTickets()) {
				System.out.println(t);
			}
			System.out.println("ID : ");
			String id = scanner.nextLine();
			System.out.println("Merchants: TIXA / TICKETPORTAL / TICKETPRO");
			String merchant = scanner.nextLine();
			MerchantType merchanttype = MerchantType.valueOf(merchant);
			System.out.println("Payments: CASH / CREDITCARD / PAYPAL");
			String payment = scanner.nextLine();
			PaymentType paymenttype = PaymentType.valueOf(payment);
			TicketsBooking b = new TicketsBooking();
			b.bookTicket(id, merchanttype, paymenttype);
		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();

	}

}
