package pl.karolcyprowski.simple.srs.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.karolcyprowski.simple.srs.business.BaseInfo;
import pl.karolcyprowski.simple.srs.business.BaseInfoImpl;
import pl.karolcyprowski.simple.srs.business.DeckInfo;
import pl.karolcyprowski.simple.srs.business.DeckInfoImpl;
import pl.karolcyprowski.simple.srs.business.SrsAlgorithm;
import pl.karolcyprowski.simple.srs.dao.CardDAO;
import pl.karolcyprowski.simple.srs.dao.DeckDAO;
import pl.karolcyprowski.simple.srs.dao.UserDAO;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;
import pl.karolcyprowski.simple.srs.entities.User;

@Service
public class SimpleSrsServiceImpl implements SimpleSrsService {

	static Logger logger = Logger.getLogger(SimpleSrsServiceImpl.class);
	
	@Autowired
	private DeckDAO deckDAO;
	
	@Autowired
	private CardDAO cardDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private SrsAlgorithm srsAlgorithm;
	
	@Override
	@Transactional
	public List<Deck> getDecks() {
		return deckDAO.getDecks();
	}

	@Override
	@Transactional
	public List<Card> getCards(int deckId) {
		return cardDAO.getCards(deckId);
	}

	@Override
	@Transactional
	public Deck getDeck(int deckId) {
		try{
			return deckDAO.getDeck(deckId);
		} catch (IllegalArgumentException e) {
			logger.warn(e);
			return new Deck();
		}
		
	}

	@Override
	@Transactional
	public Card getCard(int cardId) {
		return cardDAO.getCard(cardId);
	}

	@Override
	@Transactional
	public DeckInfo getDeckInfo(Deck deck, int deckId) {
		List<Card> cards = getCards(deckId);
		if(deck == null)
		{
			deck = getDeck(deckId);
		}	
		DeckInfo deckInfo = new DeckInfoImpl(deck, cards);
		return deckInfo;
	}

	@Override
	@Transactional
	public BaseInfo generateBaseInfo() {
		BaseInfo baseInfo = new BaseInfoImpl();
		List<Deck> decksEntities = getDecks();
		List<DeckInfo> decks = new LinkedList<DeckInfo>();
		for(Deck deckEntity : decksEntities)
		{
			DeckInfo deckInfo = getDeckInfo(deckEntity, deckEntity.getId());
			decks.add(deckInfo);
		}
		baseInfo.setDecks(decks);;
		return baseInfo;	
	}

	@Override
	@Transactional
	public void updateCard(int cardId, int srsLevel, int srsStatus) {
		Map<String, Object> valuesToUpdate = srsAlgorithm.generateValuesToUpdate(srsLevel, srsStatus);
		cardDAO.updateCard(cardId, valuesToUpdate);
	}
	
	@Transactional
	public void addCard(Card card)
	{
		cardDAO.addCard(card);
	}

	@Override
	@Transactional
	public void addDeck(Deck deck) {
		deckDAO.addDeck(deck);
	}

	@Override
	@Transactional
	public void deleteDeck(int deckId) {
		try{
			deckDAO.deleteDeck(deckId);
			cardDAO.deleteCardsWithDeckId(deckId);
		} catch(IllegalArgumentException e) {
			logger.warn(e);
		}
		
	}
	
	@Override
	@Transactional
	public void addUser(User user)
	{
		userDAO.addUser(user);
	}

}
