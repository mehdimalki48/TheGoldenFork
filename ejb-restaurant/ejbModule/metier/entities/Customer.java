package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */

@Entity
@Table(name = "tbl_customer")
public class Customer implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customer_first_name;
	private String customer_last_name;
	private String customer_middle_name;
	private String customer_email;
	private String customer_phone_number;
	private String customer_landline;
	private Blob profile_image;
	private String customer_username;
	private String customer_password;
	private int account_status;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	protected Set<Order> orders = new HashSet<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	protected Set<Rating> ratings = new HashSet<>();
	
	
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}

	public Customer(int account_status, String customer_email, String customer_first_name, String customer_landline,
			String customer_last_name, String customer_middle_name, String customer_password,
			String customer_phone_number, String customer_username) {
		super();
		this.customer_first_name = customer_first_name;
		this.customer_last_name = customer_last_name;
		this.customer_middle_name = customer_middle_name;
		this.customer_email = customer_email;
		this.customer_phone_number = customer_phone_number;
		this.customer_landline = customer_landline;
		this.customer_username = customer_username;
		this.customer_password = customer_password;
		this.account_status = account_status;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_first_name() {
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public String getCustomer_middle_name() {
		return customer_middle_name;
	}

	public void setCustomer_middle_name(String customer_middle_name) {
		this.customer_middle_name = customer_middle_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_phone_number() {
		return customer_phone_number;
	}

	public void setCustomer_phone_number(String customer_phone_number) {
		this.customer_phone_number = customer_phone_number;
	}

	public String getCustomer_landline() {
		return customer_landline;
	}

	public void setCustomer_landline(String customer_landline) {
		this.customer_landline = customer_landline;
	}

	public Blob getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(Blob profile_image) {
		this.profile_image = profile_image;
	}

	public String getCustomer_username() {
		return customer_username;
	}

	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public int getAccount_status() {
		return account_status;
	}

	public void setAccount_status(int account_status) {
		this.account_status = account_status;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}   
	
}
