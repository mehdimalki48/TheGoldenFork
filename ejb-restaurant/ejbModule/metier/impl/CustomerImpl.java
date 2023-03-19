package metier.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Customer;
import metier.interfaces.CustomerLocal;

@Stateless(name = "CustomerInstance")
public class CustomerImpl implements CustomerLocal{
	
	// NB: Since there is only one DB (persistence-unit)
	// you don't even need to specify the name.
	@PersistenceContext(unitName = "ejb-restaurant")
	EntityManager em;
	
	
	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		em.persist(c);
		return c;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Customer ct = em.find(Customer.class, id);
		if(ct == null) 
			throw new RuntimeException("Customer Not Found...");
		return ct;
	}

	@Override
	public ArrayList<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select c from Customer c");
		return (ArrayList<Customer>) query.getResultList();
	}

	@Override
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		Customer ct = getCustomer(c.getCustomer_id());
		// updating
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Customer c = getCustomer(id);
		em.remove(c);
	}

}
