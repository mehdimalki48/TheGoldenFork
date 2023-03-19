package metier.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Menu;
import metier.interfaces.MenuLocal;

@Stateless(name="MenuInstance")
public class MenuImpl implements MenuLocal{

	// NB: Since there is only one DB (persistence-unit)
		// you don't even need to specify the name.
		@PersistenceContext(unitName = "ejb-restaurant")
		EntityManager em;
		
	@Override
	public Menu addMenu(Menu m) {
		// TODO Auto-generated method stub
		em.persist(m);
		return m;
	}

	@Override
	public Menu getMenu(int id) {
		// TODO Auto-generated method stub
		Menu m = em.find(Menu.class, id);
		if(m == null) 
			throw new RuntimeException("Menu Not Found...");
		return m;
	}

	@Override
	public ArrayList<Menu> getMenus() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select m from Menu m ");
		return (ArrayList<Menu>) query.getResultList();
	}

	@Override
	public void updateMenu(Menu m) {
		// TODO Auto-generated method stub
		Menu menu = getMenu(m.getMenu_id());
		// updating
	}

	@Override
	public void deleteMenu(int id) {
		// TODO Auto-generated method stub
		Menu m = getMenu(id);
		em.remove(m);
	}

}
