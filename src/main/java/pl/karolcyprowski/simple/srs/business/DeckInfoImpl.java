package pl.karolcyprowski.simple.srs.business;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

public class DeckInfoImpl implements DeckInfo {

	private Deck deck;
	
	private List<Card> cards;
	
	public DeckInfoImpl(Deck deck, List<Card> cards)
	{
		this.deck = deck;
		this.cards = cards;
	}
	
	public int getNumOfCards()
	{
		return cards.size();
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public List<Card> getCardsToReview()
	{
		List<Card> cardsToReview = new LinkedList<Card>();
		for(Card card : cards)
		{
			if(card.getNextRepeat().before(new Date()))
			{
				cardsToReview.add(card);
			}
		}
		return cardsToReview;
	}
	
	
}
