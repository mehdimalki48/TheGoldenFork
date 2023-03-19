package metier.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import metier.entities.OrderDetails;

@Local
public interface OrderDetailsLocal {
	public OrderDetails addOrderDetails(OrderDetails od);
	public OrderDetails getOrderDetails(int id);
	public ArrayList<OrderDetails> getAllOrderDetails();
	public void updateOrderDetails(OrderDetails od);
	public void deleteOrderDetails(int id);
}
