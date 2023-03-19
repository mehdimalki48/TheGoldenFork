package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String full_name;
	private String contact;
	private String email_address;
	private String username;
	private String password;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	protected Set<Order> orders = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	protected Set<Payment> payments = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	protected Set<SiteInfo> site_infos = new HashSet<>();
	
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(String full_name, String contact, String email_address, String username, String password) {
		super();
		this.full_name = full_name;
		this.contact = contact;
		this.email_address = email_address;
		this.username = username;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Set<SiteInfo> getSite_infos() {
		return site_infos;
	}

	public void setSite_infos(Set<SiteInfo> site_infos) {
		this.site_infos = site_infos;
	}   
	
	
	
   
}
