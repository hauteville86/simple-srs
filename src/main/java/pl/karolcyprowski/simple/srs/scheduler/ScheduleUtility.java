package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Collection;
import java.util.List;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.scheduler.service.SchedulerService;
import pl.karolcyprowski.simple.srs.user.User;

public interface ScheduleUtility {
	
	public String getName();
	
	public void setName(String name);

	public Collection<SchedulerAction> getActions();

	public void setActions(Collection<SchedulerAction> actions);
	
	public SchedulerService getSchedulerService();

	public User getUser();

	public void setSchedulerService(SchedulerService schedulerService);

	public void setUser(User user);
}
