package metier.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.SiteInfo;
import metier.interfaces.SiteInfoLocal;


@Stateless(name="SiteInfoInstance")
public class SiteInfoImpl implements SiteInfoLocal {

	// NB: Since there is only one DB (persistence-unit)
		// you don't even need to specify the name.
		@PersistenceContext(unitName = "ejb-restaurant")
		EntityManager em;
	@Override
	public SiteInfo addSiteInfo(SiteInfo si) {
		// TODO Auto-generated method stub
		em.persist(si);
		return si;
	}

	@Override
	public SiteInfo getSiteInfo(int id) {
		// TODO Auto-generated method stub
		SiteInfo si = em.find(SiteInfo.class, id);
		if (si == null)
			throw new RuntimeException("Site Info Not Found...");
		return si;
	}

	@Override
	public ArrayList<SiteInfo> getSiteInfos() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select s from SiteInfo s");
		return (ArrayList<SiteInfo>) query.getResultList();
	}

	@Override
	public void updateSiteInfo(SiteInfo si) {
		// TODO Auto-generated method stub
		SiteInfo siteInfo = getSiteInfo(si.getSite_info_id());
		// Updating...
	}

	@Override
	public void deleteSiteInfo(int id) {
		// TODO Auto-generated method stub
		SiteInfo si = getSiteInfo(id);
		em.remove(si);
	}

}
