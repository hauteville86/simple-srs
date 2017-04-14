package pl.karolcyprowski.simple.srs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.karolcyprowski.simple.srs.business.SimpleSrsGlossAlgorithm;
import pl.karolcyprowski.simple.srs.business.SrsButton;
import pl.karolcyprowski.simple.srs.dao.DeckDAO;
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


}
