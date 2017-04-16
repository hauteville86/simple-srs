package pl.karolcyprowski.simple.srs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;

import pl.karolcyprowski.simple.srs.entities.Deck;

@Repository
public class DeckDAOImpl implements DeckDAO {
	
	static Logger logger = Logger.getLogger(DeckDAOImpl.class);

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

	@Override
	public void addDeck(Deck deck) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(deck);
	}

	@Override
	public void deleteDeck(int deckId) throws IllegalArgumentException{
		Session currentSession = sessionFactory.getCurrentSession();
		Deck deck = currentSession.get(Deck.class, deckId);
		currentSession.delete(deck);
		
//		Query query = currentSession.createQuery("delete from Deck where id:=deckId");
//		query.setParameter("deckId", deckId);
//		query.executeUpdate();
	}
}
