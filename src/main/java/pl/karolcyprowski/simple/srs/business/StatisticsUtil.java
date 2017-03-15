package pl.karolcyprowski.simple.srs.business;

public interface StatisticsUtil {
	
	public int[] getAccumulatedNumberOfCardsToReview();
	
	public int[] getCardsPerDay();

	public int getNumberOfCards();

	public int getCardsToReviewAccumulatedDays();

	public void setCardsToReviewAccumulatedDays(int cardsToReviewAccumulatedDays);

	public int getCardsPerDayDays();

	public void setCardsPerDayDays(int cardsPerDayDays);
	
}
