package metier.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Rating;
import metier.interfaces.RatingLocal;


@Stateless(name="RatingInstance")
public class RatingImpl implements RatingLocal {

	// NB: Since there is only one DB (persistence-unit)
		// you don't even need to specify the name.
		@PersistenceContext(unitName = "ejb-restaurant")
		EntityManager em;
	@Override
	public Rating addRating(Rating r) {
		// TODO Auto-generated method stub
		em.persist(r);
		return r;
	}

	@Override
	public Rating getRating(int id) {
		// TODO Auto-generated method stub
		Rating r = em.find(Rating.class, id);
		if(r == null)
			throw new RuntimeException("Rating Not Found...");
		return r;
	}

	@Override
	public ArrayList<Rating> getRatings() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select r from Rating r");
		return (ArrayList<Rating>) query.getResultList();
	}

	@Override
	public void updateRating(Rating r) {
		// TODO Auto-generated method stub
		Rating rating = getRating(r.getRating_id());
		// Updating...
	}

	@Override
	public void deleteRating(int id) {
		// TODO Auto-generated method stub
		Rating rating = getRating(id);
		em.remove(rating);
	}

}
