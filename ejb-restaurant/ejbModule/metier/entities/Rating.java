package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rating
 *
 */
@Entity
@Table(name = "tbl_rating")
public class Rating implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rating_id;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "menu_id")
	private Menu menu;
	private int score;
	private String remarks;
	private Date date_recorded;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	private static final long serialVersionUID = 1L;

	
	// Default Constructor
	public Rating() {
		super();
	}


	public Rating(int rating_id, Menu menu, int score, String remarks, Date date_recorded, Customer customer) {
		super();
		this.rating_id = rating_id;
		this.menu = menu;
		this.score = score;
		this.remarks = remarks;
		this.date_recorded = date_recorded;
		this.customer = customer;
	}


	public int getRating_id() {
		return rating_id;
	}


	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Date getDate_recorded() {
		return date_recorded;
	}


	public void setDate_recorded(Date date_recorded) {
		this.date_recorded = date_recorded;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}   
   
	
	
}
