package hu.training.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import hu.training.booking.dto.Ticket;
import hu.training.booking.merchant.MerchantFactory;
import hu.training.booking.payment.PaymentStrategyFactory;
import hu.training.booking.ticket.TicketsMock;

public class Booking implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketsMock.getTickets();
	}

	public Ticket bookTicket(String id, MerchantType merchantType, PaymentType paymentType) {
		MerchantFactory merchantFactory = new MerchantFactory();
		Merchant merchant = merchantFactory.getMerchant(merchantType);
		PaymentStrategyFactory paymentStrategyFactory = new PaymentStrategyFactory();
		PaymentStrategy payment = paymentStrategyFactory.getPayment(paymentType);
		merchant.setPaymentMode(paymentStrategyFactory.getPayment(paymentType));
		Collection<Ticket> tickets = new ArrayList<Ticket>();
		tickets = TicketsMock.getTickets();
		List<Ticket> ticket = tickets.stream().filter(x -> x.getId().equals(id)).collect(Collectors.toList());
		if (ticket.isEmpty()) {
			System.out.println("Error: ticket not found");
		} else {
			System.out.println("---------");
			System.out.println(ticket.get(0));
			merchant.printMessage();
			payment.pay(ticket.get(0).getCost());
		}
		// if (ticket.get(0) != null) {
		// System.out.println("Fasza");
		// } else {
		// System.out.println("Nem fasza");
		// }

		return ticket.get(0);
	}

}
