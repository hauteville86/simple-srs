package pl.karolcyprowski.simple.srs.business;

import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

public interface DeckInfo {

	public Deck getDeck();

	public void setDeck(Deck deck);

	public List<Card> getCards();

	public void setCards(List<Card> cards);
	
	public int getNumOfCards();
	
	
}