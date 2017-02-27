package pl.karolcyprowski.simple.srs.scheduler.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.karolcyprowski.simple.srs.scheduler.ScheduleUtility;
import pl.karolcyprowski.simple.srs.scheduler.ScheduleUtilityImpl;
import pl.karolcyprowski.simple.srs.scheduler.dao.SchedulerActionDAO;
import pl.karolcyprowski.simple.srs.scheduler.dao.SchedulerUtilityDAO;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerAction;
import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;
import pl.karolcyprowski.simple.srs.scheduler.utilities.GraphUtilityImpl;
import pl.karolcyprowski.simple.srs.scheduler.utilities.ListUtilityImpl;
import pl.karolcyprowski.simple.srs.service.SimpleSrsServiceImpl;
import pl.karolcyprowski.simple.srs.user.User;

@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService {

	static Logger logger = Logger.getLogger(SchedulerServiceImpl.class);
	
	@Autowired
	private User user;
	
	@Autowired
	private SchedulerActionDAO schedulerActionDAO;
	
	@Autowired
	private SchedulerUtilityDAO schedulerUtilityDAO;
	
	public SchedulerServiceImpl()
	{
		logger.info("SchedulerService initiated");
	}
	
	@Override
	@Transactional
	public List<SchedulerAction> getSchedulerActionList(String userId)
	{
		return schedulerActionDAO.getSchedulerActionList(userId);
	}
	
	@Override
	@Transactional
	public void addSchedulerAction(SchedulerAction newAction)
	{
		newAction = getCompleteSchedulerAction(newAction);
		schedulerActionDAO.addSchedulerAction(newAction);
	}
	
	@Override
	@Transactional
	public List<SchedulerUtility> loadScheduleUtilitiesFromBackend(String userId)
	{
		List<SchedulerUtility> scheduleUtilities = new LinkedList<SchedulerUtility>();
		if(userId == null)
		{
			return scheduleUtilities;
		}
		scheduleUtilities = schedulerUtilityDAO.getScheduleUtilities(userId);
		return scheduleUtilities;
	}
	
	@Override
	@Transactional
	public ScheduleUtility createUtilityFromBackendData(SchedulerUtility source)
	{
		List<SchedulerAction> schedulerActions = getSchedulerActionList(user.getUserId());
		ScheduleUtility utility = new ScheduleUtilityImpl(); //basic impementation
		String name = source.getName();
		switch (name) {
		case "list":
			utility = new ListUtilityImpl();			
		case "graph":
			utility = new GraphUtilityImpl();
		default:
			break;
		}
		utility.setActions(schedulerActions);
		return utility;
	}
	
	private SchedulerAction getCompleteSchedulerAction(SchedulerAction action)
	{
		if(action.getUser() == null)
		{
			action.setUser(user.getUserId());
		}
		return action;
	}
}
