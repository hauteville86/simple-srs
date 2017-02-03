package pl.karolcyprowski.simple.srs.scheduler;

import java.util.List;
import java.util.Map;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;

public interface MainScheduler {

	public List<SchedulerUtility> getSchedulerUtilities();

	public void setSchedulerUtilities(List<SchedulerUtility> scheduleUtilities);
	
//	public SchedulerUtility getSchedulerUtilityByName(String name);
	
	public String getUserId();

	public void setUserId(String userId);
}
