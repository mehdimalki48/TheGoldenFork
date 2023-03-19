package metier.session;

import java.util.ArrayList;

import javax.ejb.Local;

import metier.entities.Customer;
import metier.entities.Menu;
import metier.entities.MenuType;
import metier.entities.Order;
import metier.entities.OrderDetails;
import metier.entities.Payment;
import metier.entities.Rating;
import metier.entities.SiteInfo;
import metier.entities.User;

@Local
public interface SessionLocal {
	
	//CUSTOMER
	public Customer addCustomer(Customer c);
	public Customer getCustomer(int id);
	public ArrayList<Customer> getCustomers();
	public void updateCustomer(Customer c);
	public void deleteCustomer(int id);	
	
	// MENU
	public Menu addMenu(Menu m);
	public Menu getMenu(int id);
	public ArrayList<Menu> getMenus();
	public void updateMenu(Menu m);
	public void deleteMenu(int id);
	
	
	//MENU_TYPE
	public MenuType addMenuType(MenuType mt);
	public MenuType getMenuType(int id);
	public ArrayList<MenuType> getMenuTypes();
	public void updateMenuType(MenuType m);
	public void deleteMenuType(int id);
	
	//ORDER
	public Order addOrder(Order o);
	public Order getOrder(int id);
	public ArrayList<Order> getOrders();
	public void updateOrder(Order o);
	public void deleteOrder(int id);
	
	//ORDER_DETAILS
	public OrderDetails addOrderDetails(OrderDetails od);
	public OrderDetails getOrderDetails(int id);
	public ArrayList<OrderDetails> getAllOrderDetails();
	public void updateOrderDetails(OrderDetails od);
	public void deleteOrderDetails(int id);
	
	
	//PAYMENT
	public Payment addPayment(Payment p);
	public Payment getPayment(int id);
	public ArrayList<Payment> getPayments();
	public void updatePayment(Payment p);
	public void deletePayment(int id);
	
	//RATING
	public Rating addRating(Rating r);
	public Rating getRating(int id);
	public ArrayList<Rating> getRatings();
	public void updateRating(Rating r);
	public void deleteRating(int id);
	
	
	//SITE_INFO
	public SiteInfo addSiteInfo(SiteInfo si);
	public SiteInfo getSiteInfo(int id);
	public ArrayList<SiteInfo> getSiteInfos();
	public void updateSiteInfo(SiteInfo si);
	public void deleteSiteInfo(int id);
	
	
	//USER
	public User addUser(User u);
	public User getUser(int id);
	public User getUserByEmail(String email);
	public ArrayList<User> getUsers();
	public void updateUser(User u);
	public void deleteUser(int id);
	
}
