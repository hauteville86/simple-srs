package pl.karolcyprowski.simple.srs.scheduler.utilities;

import pl.karolcyprowski.simple.srs.scheduler.ScheduleUtility;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;

public interface UtilityFactory {

	public ScheduleUtility createUtilityFromBackendData(SchedulerUtility source);
}
