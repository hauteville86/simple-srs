package pl.karolcyprowski.simple.srs.scheduler.utilities;

import org.springframework.stereotype.Component;

import pl.karolcyprowski.simple.srs.scheduler.ScheduleUtility;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;

@Component
public class UtilityFactoryImpl implements UtilityFactory {

	public UtilityFactoryImpl()
	{
		
	}
	
	public ScheduleUtility createUtilityFromBackendData(SchedulerUtility source)
	{
		String name = source.getName();
		switch (name) {
		case "list":
			ScheduleUtility listUtility = new ListUtilityImpl();
		case "graph":
			return new GraphUtilityImpl();

		default:
			break;
		}
		return null;
	}
}
