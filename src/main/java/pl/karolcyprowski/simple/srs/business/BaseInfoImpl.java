package pl.karolcyprowski.simple.srs.business;

import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Deck;

public class BaseInfoImpl implements BaseInfo {

	private List<Deck> decks;
	
	public BaseInfoImpl(List<Deck> decks)
	{
		this.decks = decks;
	}

	public List<Deck> getDecks() {
		return decks;
	}

	public void setDecks(List<Deck> decks) {
		this.decks = decks;
	}
	
	public int getNumOfDecks()
	{
		return decks.size();
	}
	
	
}
