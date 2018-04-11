package hu.training.authenticator.booking.tckt;

public class Ticket {

	String id;
	String eventName;
	int cost;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Ticket(String id, String eventName, int cost) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.cost = cost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", eventName=" + eventName + ", cost=" + cost + "]";
	}

}
