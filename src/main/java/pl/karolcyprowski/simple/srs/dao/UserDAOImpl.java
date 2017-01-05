package pl.karolcyprowski.simple.srs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.karolcyprowski.simple.srs.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);		
	}

}
