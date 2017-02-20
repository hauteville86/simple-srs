package pl.karolcyprowski.simple.srs.scheduler.utilities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.karolcyprowski.simple.srs.scheduler.ScheduleUtilityImpl;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.user.User;

public class ListUtilityImpl extends ScheduleUtilityImpl implements ListUtility {
	
	
	
	
	public ListUtilityImpl()
	{
		this.setName("Example list name");
		this.getActionsFromBackend();
	}
	
	private void getActionsFromBackend()
	{
		String userId = user.getUserId();
		List<SchedulerAction> actionList = schedulerService.getSchedulerActionList(userId);
		setActions(actionList);
	}
}
