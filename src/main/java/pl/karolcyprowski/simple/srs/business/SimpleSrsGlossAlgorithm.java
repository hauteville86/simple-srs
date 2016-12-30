package pl.karolcyprowski.simple.srs.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleSrsGlossAlgorithm implements SrsAlgorithm {

	private List<SrsButton> buttons;
	
	@Autowired
	private GregorianCalendar currentDate;

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
	
	public Map<String, Object> generateValuesToUpdate(int srsLevel, int srsStatus)
	{
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
			if(srsStatus > 5)
			{
				srsStatus = srsStatus - 5;
			}
			else
			{
				srsStatus = 0;
			}
		}
		else
		{
			srsStatus = srsStatus + newSrsLevel;
		}
		amountAndNewSrsStatus.put("srsStatus", new Integer(srsStatus));
		Integer amountOfDaysAdded = new Integer(srsStatus/5+1);
		amountAndNewSrsStatus.put("daysAdded", amountOfDaysAdded);	
		return amountAndNewSrsStatus;
	}
}
