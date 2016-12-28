package pl.karolcyprowski.simple.srs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Repository;

import org.hibernate.*;
import org.hibernate.cfg.*;

import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

@Repository
public class DeckDAOImpl implements DeckDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Deck> getDecks() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from Deck order by id");

		// get the result list
		List<Deck> decks = query.list();

		return decks;
	}

	@Override
	public Deck getDeck(int deckId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Deck deck = currentSession.get(Deck.class, deckId);

		return deck;
	}
}
