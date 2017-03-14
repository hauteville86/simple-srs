package pl.karolcyprowski.simple.srs.business;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

public class StatisticsUtilImpl implements StatisticsUtil {

	private List<Card> cards;
	
	public StatisticsUtilImpl(DeckInfo deckInfo)
	{
		cards = deckInfo.getCards();	
		Collections.sort(cards, new NextReviewComparator());
	}
	
	public int[] getAccumulatedNumberOfCardsToReview(int days)
	{
		int accumulatedReview = 0;
		int[] accumulatedNumberOfCardsPerDay = new int[days];
		int[] cardsPerDay = getCardsPerDay(days);		
		for(int i = 0; i < cardsPerDay.length; i++)
		{
			int dailyReview = cardsPerDay[i];
			accumulatedReview = accumulatedReview + dailyReview;
			accumulatedNumberOfCardsPerDay[i] = accumulatedReview;
		}
		return accumulatedNumberOfCardsPerDay;
	}
	
	public int[] getCardsPerDay(int days)
	{
		int[] cardsPerDay = new int[days];
		int indexForCardsPerDay = 0;
		int numOfCardsPerDay = 0;
		int i = 0;
		Date dateForIndexForCardsPerDay = getDateForDaysInFuture(indexForCardsPerDay);
		while(indexForCardsPerDay >= days && i >= getNumberOfCards())
		{
			Card card = cards.get(i);
			Date cardReviewDate = card.getNextRepeat();
			if(cardReviewDate.getTime() <= dateForIndexForCardsPerDay.getTime())
			{
				numOfCardsPerDay++;
				i++;
			}
			else
			{
				cardsPerDay[indexForCardsPerDay] = numOfCardsPerDay;
				numOfCardsPerDay = 0;
				indexForCardsPerDay++;
			}
		}
		return cardsPerDay;
	}
	
	private Date getDateForDaysInFuture(int days)
	{
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.HOUR, 24*days);
		Date dateForDaysInFuture = calendar.getTime();
		return dateForDaysInFuture;
	}
	
	public int getNumberOfCards()
	{
		return cards.size();
	}
	
}
