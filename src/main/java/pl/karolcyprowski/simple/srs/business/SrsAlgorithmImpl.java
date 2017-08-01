package pl.karolcyprowski.simple.srs.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SrsAlgorithmImpl implements SrsAlgorithm {
	
	private List<SrsButton> buttons;
	
	public SrsAlgorithmImpl() {
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
		Map<String, Object> valuesToUpdate = new HashMap<String, Object>();
		Map<String, Integer> daysAddedAndNewSrsStatus = calculateDaysAddedAndNewSrsStatus(srsLevel, srsStatus);
		int amountOfDaysAdded = daysAddedAndNewSrsStatus.get("daysAdded").intValue();
		Integer newSrsStatus = daysAddedAndNewSrsStatus.get("srsStatus");
		GregorianCalendar nextReviewCalendar = new GregorianCalendar();
		Date lastUpdate = nextReviewCalendar.getTime();
		nextReviewCalendar.add(GregorianCalendar.DAY_OF_MONTH, amountOfDaysAdded);
		Date nextReviewDate = nextReviewCalendar.getTime();
		valuesToUpdate.put("mode", "review");
		valuesToUpdate.put("srsStatus", newSrsStatus);
		valuesToUpdate.put("lastUpdate", lastUpdate);
		valuesToUpdate.put("nextRepeat", nextReviewDate);
		return valuesToUpdate;
	}
	
	public Map<String, Integer> calculateDaysAddedAndNewSrsStatus(int newSrsLevel, int srsStatus) {
		return new HashMap<String, Integer>();
	}

}
