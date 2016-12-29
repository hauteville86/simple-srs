package pl.karolcyprowski.simple.srs.business;

import java.util.List;

import org.apache.log4j.Logger;

import pl.karolcyprowski.simple.srs.controller.SimpleSrsController;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

public class BaseInfoImpl implements BaseInfo {

	private List<DeckInfo> decks;
	
	static Logger logger = Logger.getLogger(BaseInfoImpl.class);
	
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
	
	public DeckInfo getDeck(int deckId)
	{
		for(int i = 0; i < decks.size(); i++)
		{
			DeckInfo deckInfo = decks.get(i);
			int id = deckInfo.getDeck().getId();
			if(id == deckId)
			{
				return deckInfo;
			}
		}
		logger.warn("Deck with id=" + deckId + " cannot be found!");
		return null;
	}
	
	
}
