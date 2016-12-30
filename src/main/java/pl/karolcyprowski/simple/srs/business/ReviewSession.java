package pl.karolcyprowski.simple.srs.business;

import java.util.Iterator;

import pl.karolcyprowski.simple.srs.entities.Card;

public interface ReviewSession {

	public int getReviewDeckId();

	public void setReviewDeckId(int reviewDeckId);

	public Iterator<Card> getReviewCardIterator();

	public void setReviewCardIterator(Iterator<Card> reviewCardIterator);
	
	public void clearReviewSession();
	
	public boolean isActiveSession();
	
	public Card getReviewCard();

	public void setReviewCard(Card reviewCard);
}
