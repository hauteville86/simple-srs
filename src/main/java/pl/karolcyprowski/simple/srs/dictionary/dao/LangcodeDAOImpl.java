package pl.karolcyprowski.simple.srs.dictionary.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.karolcyprowski.simple.srs.dictionary.entities.Langcode;

@Repository
public class LangcodeDAOImpl implements LangcodeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Langcode> getLangcodes()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Langcode");
		return query.list();
	}
}
