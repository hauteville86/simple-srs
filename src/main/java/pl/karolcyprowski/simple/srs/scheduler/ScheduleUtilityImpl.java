package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.scheduler.service.SchedulerService;
import pl.karolcyprowski.simple.srs.user.User;

public class ScheduleUtilityImpl implements ScheduleUtility {

	@Autowired
	private SchedulerService schedulerService;
	
	@Autowired
	private User user;
	
	private String name;
	private Collection<SchedulerAction> actions;
	
	public ScheduleUtilityImpl()
	{
		
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	public Collection<SchedulerAction> getActions() {
		return actions;
	}

	public void setActions(Collection<SchedulerAction> actions) {
		this.actions = actions;
	}

	public SchedulerService getSchedulerService() {
		return schedulerService;
	}

	public User getUser() {
		return user;
	}

	public void setSchedulerService(SchedulerService schedulerService) {
		this.schedulerService = schedulerService;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
