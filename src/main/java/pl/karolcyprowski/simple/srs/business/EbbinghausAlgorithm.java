package pl.karolcyprowski.simple.srs.business;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EbbinghausAlgorithm extends SrsAlgorithmImpl {
	
	public EbbinghausAlgorithm()
	{
		super();
	}
	
	public Map<String, Integer> calculateDaysAddedAndNewSrsStatus(int newSrsLevel, int srsStatus)
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
