package pl.karolcyprowski.simple.srs.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Deck;
import pl.karolcyprowski.simple.srs.service.SimpleSrsService;

@Controller
@RequestMapping("/")
public class SimpleSrsController {

	static Logger logger = Logger.getLogger(SimpleSrsController.class);
	
	@Autowired
	private SimpleSrsService simpleSrsService;
	
	@RequestMapping("/test")
	public String test(Model model)
	{
		logger.info("Enter:");
		List<Deck> decks = simpleSrsService.getDecks();
		model.addAttribute("decks", decks);
		return "testview";
	}
	
	@RequestMapping("/showDeck")
	public String showDeck(@RequestParam("id") int deckId, Model model)
	{
		List<Card> cards = simpleSrsService.getCards(deckId);
		Deck deck = simpleSrsService.getDeck(deckId);
		model.addAttribute("cards", cards);
		model.addAttribute("deck", deck);
		return "deck";
	}
}
