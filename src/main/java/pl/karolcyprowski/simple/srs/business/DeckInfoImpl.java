package pl.karolcyprowski.simple.srs.business;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

public class DeckInfoImpl implements DeckInfo {
	
	private static final int DAYS_IN_WEEK = 7;
	private static final int DAYS_IN_MONTH = 30;
	private static final int DAYS_IN_YEAR = 366;

	private Deck deck;
	
	private List<Card> cards;
	
	private int numOfCards;
	private int numOfCardsToReview;
	
	public DeckInfoImpl(Deck deck, List<Card> cards)
	{
		this.deck = deck;
		this.cards = cards;
		updateDeckInfo();	
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
//		List<Card> cardsToReview = new LinkedList<Card>();
//		for(Card card : cards)
//		{
//			if(card.getNextRepeat().before(new Date()))
//			{
//				cardsToReview.add(card);
//			}
//		}
//		return cardsToReview;
		return getCardsToReviewForDate(new Date());
	}

	public int getNumOfCards() {
		return numOfCards;
	}

	public void setNumOfCards(int numOfCards) {
		this.numOfCards = numOfCards;
	}

	public int getNumOfCardsToReview() {
		return numOfCardsToReview;
	}

	public void setNumOfCardsToReview(int numOfCardsToReview) {
		this.numOfCardsToReview = numOfCardsToReview;
	}
	
	private void updateDeckInfo()
	{
		numOfCards = cards.size();
		int cardsToReviewCounter = 0;
		for(Card card : cards)
		{
			if(card.getNextRepeat().before(new Date()))
			{
				cardsToReviewCounter++;
			}
		}
		numOfCardsToReview = cardsToReviewCounter;
	}
	
	private List<Card> getCardsToReviewForDate(Date date) {
		List<Card> cardsToReview = new LinkedList<Card>();
		for(Card card : cards)
		{
			if(card.getNextRepeat().before(date))
			{
				cardsToReview.add(card);
			}
		}
		return cardsToReview;
	}
	
	private Date getFutureDate(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, days);
		return calendar.getTime();
	}
	
	public int getNumOfCardsToReviewInWeek() {
		Date date = getFutureDate(DAYS_IN_WEEK);
		return getCardsToReviewForDate(date).size();
	}
	
	public int getNumOfCardsToReviewInMonth() {
		Date date = getFutureDate(DAYS_IN_MONTH);
		return getCardsToReviewForDate(date).size();
	}
	
	public int getNumOfCardsToReviewInYear() {
		Date date = getFutureDate(DAYS_IN_YEAR);
		return getCardsToReviewForDate(date).size();
	}
	
	
}
