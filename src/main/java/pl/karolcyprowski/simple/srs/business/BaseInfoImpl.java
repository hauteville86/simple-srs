package pl.karolcyprowski.simple.srs.business;

import java.util.List;

import pl.karolcyprowski.simple.srs.entities.Deck;

public class BaseInfoImpl implements BaseInfo {

	private List<DeckInfo> decks;
	
	public BaseInfoImpl(List<DeckInfo> decks)
	{
		this.decks = decks;
	}
	
	public BaseInfoImpl()
	{
		
	}

	public List<DeckInfo> getDecks() {
		return decks;
	}

	public void setDecks(List<DeckInfo> decks) {
		this.decks = decks;
	}
	
	public int getNumOfDecks()
	{
		return decks.size();
	}
	
	
}
