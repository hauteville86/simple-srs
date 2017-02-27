package pl.karolcyprowski.simple.srs.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.karolcyprowski.simple.srs.entities.Card;

@Repository
public class CardDAOImpl implements CardDAO {

	static Logger logger = Logger.getLogger(CardDAO.class);
	
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

	@Override
	public Card getCard(int cardId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Card card = currentSession.get(Card.class, cardId);
		return card;
	}
	
	public void updateCard(int cardId, Map<String, Object> valuesToUpdate)
	{
		logger.info("Updating the card (id=" + cardId + ") with values:");
		logger.info(valuesToUpdate.toString());
		Session currentSession = sessionFactory.getCurrentSession();
		Card card = currentSession.get(Card.class, cardId);
		card.changeWithMap(valuesToUpdate);
		currentSession.saveOrUpdate(card);
	}
	
	public void addCard(Card card)
	{
		logger.info("Adding the card: " + card.toString());
		Session currentSesion = sessionFactory.getCurrentSession();
		currentSesion.saveOrUpdate(card);
	}

	@Override
	public void deleteCardsWithDeckId(int deckId) {
		logger.warn("deleteCardsWithDeckId() method is not implemented!");
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query query = currentSession.createQuery("from Card where card.deckid=" + deckId);
//		query.setParameter("deckId", deckId);
//		query.executeUpdate();	
	}

}
