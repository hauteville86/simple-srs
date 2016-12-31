package pl.karolcyprowski.simple.srs.dao;

import java.util.List;
import java.util.Map;

import pl.karolcyprowski.simple.srs.entities.Card;

public interface CardDAO {

	public List<Card> getCards(int deckId);

	public Card getCard(int cardId);

	public void updateCard(int cardId, Map<String, Object> valuesToUpdate);

	public void addCard(Card card);

	public void deleteCardsWithDeckId(int deckId);

}
