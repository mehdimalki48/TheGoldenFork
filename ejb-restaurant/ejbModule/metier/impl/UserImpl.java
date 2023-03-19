package metier.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.User;
import metier.interfaces.UserLocal;

@Stateless(name="UserInstance")
public class UserImpl implements UserLocal {

	// NB: Since there is only one DB (persistence-unit)
		// you don't even need to specify the name.
		@PersistenceContext(unitName = "ejb-restaurant")
		EntityManager em;
	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		em.persist(u);
		return u;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		User user = getUser(id);
		if (user == null)
			throw new RuntimeException("User Not Found...");
		return user;
	}

	@Override
	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select u from User u");
		return (ArrayList<User>) query.getResultList();
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		User user = getUser(u.getUser_id());
		// Updating...
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = getUser(id);
		em.remove(user);
	}

}
