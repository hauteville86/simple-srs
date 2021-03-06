package pl.karolcyprowski.simple.srs.controller;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.karolcyprowski.simple.srs.business.BaseInfo;
import pl.karolcyprowski.simple.srs.business.DeckInfo;
import pl.karolcyprowski.simple.srs.business.ReviewSession;
import pl.karolcyprowski.simple.srs.business.SrsAlgorithm;
import pl.karolcyprowski.simple.srs.business.StatisticsUtil;
import pl.karolcyprowski.simple.srs.business.StatisticsUtilImpl;
import pl.karolcyprowski.simple.srs.dictionary.SRSDictionary;
import pl.karolcyprowski.simple.srs.dictionary.SRSDictionaryImpl;
import pl.karolcyprowski.simple.srs.dictionary.entities.Langcode;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;
import pl.karolcyprowski.simple.srs.entities.User;
import pl.karolcyprowski.simple.srs.scheduler.MainScheduler;
import pl.karolcyprowski.simple.srs.scheduler.ScheduleUtility;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.scheduler.service.SchedulerService;
import pl.karolcyprowski.simple.srs.service.SimpleSrsService;

@Controller
@RequestMapping("/")
public class SimpleSrsController {

	static Logger logger = Logger.getLogger(SimpleSrsController.class);
	
	@Autowired
	private BaseInfo baseInfo;
	
	@Autowired
	private ReviewSession reviewSession;
	
	@Autowired
	private SimpleSrsService simpleSrsService;
	
	@Autowired
	private SrsAlgorithm srsAlgorithm;
	
	@Autowired
	private MainScheduler mainScheduler;
	
	@Autowired
	private SchedulerService schedulerService;
	
	@Autowired
	private SRSDictionary srsDictionary;
	
	private Iterator<Card> cardsIterator;
	
	@RequestMapping("/")
	public String navigateAfterLogon(Model model)
	{
		return showBase(model);
	}
	
	@RequestMapping("/test")
	public String showBase(Model model)
	{
//		createDecksForTestPurposes(true);
		logger.info("Entering showBase()");
		List<DeckInfo> decks = baseInfo.getDecks();
		Deck deck = new Deck();
		model.addAttribute("decks", decks);
		model.addAttribute("deck", deck);
		return "testview";
	}
	
	private void createCardsForTestPurposes(int deckId) {
		for(int i = 0; i < 50; i++)
		{
			logger.info("Add new card for deckid=" + deckId + " with i=" + i);
			Card card = new Card();
			card.setFront("Front " + i);
			card.setBack("Back " + i);
			card.setDeckId(deckId);
			simpleSrsService.addCard(card);
		}	
	}
	
	private void createDecksForTestPurposes(boolean addCards)
	{
		for(int i = 0; i < 5; i++)
		{
			Deck deck = new Deck();
			deck.setName("Name " + i);
			deck.setLanguage("TestLanguage");
			simpleSrsService.addDeck(deck);
			if(addCards)
			{
				createCardsForTestPurposes(i);
			}
		}
		baseInfo = simpleSrsService.generateBaseInfo();
	}

	@RequestMapping("/showDeck")
	public String showDeck(@RequestParam("id") int deckId, Model model)
	{
		logger.info("Entering showDeck(deckid=" + deckId + ")");
		DeckInfo deckInfo = baseInfo.getDeck(deckId);
		List<Card> cards = deckInfo.getCards();
		Deck deck = deckInfo.getDeck();
		Card card = new Card(deckId);
		StatisticsUtil statisticsUtil = new StatisticsUtilImpl(deckInfo);
		model.addAttribute("statisticsUtil", statisticsUtil);
		model.addAttribute("card", card);
		model.addAttribute("cards", cards);
		model.addAttribute("deck", deck);
		model.addAttribute("deckInfo", deckInfo);	
		return "deck";
	}
	
	@RequestMapping("/startReview")
	public String startReview(@RequestParam("id") int deckId, Model model)
	{
		logger.info("Entering startReview(deckid=" + deckId + ")");
		if(reviewSession.isActiveSession() && reviewSession.hasDeckId(deckId))
		{
			logger.info("Review session is still active with id=" + deckId);
			cardsIterator = reviewSession.getReviewCardIterator();
		}
		else
		{
			initializeDeckReview(deckId);
		}
		Card card = reviewSession.getReviewCard();
		if(card == null)
		{
			if(cardsIterator.hasNext())
			{
				card = cardsIterator.next(); 
				reviewSession.setReviewCard(card);
				model.addAttribute("card", card);
				model.addAttribute("buttons", srsAlgorithm.getButtons());
				logger.info("Review the card with id=" + card.getId());
				return "review";
			}
			else
			{
				logger.info("Card iterator is empty. Finish the review session.");
				reviewSession.clearReviewSession();
				baseInfo = simpleSrsService.generateBaseInfo();
				return "endofreviewsession";
			}
		}
		else
		{
			model.addAttribute("card", card);
			model.addAttribute("buttons", srsAlgorithm.getButtons());
			logger.info("Review the card with id=" + card.getId());
			return "review";
		}
		
		
	}
	
	private void initializeDeckReview(int deckId)
	{
		DeckInfo deckInfo = baseInfo.getDeck(deckId);
		List<Card> cardsToReview = deckInfo.getCardsToReview();
		cardsIterator = cardsToReview.iterator();
		logger.info("Create new review session with id=" + deckId);
		reviewSession.setReviewDeckId(deckId);
		reviewSession.setReviewCardIterator(cardsIterator);
		reviewSession.setReviewCard(null);
	}
	
