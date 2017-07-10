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
	
	public void setNumOfCards(int numOfCards);

	public int getNumOfCardsToReview();

	public void setNumOfCardsToReview(int numOfCardsToReview);
	
	public List<Card> getCardsToReview();
	
	public int getNumOfCardsToReviewInWeek();
	
	public int getNumOfCardsToReviewInMonth();
	
	public int getNumOfCardsToReviewInYear();
}
