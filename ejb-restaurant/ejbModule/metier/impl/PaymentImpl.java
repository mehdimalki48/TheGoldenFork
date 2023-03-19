package metier.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Payment;
import metier.interfaces.PaymentLocal;

@Stateless(name="PaymentInstance")
public class PaymentImpl implements PaymentLocal {

	// NB: Since there is only one DB (persistence-unit)
		// you don't even need to specify the name.
		@PersistenceContext(unitName = "ejb-restaurant")
		EntityManager em;
	@Override
	public Payment addPayment(Payment p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p;
	}

	@Override
	public Payment getPayment(int id) {
		// TODO Auto-generated method stub
		Payment payment = em.find(Payment.class, id);
		if(payment == null)
			throw new RuntimeException("Payment Not Found...");
		return payment;
	}

	@Override
	public ArrayList<Payment> getPayments() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select p from Payment p");
		return (ArrayList<Payment>) query.getResultList();
	}

	@Override
	public void updatePayment(Payment p) {
		// TODO Auto-generated method stub
		Payment payment = getPayment(p.getPayment_id());
		// Updating...
	}

	@Override
	public void deletePayment(int id) {
		// TODO Auto-generated method stub
		Payment p = getPayment(id);
		em.remove(p);
	}

}
