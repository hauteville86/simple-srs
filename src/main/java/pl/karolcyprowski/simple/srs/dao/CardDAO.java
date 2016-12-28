package pl.karolcyprowski.simple.srs.dao;

import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Card;

public interface CardDAO {

	List<Card> getCards(int deckId);

}
