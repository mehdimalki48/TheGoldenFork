package metier.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Order;
import metier.interfaces.OrderLocal;


@Stateless(name="OrderInstance")
public class OrderImpl implements OrderLocal {

	// NB: Since there is only one DB (persistence-unit)
		// you don't even need to specify the name.
		@PersistenceContext(unitName = "ejb-restaurant")
		EntityManager em;
	@Override
	public Order addOrder(Order o) {
		// TODO Auto-generated method stub
		em.persist(o);
		return o;
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		Order or = em.find(Order.class, id);
		if (or == null)
			throw new RuntimeException("Order Not Found...");
		return or;
	}

	@Override
	public ArrayList<Order> getOrders() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select o from Order o");
		return (ArrayList<Order>) query.getResultList();
	}

	@Override
	public void updateOrder(Order o) {
		// TODO Auto-generated method stub
		Order order = getOrder(o.getOrder_id());
		// Updating...
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		Order order = getOrder(id);
		em.remove(order);
	}

}
