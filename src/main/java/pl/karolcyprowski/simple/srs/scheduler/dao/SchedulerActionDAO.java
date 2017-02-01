package pl.karolcyprowski.simple.srs.scheduler.dao;

import java.util.List;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;

public interface SchedulerActionDAO {

	public List<SchedulerAction> getSchedulerActionList(int userId);
	
	public void addSchedulerAction(SchedulerAction newAction);
	
	
}
