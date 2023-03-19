package metier.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import metier.entities.Customer;

@Local
public interface CustomerLocal {
	public Customer addCustomer(Customer c);
	public Customer getCustomer(int id);
	public ArrayList<Customer> getCustomers();
	public void updateCustomer(Customer c);
	public void deleteCustomer(int id);	
}
