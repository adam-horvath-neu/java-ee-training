package hu.training.factories.merchant;

public class OrderViaBookingDotCom extends Merchant {

	@Override
	public void bookTicket(String id) {
		// TODO Auto-generated method stub
		System.out.println("booking.com, id: " + id);
	}

}
