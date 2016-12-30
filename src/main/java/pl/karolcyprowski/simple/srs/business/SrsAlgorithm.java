package pl.karolcyprowski.simple.srs.business;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SrsAlgorithm {

	public List<SrsButton> getButtons();

	public void setButtons(List<SrsButton> buttons);

	public Map<String, Object> generateValuesToUpdate(int srsLevel, int srsStatus);
}
