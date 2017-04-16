package pl.karolcyprowski.simple.srs.dictionary.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.karolcyprowski.simple.srs.dictionary.entities.DictionaryItem;

@Repository
public class DictionaryItemDAOImpl implements DictionaryItemDAO {
	
	static Logger logger = Logger.getLogger(DictionaryItemDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<DictionaryItem> getItems(String langcode)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from DictionaryItem where langcode='" + langcode + "'");
		return query.list();
		
	}
	
	public List<DictionaryItem> getAllItems()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from DictionaryItem");
		return query.list();
	}
	
	public DictionaryItem getItem(int id, String langcode)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from DictionaryItem where id=" + id + " and langcode='" + langcode + "'");
		try{
			List<DictionaryItem> list = query.list();
			return list.get(0);
//			return (DictionaryItem)(query.iterate().next());
		} catch (NullPointerException e)
		{
			logger.warn(e);
			return null;
		}
	}
	
	public List<DictionaryItem> getItems(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from DictionaryItem where id=" + id );
		return query.list();
	}
	
	public void addItem(DictionaryItem item)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(item);
	}
}
