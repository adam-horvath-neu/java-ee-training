package hu.training.app;

import java.util.Collection;
import java.util.Scanner;

import org.maven.multimodule.booking.core.BookingServiceImpl;

import hu.training.login.LoginBean;
import hu.training.servicelocator.ServiceLocator;
import hu.training.ticket.MerchantEnum.MerchantType;
import hu.training.ticket.PaymentEnum.PymentType;
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
			
			System.out.println("Available Tickets");
			Collection<Ticket> ticket = new BookingServiceImpl().getTickets();
			for(Ticket item: ticket) {
				System.out.println(item);
			}
			
			System.out.println("Add ID:");
			String ticketId = scanner.nextLine();
			
			System.out.println("Add Merchant");
			MerchantType merchantType =  MerchantType.valueOf(scanner.nextLine());
			
			System.out.println("Add Payment mode");
			PymentType paymentType = PymentType.valueOf(scanner.nextLine());
			
		  
		    
		    ServiceLocator.getBooking().bookTicket(ticketId, merchantType, paymentType);
		   
		
		        
		
			
		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();
		
		
		
		
		

	}

}
