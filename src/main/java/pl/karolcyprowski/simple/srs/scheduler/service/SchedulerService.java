package pl.karolcyprowski.simple.srs.scheduler.service;

import java.util.List;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;

public interface SchedulerService {

	public List<SchedulerAction> getSchedulerActionList(int userId);
	
	public void addSchedulerAction(SchedulerAction newAction);
}
