package pl.karolcyprowski.simple.srs.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.karolcyprowski.simple.srs.business.BaseInfo;
import pl.karolcyprowski.simple.srs.business.BaseInfoImpl;
import pl.karolcyprowski.simple.srs.business.DeckInfo;
import pl.karolcyprowski.simple.srs.business.DeckInfoImpl;
import pl.karolcyprowski.simple.srs.dao.CardDAO;
import pl.karolcyprowski.simple.srs.dao.DeckDAO;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

@Service
public class SimpleSrsServiceImpl implements SimpleSrsService {

	@Autowired
	private DeckDAO deckDAO;
	
	@Autowired
	private CardDAO cardDAO;
	
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
		return deckDAO.getDeck(deckId);
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
	
	

}
