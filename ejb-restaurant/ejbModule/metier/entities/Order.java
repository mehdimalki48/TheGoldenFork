package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "tbl_order")
public class Order implements Serializable {

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	private Date order_date;
	private double total_amount;
	private int order_status;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	protected Set<OrderDetails> orderDetails = new HashSet<>(); 
	

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	protected Set<Payment> payments = new HashSet<>();


	public Order(Customer customer, Date order_date, double total_amount, int order_status, User user) {
		super();
		this.customer = customer;
		this.order_date = order_date;
		this.total_amount = total_amount;
		this.order_status = order_status;
		this.user = user;
	}


	public Order() {
		super();
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Date getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}


	public double getTotal_amount() {
		return total_amount;
	}


	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}


	public int getOrder_status() {
		return order_status;
	}


	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}


	public Set<Payment> getPayments() {
		return payments;
	}


	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	
	
}
