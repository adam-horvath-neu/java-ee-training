package hu.training.booking.authenticate;

import java.util.Collection;

import hu.training.booking.BookingService;
import hu.training.booking.Ticket;
import hu.training.booking.facstr.MerchantFactory;
import hu.training.booking.facstr.PaymentFactory;
import hu.training.booking.merchants.TicketMerchant;
import hu.training.booking.print.Printer;
import hu.training.booking.types.MerchantType;
import hu.training.booking.types.PaymentType;
import hu.trainingő.booking.mock.TicketMock;

public class TicketBooking implements BookingService {

	public Collection<Ticket> getTickets() {
		return TicketMock.getTicket();
	}

	public Ticket bookTicket(String id, MerchantType mType, PaymentType pType) {

		MerchantFactory merchant = new MerchantFactory();
		Printer print = merchant.getMerchantTypes(mType);
		print.printMessage();

		PaymentFactory payment = new PaymentFactory();
		TicketMerchant setPay = new TicketMerchant();
		setPay.setPaymentMode(payment.getPaymentTypes(pType));

		return setPay.bookTicket(id);

	}

}
