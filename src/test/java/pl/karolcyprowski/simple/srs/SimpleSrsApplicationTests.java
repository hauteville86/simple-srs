package pl.karolcyprowski.simple.srs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.karolcyprowski.simple.srs.business.SimpleSrsGlossAlgorithm;
import pl.karolcyprowski.simple.srs.business.SrsButton;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleSrsApplicationTests {

	@Test
	public void contextLoads() {
		SimpleSrsGlossAlgorithm algorithm = new SimpleSrsGlossAlgorithm();
		List<SrsButton> buttonList = algorithm.getButtons();
		int buttonListSize = buttonList.size();
		assertEquals(buttonListSize, 4);
	}

}
