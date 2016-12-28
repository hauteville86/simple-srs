package pl.karolcyprowski.simple.srs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

@Repository
public class CardDAOImpl implements CardDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Card> getCards(int deckId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from Card where deckid=" + deckId);

		// get the result list
		List<Card> cards = query.list();
		
		return cards;
	}

}
