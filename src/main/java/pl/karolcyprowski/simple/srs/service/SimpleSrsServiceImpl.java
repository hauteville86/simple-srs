package pl.karolcyprowski.simple.srs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
