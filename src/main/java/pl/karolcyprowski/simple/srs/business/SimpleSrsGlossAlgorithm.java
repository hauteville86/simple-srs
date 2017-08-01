package pl.karolcyprowski.simple.srs.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleSrsGlossAlgorithm extends SrsAlgorithmImpl {

	public SimpleSrsGlossAlgorithm()
	{
		super();
	}
	
	@Override
	public Map<String, Integer> calculateDaysAddedAndNewSrsStatus(int newSrsLevel, int srsStatus)
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
