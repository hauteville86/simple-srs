package pl.karolcyprowski.simple.srs.business;

import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Deck;

public interface BaseInfo {

	public List<Deck> getDecks();
	
	public void setDecks(List<Deck> decks);
}
