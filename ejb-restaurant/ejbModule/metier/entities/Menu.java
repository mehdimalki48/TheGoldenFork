package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Menu
 *
 */
@Entity
@Table(name = "tbl_menu")
public class Menu implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menu_id;
	private String menu_name;
	private double price;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "menu_type_id")
	private MenuType menuType;
	private String menu_image;
	private String ingredients;
	private int menu_status;
	private static final long serialVersionUID = 1L;
 
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	protected Set<OrderDetails> orderDetails = new HashSet<>();
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	protected Set<Rating> ratings = new HashSet<>();

	

	public Menu(String ingredients, String menu_image, 
			String menu_name, int menu_status, 
			double price, MenuType menuType) {
		super();
		this.menu_name = menu_name;
		this.price = price;
		this.menuType = menuType;
		this.menu_image = menu_image;
		this.ingredients = ingredients;
		this.menu_status = menu_status;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	public String getMenu_image() {
		return menu_image;
	}

	public void setMenu_image(String menu_image) {
		this.menu_image = menu_image;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public int getMenu_status() {
		return menu_status;
	}

	public void setMenu_status(int menu_status) {
		this.menu_status = menu_status;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Menu() {
		super();
	}
	
}
