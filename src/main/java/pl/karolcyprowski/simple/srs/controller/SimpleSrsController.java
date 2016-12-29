package pl.karolcyprowski.simple.srs.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.karolcyprowski.simple.srs.business.BaseInfo;
import pl.karolcyprowski.simple.srs.business.DeckInfo;
import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;
import pl.karolcyprowski.simple.srs.service.SimpleSrsService;

@Controller
@RequestMapping("/")
public class SimpleSrsController {

	static Logger logger = Logger.getLogger(SimpleSrsController.class);
	
	@Autowired
	private BaseInfo baseInfo;
	
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
		List<DeckInfo> decks = baseInfo.getDecks();
		for(int i = 0; i < decks.size(); i++)
		{
			DeckInfo deckInfo = decks.get(i);
			int id = deckInfo.getDeck().getId();
			if(id == deckId)
			{
				List<Card> cards = deckInfo.getCards();
				Deck deck = deckInfo.getDeck();
				model.addAttribute("cards", cards);
				model.addAttribute("deck", deck);
				model.addAttribute("deckInfo", deckInfo);
				i = decks.size();
			}
		}		
		return "deck";
	}
	
	@RequestMapping("/startReview")
	public String startReview(@RequestParam("id") int deckId, Model model)
	{
		logger.info("Entering showDeck(deckid=" + deckId + ")");
		List<DeckInfo> decks = baseInfo.getDecks();
		for(int i = 0; i < decks.size(); i++)
		{
			DeckInfo deckInfo = decks.get(i);
			int id = deckInfo.getDeck().getId();
			if(id == deckId)
			{
				List<Card> cards = deckInfo.getCards();
				Deck deck = deckInfo.getDeck();
				model.addAttribute("cards", cards);
				model.addAttribute("deck", deck);
				model.addAttribute("deckInfo", deckInfo);
				i = decks.size();
			}
		}		
		return "review";
	}
}
