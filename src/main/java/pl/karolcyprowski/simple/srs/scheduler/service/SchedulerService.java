package pl.karolcyprowski.simple.srs.scheduler.service;

import java.util.List;
import java.util.Map;

import pl.karolcyprowski.simple.srs.scheduler.ScheduleUtility;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;

public interface SchedulerService {

	public List<SchedulerAction> getSchedulerActionList(int userId);
	
	public void addSchedulerAction(SchedulerAction newAction);

	public List<SchedulerUtility> loadScheduleUtilitiesFromBackend(String userId);
}
