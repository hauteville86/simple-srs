package pl.karolcyprowski.simple.srs.business;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
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
	
	private Map<String, Integer> calculateDaysAddedAndNewSrsStatus(int newSrsLevel, int srsStatus)
	{
		Map<String, Integer> amountAndNewSrsStatus = new HashMap<String, Integer>();
		if(newSrsLevel == 0)
		{
			srsStatus = 0;
		}
		else
		{
			srsStatus = srsStatus + newSrsLevel;
		}
		amountAndNewSrsStatus.put("srsStatus", new Integer(srsStatus));
		Integer amountOfDaysAdded = new Integer(srsStatus * 2);
		amountAndNewSrsStatus.put("daysAdded", amountOfDaysAdded);	
		return amountAndNewSrsStatus;
	}

}
