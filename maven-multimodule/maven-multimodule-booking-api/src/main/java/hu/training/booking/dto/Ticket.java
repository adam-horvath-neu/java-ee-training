package hu.training.booking.dto;

public class Ticket {

	private String id;
	private String eventName;
	private int cost;

	public Ticket(String id, String eventName, int cost) {
		this.id = id;
		this.eventName = eventName;
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	public String getEventName() {
		return eventName;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", eventName=" + eventName + ", cost=" + cost + "]\n";
	}

}
