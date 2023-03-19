package metier.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import metier.entities.SiteInfo;

@Local
public interface SiteInfoLocal {
	public SiteInfo addSiteInfo(SiteInfo si);
	public SiteInfo getSiteInfo(int id);
	public ArrayList<SiteInfo> getSiteInfos();
	public void updateSiteInfo(SiteInfo si);
	public void deleteSiteInfo(int id);
}
