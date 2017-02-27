package pl.karolcyprowski.simple.srs.scheduler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pl.karolcyprowski.simple.srs.scheduler.entities.SchedulerUtility;
import pl.karolcyprowski.simple.srs.scheduler.service.SchedulerService;
import pl.karolcyprowski.simple.srs.scheduler.utilities.UtilityFactory;
import pl.karolcyprowski.simple.srs.user.User;
import pl.karolcyprowski.simple.srs.user.UserImpl;

public class MainSchedulerImpl implements MainScheduler{

	@Autowired
	private SchedulerService schedulerService;
	
	@Autowired
	private UtilityFactory utilityFactory;
	
	@Autowired
	private User user;
	
	private List<ScheduleUtility> scheduleUtilities;
	
	private String userId;
	
	static Logger logger = Logger.getLogger(MainSchedulerImpl.class);
	
	public MainSchedulerImpl()
	{
		if(userId != null)
		{
			loadScheduleUtilitiesForBackend();
		}		
	}

	public List<ScheduleUtility> getScheduleUtilities() {
		if(getUserId() != null)
		{
			loadScheduleUtilitiesForBackend();
		}
		return scheduleUtilities;
	}

	public void setScheduleUtilities(List<ScheduleUtility> scheduleUtilities) {
		this.scheduleUtilities = scheduleUtilities;
	}
	
//	public ScheduleUtility getScheduleUtilityByName(String name)
//	{
//		return schedulerUtilities.get(name);
//	}
	
	private void loadScheduleUtilitiesForBackend()
	{
		scheduleUtilities = new LinkedList<ScheduleUtility>();
		try
		{
			List<SchedulerUtility> scheduleUtilitiesFromBackend = schedulerService.loadScheduleUtilitiesFromBackend(userId);
			Iterator<SchedulerUtility> utilitiesFromBackend = scheduleUtilitiesFromBackend.iterator();
			while(utilitiesFromBackend.hasNext())
			{
				SchedulerUtility utilityFromBackend = utilitiesFromBackend.next();
				ScheduleUtility utility = schedulerService.createUtilityFromBackendData(utilityFromBackend);
				scheduleUtilities.add(utility);
			}
		}
		catch(NullPointerException e)
		{
			logger.error(e);
		}
		
	}

	public String getUserId() {
		if(userId == null)
		{
			//get the userId from logged user
			if(user == null)
			{
				user = new UserImpl();
			}
			userId = user.getUserId();
		}
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
