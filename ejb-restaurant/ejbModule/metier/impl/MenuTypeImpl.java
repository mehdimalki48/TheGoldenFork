package metier.impl;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.MenuType;
import metier.interfaces.MenuTypeLocal;


@Stateless(name="MenutypeInstance")
public class MenuTypeImpl implements MenuTypeLocal {

	// NB: Since there is only one DB (persistence-unit)
		// you don't even need to specify the name.
		@PersistenceContext(unitName = "ejb-restaurant")
		EntityManager em;
		
	@Override
	public MenuType addMenuType(MenuType m) {
		// TODO Auto-generated method stub
		em.persist(m);
		return m;
	}

	@Override
	public MenuType getMenuType(int id) {
		// TODO Auto-generated method stub
		MenuType mt = em.find(MenuType.class, id);
		if(mt == null) throw new RuntimeException("MenuType Not Found...");
		return mt;
	}

	@Override
	public ArrayList<MenuType> getMenuTypes() {
//		Query query = em.createQuery("select mt from MenuType mt");
//		return query.getResultList();
		Query query = em.createQuery("select m from MenuType m");
		if(query.getResultList().isEmpty())
			return new ArrayList<MenuType>();
		return (ArrayList<MenuType>)query.getResultList();
	}

	@Override
	public void updateMenuType(MenuType m) {
		// TODO Auto-generated method stub
		MenuType mt = getMenuType(m.getMenu_type_id());
		// Updating...
	}

	@Override
	public void deleteMenuType(int id) {
		// TODO Auto-generated method stub
		MenuType mt = getMenuType(id);
		em.remove(mt);
	}

}
