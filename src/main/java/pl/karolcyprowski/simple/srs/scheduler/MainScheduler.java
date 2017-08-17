package pl.karolcyprowski.simple.srs.scheduler;

import java.util.List;
import java.util.Map;

import pl.karolcyprowski.simple.srs.module.SimpleSrsModuleCore;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;

public interface MainScheduler extends SimpleSrsModuleCore {

	public List<ScheduleUtility> getScheduleUtilities();

	public void setScheduleUtilities(List<ScheduleUtility> scheduleUtilities);
	
//	public SchedulerUtility getSchedulerUtilityByName(String name);
	
	public String getUserId();

	public void setUserId(String userId);
}
