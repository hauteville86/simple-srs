package pl.karolcyprowski.simple.srs.controller;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.karolcyprowski.simple.srs.business.BaseInfo;
import pl.karolcyprowski.simple.srs.business.DeckInfo;
import pl.karolcyprowski.simple.srs.business.ReviewSession;
import pl.karolcyprowski.simple.srs.business.SrsAlgorithm;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;
import pl.karolcyprowski.simple.srs.entities.User;
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
	
	private Iterator<Card> cardsIterator;
	
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
		model.addAttribute("cards", cards);
		model.addAttribute("deck", deck);
		model.addAttribute("deckInfo", deckInfo);	
		return "deck";
	}
	
	@RequestMapping("/startReview")
	public String startReview(@RequestParam("id") int deckId, Model model)
	{
		logger.info("Entering startReview(deckid=" + deckId + ")");
		if(reviewSession.isActiveSession())
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
	}
	
	@RequestMapping("/updateCard")
	public String updateCard(@RequestParam("cardId") int cardId, @RequestParam("srsLevel") int srsLevel, Model model)
	{
		logger.info("Updating card information in progress...");
		logger.info("SrsLevel for card with cardId=" + cardId + " equals to " + srsLevel);
		int cardSrsStatus = reviewSession.getReviewCard().getSrsStatus();
		simpleSrsService.updateCard(cardId, srsLevel, cardSrsStatus);
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
		return ":redirect/test";
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
		return ":redirect/login";
	}
	
	private void updateBaseInfo()
	{
		baseInfo = simpleSrsService.generateBaseInfo();
		logger.info("Base has been succesfully updated...");
	}
	
	
}
