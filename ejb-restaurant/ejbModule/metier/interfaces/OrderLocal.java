package metier.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import metier.entities.Order;

@Local
public interface OrderLocal {
	public Order addOrder(Order o);
	public Order getOrder(int id);
	public ArrayList<Order> getOrders();
	public void updateOrder(Order o);
	public void deleteOrder(int id);
}
