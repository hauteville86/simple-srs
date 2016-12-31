package pl.karolcyprowski.simple.srs.dao;

import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Deck;

public interface DeckDAO {

	public List<Deck> getDecks();

	public Deck getDeck(int deckId);

	public void addDeck(Deck deck);

	public void deleteDeck(int deckId);
}
