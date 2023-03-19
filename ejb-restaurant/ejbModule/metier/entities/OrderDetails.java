package metier.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrderDetails
 *
 */
@Entity
@Table(name = "tbl_order_details")
public class OrderDetails implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_details_id;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "menu_id")
	private Menu menu;
	private int no_of_serving;
	private double total_amount;
	private static final long serialVersionUID = 1L;

	public OrderDetails() {
		super();
	}

	public OrderDetails(Order order, Menu menu, int no_of_serving, double total_amount) {
		super();
		this.order = order;
		this.menu = menu;
		this.no_of_serving = no_of_serving;
		this.total_amount = total_amount;
	}

	public int getOrder_details_id() {
		return order_details_id;
	}

	public void setOrder_details_id(int order_details_id) {
		this.order_details_id = order_details_id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getNo_of_serving() {
		return no_of_serving;
	}

	public void setNo_of_serving(int no_of_serving) {
		this.no_of_serving = no_of_serving;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}   
	
	
}
