package pl.karolcyprowski.simple.srs.service;

import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

public interface SimpleSrsService {

	public List<Deck> getDecks();

	public List<Card> getCards(int deckId);

	public Deck getDeck(int deckId);
}
