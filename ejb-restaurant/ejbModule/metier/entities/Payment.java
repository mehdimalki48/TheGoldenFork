package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Payment
 *
 */
@Entity
@Table(name = "tbl_payment")
public class Payment implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "order_id")
	private Order order;
	private double amount;
	private String paid_by;
	private Date payment_date;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id")
	private User user;
	private static final long serialVersionUID = 1L;

	public Payment() {
		super();
	}

	public Payment(int payment_id, Order order, double amount, String paid_by, Date payment_date, User user) {
		super();
		this.payment_id = payment_id;
		this.order = order;
		this.amount = amount;
		this.paid_by = paid_by;
		this.payment_date = payment_date;
		this.user = user;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaid_by() {
		return paid_by;
	}

	public void setPaid_by(String paid_by) {
		this.paid_by = paid_by;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
   
	
	
}
