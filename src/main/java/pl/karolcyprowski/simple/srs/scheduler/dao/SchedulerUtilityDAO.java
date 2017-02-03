package pl.karolcyprowski.simple.srs.scheduler.dao;

import java.util.List;
import java.util.Map;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;

public interface SchedulerUtilityDAO {

	public List<SchedulerUtility> getScheduleUtilities(String userId);
}
