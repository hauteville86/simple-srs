package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.scheduler.service.SchedulerService;
import pl.karolcyprowski.simple.srs.user.User;

public class ScheduleUtilityImpl implements ScheduleUtility {

	private String name;
	private Collection<SchedulerAction> actions;
	
	@Autowired
	protected SchedulerService schedulerService;
	
	@Autowired
	protected User user;
	
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

}
