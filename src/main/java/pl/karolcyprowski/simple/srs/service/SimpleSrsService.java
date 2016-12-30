package pl.karolcyprowski.simple.srs.service;

import java.util.List;

import pl.karolcyprowski.simple.srs.business.BaseInfo;
import pl.karolcyprowski.simple.srs.business.DeckInfo;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

public interface SimpleSrsService {

	public List<Deck> getDecks();

	public List<Card> getCards(int deckId);

	public Deck getDeck(int deckId);
	
	public Card getCard(int cardId);

	public DeckInfo getDeckInfo(Deck deck, int deckId);
	
	public BaseInfo generateBaseInfo();
	
	public void updateCard(int cardId, int srsLevel, int srsStatus);

	public void addCard(Card card);

	public void addDeck(Deck deck);
}
