package pl.karolcyprowski.simple.srs.business;

import java.util.ArrayList;
import java.util.List;

public class SimpleSrsGlossAlgorithm implements SrsAlgorithm {

	private List<SrsButton> buttons;

	public SimpleSrsGlossAlgorithm()
	{
		List<SrsButton> buttonList = new ArrayList<SrsButton>();
		int numOfButtons = 4;
		for(int i = 0; i < numOfButtons; i++)
		{
			SrsButton button = new SrsButtonImpl();
			button.setSrsLevel(i);
			button.setText(new Integer(i).toString());
			buttonList.add(button);
		}
		buttons = buttonList;
	}
	
	public List<SrsButton> getButtons() {
		return buttons;
	}

	public void setButtons(List<SrsButton> buttons) {
		this.buttons = buttons;
	}
}
