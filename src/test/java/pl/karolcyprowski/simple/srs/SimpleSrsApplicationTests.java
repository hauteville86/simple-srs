package pl.karolcyprowski.simple.srs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import pl.karolcyprowski.simple.srs.business.SimpleSrsGlossAlgorithm;
import pl.karolcyprowski.simple.srs.business.SrsButton;
import pl.karolcyprowski.simple.srs.dao.DeckDAO;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;
import pl.karolcyprowski.simple.srs.service.SimpleSrsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleSrsApplicationTests {
	
	@Autowired
	private DeckDAO deckDAO;
	
	@Autowired
	private SimpleSrsService service;

	@Test
	public void contextLoads() {
		SimpleSrsGlossAlgorithm algorithm = new SimpleSrsGlossAlgorithm();
		List<SrsButton> buttonList = algorithm.getButtons();
		int buttonListSize = buttonList.size();
		assertEquals(buttonListSize, 4);
	}
	
	@Test
	public void getLastCreatedDeckByIdAndDeleteIt() {
		int howManyDecksBefore = service.getDecks().size();
		int numberOfCardsForNewDeck = 10;
		Deck deck = createRandomDeckWithCards(numberOfCardsForNewDeck);
		int deckId = deck.getId();
		Deck deckFromService = service.getDeck(deckId);
		int numOfCards = service.getDeckInfo(deckFromService, deckId).getNumOfCards();
		assertNotEquals(null, deckFromService.getId());
		assertEquals(numberOfCardsForNewDeck, numOfCards);
		service.deleteDeck(deckId);
		Deck emptyDeck = service.getDeck(deckId);		
		int howManyDecksAfter = service.getDecks().size();
		assertEquals(howManyDecksBefore, howManyDecksAfter);
	}

	
	private Deck createRandomDeckWithCards(int amountOfCards){
		Deck deck = new Deck("random", "random", "random");
		service.addDeck(deck);
		int deckId = deck.getId();
		for(int i = 0; i < amountOfCards; i++)
		{
			Card card = new Card(deckId);
			service.addCard(card);
		}
		return deck;
	}


}
