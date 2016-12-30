package pl.karolcyprowski.simple.srs.controller;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.karolcyprowski.simple.srs.business.BaseInfo;
import pl.karolcyprowski.simple.srs.business.DeckInfo;
import pl.karolcyprowski.simple.srs.business.ReviewSession;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;

@Controller
@RequestMapping("/")
public class SimpleSrsController {

	static Logger logger = Logger.getLogger(SimpleSrsController.class);
	
	@Autowired
	private BaseInfo baseInfo;
	
	@Autowired
	private ReviewSession reviewSession;
	
	@RequestMapping("/test")
	public String showBase(Model model)
	{
		logger.info("Entering showBase()");
		List<DeckInfo> decks = baseInfo.getDecks();
		model.addAttribute("decks", decks);
		return "testview";
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
		Iterator<Card> cardsIterator;
		if(reviewSession.isActiveSession())
		{
			logger.info("Review session is still active with id=" + deckId);
			cardsIterator = reviewSession.getReviewCardIterator();
		}
		else
		{
			DeckInfo deckInfo = baseInfo.getDeck(deckId);
			List<Card> cardsToReview = deckInfo.getCardsToReview();
			cardsIterator = cardsToReview.iterator();
			logger.info("Create new review session with id=" + deckId);
			reviewSession.setReviewDeckId(deckId);
			reviewSession.setReviewCardIterator(cardsIterator);
			reviewSession.setValueChecked(false);
		}
		if(cardsIterator.hasNext())
		{
			Card card = cardsIterator.next();
			model.addAttribute("card", card);
			logger.info("Review the card with id=" + card.getId());
			return "review";
		}
		else
		{
			logger.info("Card iterator is empty. Finish the review session.");
			reviewSession.clearReviewSession();
			return "endofreviewsession";
		}
	}
}