	@RequestMapping("/updateCard")
	public String updateCard(@RequestParam("cardId") int cardId, @RequestParam("srsLevel") int srsLevel, Model model)
	{
		logger.info("Updating card information in progress...");
		logger.info("SrsLevel for card with cardId=" + cardId + " equals to " + srsLevel);
		int cardSrsStatus = reviewSession.getReviewCard().getSrsStatus();
		simpleSrsService.updateCard(cardId, srsLevel, cardSrsStatus);
		updateBaseInfo();
		if(cardsIterator == null)
		{
			cardsIterator = reviewSession.getReviewCardIterator();
			if(cardsIterator == null)
			{
				// Exit the updateCard mapping if cardsIterator hasn't been saved in ReviewSession object
				logger.warn("WARNING: cardsIterator is null");
				List<DeckInfo> decks = baseInfo.getDecks();
				model.addAttribute("decks", decks);
				return "testview";
			}
		}
		if(cardsIterator.hasNext())
		{
			Card card = cardsIterator.next();
			reviewSession.setReviewCard(card);
			model.addAttribute("card", card);
			model.addAttribute("buttons", srsAlgorithm.getButtons());
			logger.info("Review the card with id=" + card.getId());
			return "review";
		}
		else
		{
			logger.info("Card iterator is empty. Finish the review session.");
			reviewSession.clearReviewSession();
			baseInfo = simpleSrsService.generateBaseInfo();
			return "endofreviewsession";
		}	
	}
	
	@RequestMapping("/deleteDeck")
	public String deleteDeck(@RequestParam("id") int deckId, @RequestParam("page") String page, Model model)
	{
		simpleSrsService.deleteDeck(deckId);
		logger.info("Updating base...");
		updateBaseInfo();
		if(page.equals("decklist"))
		{
			return showBase(model);
		}
		return null;
	}
	
	@PostMapping("/addCard")
	public String addCard(@ModelAttribute("card") Card card, Model model)
	{
		logger.info(card);
		simpleSrsService.addCard(card);
		updateBaseInfo();
		int deckId = card.getDeckId();
		return showDeck(deckId, model);
	}
	
	@PostMapping("/addDeck")
	public String addDeck(@ModelAttribute("deck") Deck deck, Model model)
	{
		logger.info(deck);
		simpleSrsService.addDeck(deck);
		updateBaseInfo();
		return showBase(model);
	}
	
	@RequestMapping("/login")
	public String goToLogin()
	{
		return "login";
	}
	
	@RequestMapping("/signup")
	public String goToSignUp(Model model)
	{
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping("/adduser")
	public String addUser(User user)
	{
		logger.info(user);
		simpleSrsService.addUser(user);
		return goToLogin();
	}
	
	@RequestMapping("/scheduler")
	public String scheduler(Model model)
	{
		List<ScheduleUtility> scheduleUtilities = mainScheduler.getScheduleUtilities();
		model.addAttribute("utilities", scheduleUtilities);
		return "scheduler";
	}
	
	@RequestMapping("/addaction")
	public String goToAddAction(Model model)
	{
		SchedulerAction action = new SchedulerAction();
		model.addAttribute("action", action);
		return "addaction";
	}
	
	@RequestMapping("/addNewAction")
	public String goToAddAction(@ModelAttribute("action") SchedulerAction action, Model model)
	{
		logger.info(action);
		schedulerService.addSchedulerAction(action);		
		return scheduler(model);
	}
	
	@RequestMapping("/dictionary")
	public String goToDictionary(Model model)
	{
		
		List<Langcode> langcodes = srsDictionary.getLangcodes();
		Collections.sort(langcodes);
		String languageOne = srsDictionary.getLanguageOne();
		String languageTwo = srsDictionary.getLanguageTwo();
		Map<String, String> langcodesToNames = srsDictionary.getLangcodes().stream()
				.collect(Collectors.toMap(Langcode::getLangcode, Langcode::getLangname));
		model.addAttribute("langcodesOne", langcodes);
		model.addAttribute("langcodesTwo", langcodes);
		model.addAttribute("lang1", langcodesToNames.get(languageOne));
		model.addAttribute("lang2", langcodesToNames.get(languageTwo));
		model.addAttribute("dictionary", srsDictionary);
		return "dictionary";
	}
	
	@RequestMapping("/dictSetLang")
	public String setLangOneInDictionary(@ModelAttribute("name1") String name1, 
			@ModelAttribute("name2") String name2, Model model)
	{
		Map<String, String> langnamesToCodes = srsDictionary.getLangcodes().stream()
				.collect(Collectors.toMap(Langcode::getLangname, Langcode::getLangcode));
		if(name1 != null)
		{
			if(!name1.isEmpty())
			{
				srsDictionary.setLanguageOne(langnamesToCodes.get(name1));
			}			
		}
		if(name2 != null)
		{
			if(!name2.isEmpty())
			{
				srsDictionary.setLanguageTwo(langnamesToCodes.get(name2));
			}			
		}
		return goToDictionary(model);
	}
	
	private void updateBaseInfo()
	{
		baseInfo = simpleSrsService.generateBaseInfo();
		logger.info("Base has been succesfully updated...");
	}
	
	
}
