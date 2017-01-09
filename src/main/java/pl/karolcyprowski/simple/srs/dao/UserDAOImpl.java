package pl.karolcyprowski.simple.srs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import pl.karolcyprowski.simple.srs.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void addUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		user.setPassword(passwordEncoder.encode(user.getPassword()));		
		currentSession.saveOrUpdate(user);		
	}

}
