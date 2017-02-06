package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Collection;
import java.util.List;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;

public interface ScheduleUtility {
	
	public String getName();
	
	public void setName(String name);

	public Collection<SchedulerAction> getActions();

	public void setActions(Collection<SchedulerAction> actions);
}
