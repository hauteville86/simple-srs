package pl.karolcyprowski.simple.srs.scheduler.utilities;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import pl.karolcyprowski.simple.srs.scheduler.ScheduleUtilityImpl;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.scheduler.service.SchedulerService;
import pl.karolcyprowski.simple.srs.user.User;

public class ListUtilityImpl extends ScheduleUtilityImpl implements ListUtility {
    
	public ListUtilityImpl()
	{
		super();
		this.setName("Example list name");
	}
	
	private void getActionsFromBackend(String userId)
	{
		List<SchedulerAction> actionList = getSchedulerService().getSchedulerActionList(userId);
		setActions(actionList);
	}
}
