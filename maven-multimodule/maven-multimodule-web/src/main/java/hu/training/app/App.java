package hu.training.app;

import java.util.Collection;
import java.util.Scanner;
import hu.training.login.LoginBean;
import hu.training.ticket.MerchantType;
import hu.training.ticket.PaymentType;
import hu.training.ticket.Ticket;
import hu.training.ticket.booking.Booking;
import hu.training.ticket.booking.TicketMock;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		if (new LoginBean().login(username, password)) {
			System.out.println("Successfull login.");

			Collection<Ticket> tickets = TicketMock.getTickets();
			for (Ticket t : tickets) {
				System.out.println(t.toString());
			}

			System.out.println("The ticket you would like to buy: ");

			String id = scanner.nextLine();

			System.out.println("Which merchant would you like to choose (BestBuy, ShopOnline, Vouchers): ");

			String merchantString = scanner.nextLine();

			System.out.println("Which payment would you like to choose (Card, Cash, Crypto Currency, PayPal): ");

			String paymentString = scanner.nextLine();

			new Booking().bookTicket(id, whichMerchant(merchantString), whichPayment(paymentString));
		} else {
			System.out.println("Failed to login. Unable to make a payment.");
		}

		scanner.close();

	}

	public static MerchantType whichMerchant(String str) {
		if (str.equalsIgnoreCase("BESTBUY")) {
			return MerchantType.BESTBUY;
		}

		else if (str.equalsIgnoreCase("SHOPONLINE")) {
			return MerchantType.SHOPONLINE;
		}

		else if (str.equalsIgnoreCase("VOUCHERS")) {
			return MerchantType.VOUCHERS;
		}

		return null;
	}

	public static PaymentType whichPayment(String str) {
		if (str.equalsIgnoreCase("CARD")) {
			return PaymentType.CARD;
		}

		else if (str.equalsIgnoreCase("CASH")) {
			return PaymentType.CASH;
		}

		else if (str.equalsIgnoreCase("CRYPTO CURRENCY")) {
			return PaymentType.CRYPTO_CURRENCY;
		}

		else if (str.equalsIgnoreCase("PAYPAL")) {
			return PaymentType.PAYPAL;
		}

		return null;
	}

}
