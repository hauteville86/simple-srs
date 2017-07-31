package pl.karolcyprowski.simple.srs.business;

import java.util.List;
import java.util.Map;

public class EbbinghausAlgorithm implements SrsAlgorithm {
	
	private List<SrsButton> buttons;

	@Override
	public List<SrsButton> getButtons() {
		return buttons;
	}

	@Override
	public void setButtons(List<SrsButton> buttons) {
		this.buttons = buttons;
	}

	@Override
	public Map<String, Object> generateValuesToUpdate(int srsLevel, int srsStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
