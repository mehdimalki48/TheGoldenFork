package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SiteInfo
 *
 */
@Entity
@Table(name = "tbl_site_info")
public class SiteInfo implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int site_info_id;
	private String site_name;
	private String description;
	private String contact_info;
	private String address;
	private Date last_update;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	private static final long serialVersionUID = 1L;

	
	// Default Constructor 
	public SiteInfo() {
		super();
	}

	// Constructor using Fields
	
	
	public SiteInfo(int site_info_id, String site_name, String description, String contact_info, String address,
			Date last_update, User user) {
		super();
		this.site_info_id = site_info_id;
		this.site_name = site_name;
		this.description = description;
		this.contact_info = contact_info;
		this.address = address;
		this.last_update = last_update;
		this.user = user;
	}

	
	
	// Getters and Setters
	
	
	public int getSite_info_id() {
		return site_info_id;
	}

	public void setSite_info_id(int site_info_id) {
		this.site_info_id = site_info_id;
	}

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
	
	
}
