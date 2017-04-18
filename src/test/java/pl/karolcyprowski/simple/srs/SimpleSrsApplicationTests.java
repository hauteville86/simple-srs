package pl.karolcyprowski.simple.srs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.karolcyprowski.simple.srs.business.SimpleSrsGlossAlgorithm;
import pl.karolcyprowski.simple.srs.business.SrsButton;
import pl.karolcyprowski.simple.srs.dictionary.SRSDictionary;
import pl.karolcyprowski.simple.srs.dictionary.SRSDictionaryImpl;
import pl.karolcyprowski.simple.srs.dictionary.entities.DictionaryItem;
import pl.karolcyprowski.simple.srs.dictionary.entities.Langcode;
import pl.karolcyprowski.simple.srs.dictionary.service.DictionaryService;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;
import pl.karolcyprowski.simple.srs.service.SimpleSrsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleSrsApplicationTests {
	
	static Logger logger = Logger.getLogger(SimpleSrsApplicationTests.class);
	
	@Autowired
	private SimpleSrsService service;
	
	@Autowired
	private DictionaryService dictionaryService;

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
		int howManyDecksAfter = service.getDecks().size();
		assertEquals(howManyDecksBefore, howManyDecksAfter);
	}
	
	@Test
	public void checkCsvPath()
	{
		File file = new File("src/main/webapp/resources/csv/zzz.csv");
		logger.info("Absolute path: " + file.getAbsolutePath());
		logger.info(file.toString());
		assertEquals(true, file.canRead());
		assertEquals(true, file.exists());	
	}
	
	@Test
	public void checkCsvRead()
	{
		File file = new File("src/main/webapp/resources/csv/zzz.csv");
		String csvSplitBy = ",";
		String line = "";
		int counter = 0;
		try{
			BufferedReader bf = new BufferedReader(new FileReader(file));
			while((line = bf.readLine()) != null) 
			{
				String[] wordlist = line.split(csvSplitBy);
				counter++;
				assertNotEquals("", wordlist[0]);
				switch(counter){
				case 22:
					assertEquals("geluk", wordlist[2]);
					logger.info(wordlist[3]);
					break;
				default:
					break;
				}
			}
			assertEquals(true, counter > 1940);
			bf.close();
		}catch(FileNotFoundException e){
			logger.warn(e);
			assertEquals(true, false);
		}catch(IOException e){
			logger.warn(e);
			assertEquals(true, false);
		}		
	}
	
	@Test
	public void readLangcodes()
	{
		List<Langcode> langcodes = dictionaryService.getLangcodes();
		assertEquals(true, langcodes.size() >= 53);
		Map<String, String> langcodeMap = convertLangcodesToMap(langcodes);
		assertEquals("Afrikaans", langcodeMap.get("AF"));
	}
	
	@Test
	public void readRussian()
	{
		DictionaryItem item = dictionaryService.getItem(1, "RU");
		assertEquals("симпатия", item.getWord());
	}
	
	@Test
	public void readListOfWordsWithGivenIndex()
	{
		int id = 40; //security
		long time = System.currentTimeMillis();
		List<DictionaryItem> items = dictionaryService.getItems(id);
		Map<String, String> itemsMap = items.stream()
				.collect(Collectors.toMap(DictionaryItem::getLangcode, DictionaryItem::getWord));
		logger.info("readListOfWordsWithGivenIndex: " + (System.currentTimeMillis()-time) + "ms");
		assertEquals("de veiligheid", itemsMap.get("NL"));
		assertEquals("trygghet", itemsMap.get("NO"));
	}
	
	
	
	@Test
	public void readDirectoryItems()
	{
		List<DictionaryItem> items = dictionaryService.getAllItems();
		assertEquals(true, items.size() > 0);
	}
	
	@Test
	public void langcodesAreNotEmpty()
	{
		assertEquals(true, new SRSDictionaryImpl().getLangcodes().size() > 0);
	}
	
	
	
	
	private Map<String, String> convertLangcodesToMap(List<Langcode> langcodes)
	{
		Map<String, String> map = new HashMap<String, String>();
		for(Langcode langcode : langcodes)
		{
			map.put(langcode.getLangcode(), langcode.getLangname());
		}
		return map;
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
