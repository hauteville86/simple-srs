package pl.karolcyprowski.simple.srs.business;

import java.util.Iterator;

import org.apache.log4j.Logger;

import pl.karolcyprowski.simple.srs.entities.Card;

public class ReviewSessionImpl implements ReviewSession {

	static Logger logger = Logger.getLogger(ReviewSessionImpl.class);
	
	private int reviewDeckId;
	
	private Iterator<Card> reviewCardIterator;
	
	private Card reviewCard;
	
	public ReviewSessionImpl()
	{
		reviewDeckId = 0;
	}

	public int getReviewDeckId() {
		return reviewDeckId;
	}

	public void setReviewDeckId(int reviewDeckId) {
		this.reviewDeckId = reviewDeckId;
	}

	public Iterator<Card> getReviewCardIterator() {
		return reviewCardIterator;
	}

	public void setReviewCardIterator(Iterator<Card> reviewCardIterator) {
		this.reviewCardIterator = reviewCardIterator;
	}
	
	public void clearReviewSession()
	{
		logger.info("Clear review session...");
		reviewDeckId = 0;
		reviewCardIterator = null;
		reviewCard = null;
		logger.info("Review session cleared.");
	}
	
	public boolean isActiveSession()
	{
		return (reviewDeckId != 0 && reviewCardIterator != null);
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		ReviewSessionImpl.logger = logger;
	}

	public Card getReviewCard() {
		return reviewCard;
	}

	public void setReviewCard(Card reviewCard) {
		this.reviewCard = reviewCard;
	}
	
	public boolean hasDeckId(int deckId) {
		return reviewDeckId == deckId;
	}
	
	
}
