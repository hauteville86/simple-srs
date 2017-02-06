package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Collection;
import java.util.List;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;

public class ScheduleUtilityImpl implements ScheduleUtility {

	private String name;
	private Collection<SchedulerAction> actions;
	
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
