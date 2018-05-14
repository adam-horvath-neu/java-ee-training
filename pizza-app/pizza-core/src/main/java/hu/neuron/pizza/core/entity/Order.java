package hu.neuron.pizza.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Order extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long price;
	
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	@Lob
	private String description;
	
	@ManyToMany
	private List<Pizza> orderedPizzas;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Address address;
	
	@ManyToOne
	private User user;
	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Pizza> getOrderedPizzas() {
		return orderedPizzas;
	}

	public void setOrderedPizzas(List<Pizza> orderedPizzas) {
		this.orderedPizzas = orderedPizzas;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
